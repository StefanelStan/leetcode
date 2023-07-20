package com.ss.leetcode.LC2023.july;

import java.util.Arrays;

public class NonOverlappingIntervals {
    // https://leetcode.com/problems/non-overlapping-intervals
    /** Algorithm
        1. Sort the intervals by startTime. If they have equal startTime, sort reversed by endtime.
            EG: [1,7], [1,5],[1,3], [2,6],[3,5]
        2. If intervals have the same start time, always delete the current interval as it's longer [3,7],[3,5]
        3. If intervals do not overlap, continue
        4. If intervals overlap: (current and next)
            - If next interval ends before currentInterval, ([3,7],[4,6]) delete current interval and keep 4,6
            - If current ends before the next interval [3,7],[4,9], delete next interval and keep 3,7
         5. Return the number of deletions;
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        int deletions = 0;
        Arrays.sort(intervals, (a,b) -> (a[0] == b[0] ? Integer.compare(b[1],a[1]) : Integer.compare(a[0],b[0])));
        int[] prev = intervals[0], current;
        for (int i = 1; i < intervals.length; i++) {
            current = intervals[i];
            if (prev[0] != current[0]) {
                if (prev[1] > current[0]) {
                    deletions++;
                    if (prev[1] >= current[1]) {
                        prev = current;
                    }
                } else {
                    prev = current;
                }
            } else {
                deletions++;
                prev = current;
            }
        }
        return deletions;
    }
}
