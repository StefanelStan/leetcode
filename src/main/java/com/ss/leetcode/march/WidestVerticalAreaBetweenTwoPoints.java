package com.ss.leetcode.march;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WidestVerticalAreaBetweenTwoPoints {
    // https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/
    public int maxWidthOfVerticalArea(int[][] points) {
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
