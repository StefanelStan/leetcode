package com.ss.leetcode.september;

public class FindNearestPoint {
    // https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minDistance = Integer.MAX_VALUE;
        int minDisIndex = -1, tempDistance;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                tempDistance = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);
                if (tempDistance < minDistance) {
                    minDistance = tempDistance;
                    minDisIndex = i;
                }
            }
        }
        return minDisIndex;
    }
}
