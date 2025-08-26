package com.ss.leetcode.LC2025.august;

public class MaximumAreaOfLongestDiagonalRectangle {
    // https://leetcode.com/problems/maximum-area-of-longest-diagonal-rectangle
    /** Algorithm
        1. Rectangles with the same a^2 + b^2 could have different areas
        2. Traverse dimensions and keep track of max a^2 + b^2. If a new max square is found or a rectangle with the same square, retain the new max area.
        3. Return max area.
     */
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxSquareSum = 0, maxArea = 0, currentSquare, currentArea;
        for (int[] dimension : dimensions) {
            currentSquare = dimension[0] * dimension[0] + dimension[1] * dimension[1];
            currentArea = dimension[0] * dimension[1];
            if (currentSquare > maxSquareSum || (currentSquare == maxSquareSum && currentArea > maxArea)) {
                maxSquareSum = currentSquare;
                maxArea = currentArea;
            }
        }
        return maxArea;
    }
}
