package com.ss.leetcode.LC2021.july;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DescribeThePainting {
    // https://leetcode.com/contest/biweekly-contest-57/problems/describe-the-painting/
    public List<List<Long>> splitPainting(int[][] segments) {
        List<List<Long>> results = new LinkedList<>();
        ColorMix[] intervals = new ColorMix[100_000];
        int min = Integer.MAX_VALUE, max = 0;
        for (int[] segment: segments) {
            for (int i = segment[0]; i <=segment[1] -1; i++) {
                if (intervals[i] == null) {
                    intervals[i] = new ColorMix();
                }
                intervals[i].addColor(segment[2]);
            }
            if (segment[0] < min) {
                min = segment[0];
            }
            if (segment[1] > max) {
                max = segment[1];
            }
        }
        boolean intervalMode = false;
        int intervalStart = 0;
        for (int i = min; i <= max; i++) {
            if (intervals[i] == null && intervalMode) {
                intervalMode = false;
                results.add(List.of((long)intervalStart, (long)i, intervals[intervalStart].sum));
            } else if (intervals[i] != null && intervals[i].sum != 0) {
                if (!intervalMode) {
                    intervalMode = true;
                    intervalStart = i;
                } else {
                    if (intervals[i].sum != intervals[intervalStart].sum) {
                        results.add(List.of((long)intervalStart, (long)i, intervals[intervalStart].sum));
                        intervalStart = i;
                    } else if (intervals[i].sum == intervals[intervalStart].sum && intervals[i].hashSum != intervals[intervalStart].hashSum) {
                        results.add(List.of((long)intervalStart, (long)i, intervals[intervalStart].sum));
                        intervalStart = i;
                    }
                }
            }
        }

        if(intervals[intervals.length -1] != null && intervals[intervals.length -1].sum != 0) {
            results.add(List.of((long)intervalStart, (long)intervals.length -1, intervals[intervalStart].sum));
        }

        return results;
    }

    private static class ColorMix {
        long sum;
        int hashSum = 0;

        public void addColor(int color) {
            sum += color;
            hashSum += (sum + color % 7);
        }
    }
}
