package com.ss.leetcode.LC2024.december;

public class BeautifulTowersI {
    // https://leetcode.com/problems/beautiful-towers-i
    /** Algorithm
        1. Every index could be a peak
        2. Traverse with i from 0 to n-1 and for each index
            - traverse to the left and try to make current index <= than previous one in the mountain. Add the level achieved
            - traverse to the right and try to make the current index <= than prev one in the mountain. Add to the level.
        3. Return the max sum achieved for each index.
     */
    public long maximumSumOfHeights(int[] heights) {
        long maxHeight = 0L;
        for (int i = 0; i < heights.length; i++) {
            maxHeight = Math.max(maxHeight, calculateMaxHeight(heights, i));
        }
        return maxHeight;
    }

    private long calculateMaxHeight(int[] heights, int index) {
        long sum = heights[index];
        for (int i = index - 1, referenceIndex = index; i >= 0; i--) {
            if (heights[i] <= heights[referenceIndex]) {
                referenceIndex = i;
            }
            sum += heights[referenceIndex];
        }
        for (int i = index + 1, referenceIndex = index; i < heights.length; i++) {
            if (heights[i] <= heights[referenceIndex]) {
                referenceIndex = i;
            }
            sum += heights[referenceIndex];
        }
        return sum;
    }
}
