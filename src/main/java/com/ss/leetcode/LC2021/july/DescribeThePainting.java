package com.ss.leetcode.LC2021.july;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DescribeThePainting {
    // https://leetcode.com/contest/biweekly-contest-57/problems/describe-the-painting/
    /** Algorithm
        1. Use a long[][2] colorLine matrix to mark the indices of where segments open and close
            - colorLine[i][0] to add the openings (+color)
            - colorLine[i + 1][1] to add the closings (-color)
        2. Traverse segments and mark the start/end of each color segment (colorLine[start][0] , colorLine[end + 1][1])
        3. Traverse colorLine with 2 pointers (left, right) that will mark the current window color
        4. At each step, check if current segment ends (line[i+1][1] != 0) or if a new segment starts
            - add to list of answers the segment
     */
    public List<List<Long>> splitPainting(int[][] segments) {
        long[][] colorLine = getColorLine(segments);
        List<List<Long>> description = new ArrayList<>();
        long lineSum = 0L;
        for (int left = 0, right = 0; right < colorLine.length - 1; right++) {
            if (colorLine[right + 1][1] != 0) {
                description.add(List.of((long)left, (long)right, lineSum));
                lineSum += colorLine[right + 1][1];
                left = right;
            }
            if (colorLine[right][0] > 0) {
                if(lineSum == 0) { // don't add any segment
                    left = right;
                    lineSum += colorLine[right][0];
                } else {
                    if (left != right) {
                        description.add(List.of((long)left, (long)right, lineSum));
                    }
                    lineSum += colorLine[right][0];
                    left = right;
                }
            }
        }
        return description;
    }

    private long[][] getColorLine(int[][] segments) {
        int maxLength = 0;
        for (int[] segment : segments) {
            maxLength = Math.max(maxLength, segment[1]);
        }
        long[][] colorLine = new long[maxLength + 2][2];
        for (int[] segment : segments) {
            colorLine[segment[0]][0] += segment[2];
            colorLine[segment[1] + 1][1] -= segment[2];
        }
        return colorLine;
    }

    // WRONG
    public List<List<Long>> splitPainting2(int[][] segments) {
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
