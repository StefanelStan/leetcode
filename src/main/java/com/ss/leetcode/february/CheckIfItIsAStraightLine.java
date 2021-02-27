package com.ss.leetcode.february;

import java.awt.geom.Line2D;

public class CheckIfItIsAStraightLine {
    public boolean checkStraightLine(int[][] c) {
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
