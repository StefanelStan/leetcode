package com.ss.leetcode.LC2022.april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InsertInterval {
    // https://leetcode.com/problems/insert-interval/
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        List<int[]> insertList = new ArrayList<>();
        checkEdgeCases(intervals, newInterval, insertList);
        if (insertList.isEmpty()) {
            mergeIntervals(intervals, newInterval, insertList);
        }
        return toArray(insertList);
    }

    private void mergeIntervals(int[][] intervals, int[] newInterval, List<int[]> insertList) {
        int left = binarySearch(intervals, newInterval[0]);
        int right = binarySearch(intervals, newInterval[1]);
        for (int i = 0; i < left; i++) {
            insertList.add(intervals[i]);
        }
        int[] mergedInterval = getMergedInterval(intervals, left, right, newInterval);
        insertList.add(mergedInterval);
        right += mergedInterval[1] < intervals[right][0] ? 0 : 1;
        for (; right < intervals.length; right++) {
            insertList.add(intervals[right]);
        }
    }

    private int[] getMergedInterval(int[][] intervals, int left, int right, int[] newInterval) {
        int[] candidate = {intervals[left][0], newInterval[1]};
        // put left
        candidate[0] = Math.min(candidate[0], newInterval[0]);
        //put right
        if (newInterval[1] < intervals[right][0]) {
            candidate[1] = Math.max(candidate[1], newInterval[1]);
        } else {
            candidate[1] = Math.max(intervals[right][1], newInterval[1]);
        }
        return candidate;
    }

    private int binarySearch(int[][] intervals, int element) {
        int left = 0, right = intervals.length - 1, pivot;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (intervals[pivot][0] <= element && element <= intervals[pivot][1]) {
                return pivot;
            } else if (element > intervals[pivot][1]) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return Math.min(left, intervals.length -1);
    }

    private void checkEdgeCases(int[][] intervals, int[] newInterval, List<int[]> insertList) {
        if (newInterval[1] < intervals[0][0]) {
            insertList.add(newInterval);
            Collections.addAll(insertList, intervals);
        } else if (newInterval[0] > intervals[intervals.length -1][1]) {
            Collections.addAll(insertList, intervals);
            insertList.add(newInterval);
        } else if (newInterval[0] <= intervals[0][0] && newInterval[1] >= intervals[intervals.length -1][1]) {
            insertList.add(newInterval);
        }
    }

    /**
     *  1. Traverse intervals and add ALL the intervals that have start < newInterval[0]
     *  2. Add new interval
     *  3. Add rest of intervals.
     *  4. Now all of them are sorted by start time
     *  5. Run again and merge them.
     */
    public int[][] insert3(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        List<int[]> addedIntervals = addToIntervals(intervals, newInterval);
        for (int[] i : addedIntervals) {
            System.out.println(Arrays.toString(i));
        }
        List<int[]> mergedIntervals = mergeIntervals(addedIntervals);
        return toArray(mergedIntervals);
    }

    private List<int[]> mergeIntervals(List<int[]> intervals) {
        List<int[]> merged = new ArrayList<>();
        int[] candidate = intervals.get(0), current;
        for (int i = 1; i < intervals.size(); i++) {
            current = intervals.get(i);
            if (candidate[1] >= current[0]) {
                candidate[1] = Math.max(candidate[1], current[1]);
            } else {
                merged.add(candidate);
                candidate = current;
            }
        }
        merged.add(candidate);
        return merged;
    }

    private List<int[]> addToIntervals(int[][] intervals, int[] newInterval) {
        List<int[]> insertList = new ArrayList<>(intervals.length + 1);
        int i = 0;
        while (i < intervals.length && intervals[i][0] < newInterval[0]) {
            insertList.add(intervals[i]);
            i++;
        }
        insertList.add(newInterval);
        while (i < intervals.length) {
            insertList.add(intervals[i]);
            i++;
        }
        return insertList;
    }

    private int[][] toArray(List<int[]> insertList) {
        int[][] array = new int[insertList.size()][2];
        for (int i =0; i < insertList.size(); i++) {
            array[i] = insertList.get(i);
        }
        return array;
    }





    public int[][] insert2(int[][] intervals, int[] newInterval) {
        // find edge cases first. Before all, after all
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        if (newInterval[1] < intervals[0][0]) {
            return insertAtTheBeginning(intervals, newInterval);
        } else if (newInterval[0] > intervals[intervals.length -1][1]) {
            return insertAtTheEnd(intervals, newInterval);
        }
        // find first interval insert
        int firstIndex = getInsertIndex(intervals, newInterval);
        // find second interval insert
        int[] secondIndex =  { getEndingInterval(intervals, newInterval, firstIndex) };
        // now you got left and right. Manage them
        int[][] merged = new int[intervals.length + 1][2];
        int mergeIndex = 0;
        // loop from 0 to firstIndex
        for (int i = 0; i < firstIndex; i++) {
            System.arraycopy(intervals[i], 0, merged[mergeIndex], 0, 2);
            mergeIndex++;
        }
        // get merged interval from first index to second index
        int[] mergedInterval = getMergedInterval(intervals, newInterval, firstIndex, secondIndex);
        System.arraycopy(mergedInterval, 0, merged[mergeIndex++], 0, 2);
        // loop from secondIndex _1 to end.
        for (int i = secondIndex[0] + 1; i < intervals.length; i++) {
            System.arraycopy(intervals[i], 0, merged[mergeIndex], 0, 2);
            mergeIndex++;
        }
        return Arrays.copyOf(merged, mergeIndex);
    }

    private int[][] insertAtTheBeginning(int[][] intervals, int[] newInterval) {
        int[][] insert = new int[intervals.length + 1][2];
        System.arraycopy(newInterval, 0, insert[0], 0, 2);
        for (int i = 0; i < intervals.length; i++) {
            System.arraycopy(intervals[i], 0, insert[i + 1], 0, 2);
        }
        return insert;
    }

    private int[][] insertAtTheEnd(int[][] intervals, int[] newInterval) {
        int[][] insert = new int[intervals.length + 1][2];
        System.arraycopy(newInterval, 0, insert[insert.length - 1], 0, 2);
        for (int i = 0; i < intervals.length; i++) {
            System.arraycopy(intervals[i], 0, insert[i], 0, 2);
        }
        return insert;
    }

    private int getInsertIndex(int[][] intervals, int[] newInterval) {
        for(int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] >= newInterval[0]) {
                return i;
            }
        }
        return -1;
    }

    private int getEndingInterval(int[][] intervals, int[] newInterval, int start) {
        if (intervals[intervals.length -1][0] < newInterval[1]) {
            return intervals.length -1;
        }
        for (int i = start; i < intervals.length; i++) {
            if (intervals[i][1] >= newInterval[1]) {
                return i;
            }
        }
        return intervals.length -1;
    }

    private int[] getMergedInterval(int[][] intervals, int[] newInterval, int firstIndex, int[] secondIndex) {
        int[] merge = new int[2];
        merge[0] = Math.min(newInterval[0], intervals[firstIndex][0]);
        if (intervals[secondIndex[0]][0] <= newInterval[1]) {
            merge[1] = Math.max(newInterval[1], intervals[secondIndex[0]][1]);
        } else {
            merge[1] = newInterval[1];
            secondIndex[0]--;
        }
        return merge;
    }
}
