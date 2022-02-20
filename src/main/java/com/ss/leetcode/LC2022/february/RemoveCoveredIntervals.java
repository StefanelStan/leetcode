package com.ss.leetcode.LC2022.february;

import java.util.Arrays;

public class RemoveCoveredIntervals {
    // https://leetcode.com/problems/remove-covered-intervals/
    public int removeCoveredIntervals(int[][] intervals) {
        int removedIntervals = 0;
        Arrays.sort(intervals, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        for (int i = intervals.length -1; i >= 1; i--) {
            for (int j = i-1; j >=0; j--) {
                if (intervals[j][1] >= intervals[i][1]) {
                    removedIntervals++;
                    break;
                }
            }
        }
        return intervals.length - removedIntervals;
    }
}
