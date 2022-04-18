package com.ss.leetcode.LC2022.april;

import java.util.Arrays;

public class InsertInterval {
    // https://leetcode.com/problems/insert-interval/
    public int[][] insert(int[][] intervals, int[] newInterval) {
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
