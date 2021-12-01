package com.ss.leetcode.LC2021.april;

import java.awt.geom.Point2D;

public class QueriesPointsInsideCircle {
    // https://lee.tcode.com/problems/queries-on-number-of-points-inside-a-circle/
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = countPointsInsideCircle(points, queries[i]);
        }
        return result;
    }

    private int countPointsInsideCircle(int[][] points, int[] query) {
        int pointsInside = 0;
        for (int[] point : points) {
            if (0 >= Double.compare(Point2D.distance(point[0], point[1], query[0], query[1]), query[2])) {
                pointsInside++;
            }
        }
        return pointsInside;
    }
}
