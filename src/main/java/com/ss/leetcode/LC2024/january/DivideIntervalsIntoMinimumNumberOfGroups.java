package com.ss.leetcode.LC2024.january;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DivideIntervalsIntoMinimumNumberOfGroups {
    // https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups
    /** Algorithm
        1. Use two arrays: start[1_000_001] and stop[1_000_001]
        2. For each interval, mark beginning and end on start[begin_interval]++ and stop[end_interval]++
        3. Traverse start & stop and keep track of how many active intervals you have
            - increment activeIntervals by start[i]
            - set maxActiveIntervals(maxActiveIntervals, activeIntervals)
            - decrement activeIntervals by end[i].
        4. EG: intervals [1,100],[2,4],[4,5],[6,7]
            - when you reach 1, increment activeIntervals and set maxActive (active = 1, maxActive =1)
            - when you reach 2, increment again (active =2, maxActive = 2)
            - when you reach 4, increment again (active = 3, maxActive = 3), but also decrement by 1, as end[4] == 1
                so active = 2, maxActive =3
            - when you reach 5, decrement active by 1 (because end[5] = 1); active = 1, maxActive =3
            - when you reach 6, increment active by 2 (active = 1, maxActive = 3)
            - .. 7: decrement by 1: active =1, maxActive = 3
            - .. 100:decrement by 1: active =0.
        5. Return maxActiveIntervals
     */
    public int minGroups(int[][] intervals) {
        int[] start = new int[1_000_001];
        int[] stop = new int[1_000_001];
        int left = Integer.MAX_VALUE, right = 0;
        for (int[] interval : intervals) {
            right = Math.max(right, interval[0]);
            left = Math.min(left, interval[0]);
            start[interval[0]]++;
            stop[interval[1]]++;
        }
        int activeIntervals = 0, maxActiveIntervals = 0;
        for (int i = left; i <= right; i++) {
            activeIntervals += start[i];
            maxActiveIntervals = Math.max(maxActiveIntervals, activeIntervals);
            activeIntervals -= stop[i];
        }
        return maxActiveIntervals;
    }


    // this method used an List<> to keep the ends of each interval. With new addition, it loops from
    // beginning to end to find the first suitable append/pop place.
    public int minGroups2(int[][] intervals) {
        List<Integer> groups = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < intervals.length; i++) {
            findGroup(i, intervals, groups);
        }
        return groups.size();
    }

    private void findGroup(int index, int[][] intervals, List<Integer> groups) {
        for (int i = 0; i < groups.size(); i++) {
            if (intervals[groups.get(i)][1] < intervals[index][0]) {
                groups.set(i, index);
                return;
            }
        }
        groups.add(index);
    }
}
