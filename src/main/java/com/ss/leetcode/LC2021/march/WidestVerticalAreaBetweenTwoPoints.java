package com.ss.leetcode.LC2021.march;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WidestVerticalAreaBetweenTwoPoints {
    // https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/
    // Faster to copy into a 1D array and sort than sort 2D array
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] newPoints = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            newPoints[i] = points[i][0];
        }
        Arrays.sort(newPoints);
        int maxWidth = 0;
        for (int i = 1; i < points.length; i++) {
            maxWidth = Math.max(maxWidth, newPoints[i] - newPoints[i-1]);
        }
        return maxWidth;
    }



    public int maxWidthOfVerticalArea2(int[][] points) {
        List<Integer> width = new ArrayList<>(points.length);
        for (int[] point : points) {
            if (point[1] > 0) {
                width.add(point[0]);
            }
        }
        Collections.sort(width);
        int max = 0;
        int currentDif;
        for(int i = 1; i < width.size(); i++) {
            currentDif = width.get(i) - width.get(i-1);
            if (currentDif > max) {
                max = currentDif;
            }
        }
        return max;
    }
}
