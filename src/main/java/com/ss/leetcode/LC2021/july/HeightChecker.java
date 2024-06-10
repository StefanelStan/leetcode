package com.ss.leetcode.LC2021.july;

import java.util.Arrays;

public class HeightChecker {
    // https://leetcode.com/problems/height-checker/
    /** Algorithm
        1. Count the nums into an int[] count of size 101
        2. For each height, traverse count while you reach a count > 0.
        3. If count[index] == height, then you are on a good height index, else on a bad height/mismatch
        4. Every time, decrease the count[index] by 1 to simulate a move to the right of the count
     */
    public int heightChecker(int[] heights) {
        int mismatches = 0;
        int[] count = new int[101];
        for (int height : heights) {
            count[height]++;
        }
        int countIndex = 0;
        for (int height : heights) {
            while (count[countIndex] == 0) {
                countIndex++;
            }
            mismatches += height == countIndex ? 0 : 1;
            count[countIndex]--;
        }
        return mismatches;
    }

    public int heightChecker2(int[] heights) {
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
