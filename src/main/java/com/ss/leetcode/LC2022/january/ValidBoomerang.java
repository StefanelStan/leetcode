package com.ss.leetcode.LC2022.january;

import java.awt.geom.Point2D;
import java.util.Arrays;

public class ValidBoomerang {
    // https://leetcode.com/problems/valid-boomerang/
    public boolean isBoomerang(int[][] points) {
        double[] distance = new double[3];
        distance[0] = Point2D.distance(points[0][0], points[0][1], points[1][0], points[1][1]);
        distance[1] = Point2D.distance(points[0][0], points[0][1], points[2][0], points[2][1]);
        distance[2] = Point2D.distance(points[1][0], points[1][1], points[2][0], points[2][1]);

        Arrays.sort(distance);
        if(distance[0] == 0) {
            return false;
        }
        double diff = Math.abs(distance[0] + distance[1] - distance[2]);
        return diff > 0.0000000001;
    }
}
