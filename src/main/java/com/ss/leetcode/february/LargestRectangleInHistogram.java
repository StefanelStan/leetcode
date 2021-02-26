package com.ss.leetcode.february;

public class LargestRectangleInHistogram {
    // https://leetcode.com/problems/largest-rectangle-in-histogram/
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 1) {
            return heights[0];
        }
        int largestRectangle = 0;
        int currentMin = 0;
        int currentAvg = 0;
        int absMin = Integer.MAX_VALUE;
        for (int i = 0; i < heights.length - 1; i++) {
            currentMin = heights[i];
            if (currentMin > largestRectangle) {
                largestRectangle = currentMin;
            }
            if (heights[i] < absMin) {
                absMin = heights[i];
            }
            for (int j = i + 1; j < heights.length; j++) {
                currentMin = Math.min(currentMin, heights[j]);
                currentAvg = ((j - i + 1) * currentMin);
                if (currentAvg > largestRectangle) {
                    largestRectangle = currentAvg;
                }
            }
        }
        return Math.max(largestRectangle, heights[heights.length - 1]);
    }
}
