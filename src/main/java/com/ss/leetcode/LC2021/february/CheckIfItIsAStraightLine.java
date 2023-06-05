package com.ss.leetcode.LC2021.february;

import java.awt.geom.Line2D;

public class CheckIfItIsAStraightLine {
    // https://leetcode.com/problems/check-if-it-is-a-straight-line
    // Check the slope (p1-p2 - reference slope) vs p1-pX
    public boolean checkStraightLine(int[][] coordinates) {
        boolean onSameLine = true;
        double referenceSlope = getSlope(coordinates[0], coordinates[1]);
        for (int i = 2; i < coordinates.length && onSameLine; i++) {
            onSameLine = Double.compare(referenceSlope, getSlope(coordinates[0], coordinates[i])) == 0;
        }
        return onSameLine;

    }

    private double getSlope(int[] point1, int[] point2) {
        double slope = point1[1] == point2[1] ? Integer.MAX_VALUE : (double)(point2[0] - point1[0]) / (point2[1] - point1[1]);
        return slope == -0.0 ? 0 : slope;
    }


    public boolean checkStraightLine2(int[][] c) {
        Line2D line2D = new Line2D.Double(c[0][0], c[0][1], c[1][0], c[1][1]);
        double dist = 0;
        for (int i = 2; i < c.length; i++) {
            dist = line2D.ptLineDist(c[i][0], c[i][1]);
            if (dist < -0.001 || dist > 0.001) {
                return false;
            }
        }
        return true;
    }
}
