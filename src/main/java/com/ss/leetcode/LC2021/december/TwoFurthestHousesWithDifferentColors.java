package com.ss.leetcode.LC2021.december;

public class TwoFurthestHousesWithDifferentColors {
    // https://leetcode.com/problems/two-furthest-houses-with-different-colors/
    public int maxDistance(int[] colors) {
        //fixate on left house and search from right
        int max = -1;
        for (int i = colors.length -1; i >= 1; i--) {
            if (colors[0] != colors[i]) {
                max = i;
                break;
            }
        }

        for(int i = 0; i < colors.length -1; i++) {
            if (colors[i] != colors[colors.length -1]) {
                max = Math.max(max, colors.length -1 - i);
                break;
            }
        }
        return max;
    }
}
