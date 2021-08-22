package com.ss.leetcode.august;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    // https://leetcode.com/problems/merge-intervals/
    public int[][] merge(int[][] intervals) {
        List<int[]> intervalList = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int[] candidateInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= candidateInterval[1]) {
                candidateInterval[1] = Math.max(candidateInterval[1], intervals[i][1]);
            } else {
                intervalList.add(candidateInterval);
                candidateInterval = intervals[i];
            }
        }
        intervalList.add(candidateInterval);
        int[][] mergedIntervals =  new int[intervalList.size()][2];
        for (int i = 0; i < intervalList.size(); i++) {
            mergedIntervals[i] = intervalList.get(i);
        }
        return mergedIntervals;
    }
}
