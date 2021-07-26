package com.ss.leetcode.july;

import java.util.Arrays;

public class HeightChecker {
    // https://leetcode.com/problems/height-checker/
    public int heightChecker(int[] heights) {
        int[] ordered = new int[heights.length];
        System.arraycopy(heights, 0, ordered, 0, heights.length);
        Arrays.sort(ordered);
        int mismatches = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != ordered[i]) {
                mismatches++;
            }
        }
        return mismatches;
    }
}
