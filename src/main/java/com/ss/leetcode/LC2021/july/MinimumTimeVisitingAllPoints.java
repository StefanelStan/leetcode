package com.ss.leetcode.LC2021.july;

import java.awt.geom.Point2D;

public class MinimumTimeVisitingAllPoints {
    // https://leetcode.com/problems/minimum-time-visiting-all-points/
    public int minTimeToVisitAllPoints(int[][] points) {
        int answer = 0;
        for (int i = 1; i < points.length; i++) {
            answer += Math.max(getDifference(points[i-1][0], points[i][0]), getDifference(points[i-1][1], points[i][1]));
        }
        return answer;
    }

    private int getDifference(int c1, int c2) {
        if (c1 == c2) return 0;
        int min = Math.min(c1, c2);
        int max = Math.max(c1, c2);
        if (min < 0 && max < 0) {
            return - (min - max);
        }
        return max - min;
    }
}
