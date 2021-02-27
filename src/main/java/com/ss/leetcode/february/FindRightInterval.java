package com.ss.leetcode.february;

import java.util.TreeMap;

public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        if (intervals == null || intervals.length == 1) {
            return new int[]{-1};
        }
        TreeMap<Integer, Integer> startingMap = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            startingMap.put(intervals[i][0], i);
        }

        int highestEntry  = startingMap.lastEntry().getKey();
        int[] solution = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            solution[i] = getRightIntervalFor(intervals[i][1], startingMap, highestEntry);
        }

        return solution;
    }

    private int getRightIntervalFor(int end, TreeMap<Integer, Integer> startingMap, int highestEntry) {
        while(end <= highestEntry) {
            Integer entry = startingMap.get(end);
            if (entry != null) {
                return entry;
            } else {
                end++;
            }
        }
        return -1;
    }
}
