package com.ss.leetcode.LC2022.april;

import java.util.Arrays;

public class MinCostToConnectAllPoints {
    // https://leetcode.com/problems/min-cost-to-connect-all-points/
    // not really connecting all points :)
    public int minCostConnectPoints(int[][] points) {
        if(points.length == 1) {
            return 0;
        }
        boolean[] connected = new boolean[points.length];
        int minCost = 0;
        for (int i = 0; i < points.length; i++) {
            if (!connected[i]) {
                minCost += connect(i, points, connected);
            }
        }
        return minCost;
    }

    private int connect(int pointIndex, int[][] points, boolean[] connected) {
        int connection = 0, tempDistance;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            if (i != pointIndex) {
                tempDistance = Math.abs(points[pointIndex][0] - points[i][0]) + Math.abs(points[pointIndex][1] - points[i][1]);
                if (tempDistance < minDistance) {
                    minDistance = tempDistance;
                    connection = i;
                }
            }
        }
        connected[pointIndex] = true;
        connected[connection] = true;
        return minDistance;
    }
}
