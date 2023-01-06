package com.ss.leetcode.LC2023.january;

import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons {
    // https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
    public int findMinArrowShots(int[][] points) {
        int arrows = 1;
        int minPoint;
        Arrays.sort(points, (a,b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        minPoint = points[0][1];
        for (int[] baloon : points) {
            if (minPoint >= baloon[0]) {
                minPoint = Math.min(minPoint, baloon[1]);
            } else {
                arrows++;
                minPoint = baloon[1];
            }
        }
        return arrows;
    }
}
