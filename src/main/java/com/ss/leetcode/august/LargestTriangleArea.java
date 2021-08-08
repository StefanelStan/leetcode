package com.ss.leetcode.august;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class LargestTriangleArea {
    // https://leetcode.com/problems/largest-triangle-area/
    public double largestTriangleArea(int[][] points) {
        double largestArea = -1.0, currentArea = - 1.0;
        for (int i = 0; i < points.length - 2; i++) {
            for (int j = i + 1; j < points.length - 1; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    if (notOnSameLine(points[i], points[j], points[k])) {
                        currentArea = getTriangleArea(points[i], points[j], points[k]);
                        if (currentArea > largestArea) {
                            largestArea = currentArea;
                        }
                    }
                }
            }
        }
        return largestArea;
    }

    private boolean notOnSameLine(int[] point1, int[] point2, int[] point3) {
        return Line2D.ptLineDist(point1[0], point1[1], point2[0], point2[1], point3[0], point3[1]) != 0.0;
    }

    private double getTriangleArea(int[] point1, int[] point2, int[] point3) {
        double side1 = Point2D.distance(point1[0], point1[1], point2[0], point2[1]);
        double side2 = Point2D.distance(point2[0], point2[1], point3[0], point3[1]);
        double side3 = Point2D.distance(point1[0], point1[1], point3[0], point3[1]);
        double sp = (side1 + side2 + side3) / 2;
        return Math.sqrt(sp * (sp - side1) * (sp - side2) * (sp - side3));
    }
}
