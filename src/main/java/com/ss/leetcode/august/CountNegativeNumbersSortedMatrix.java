package com.ss.leetcode.august;

public class CountNegativeNumbersSortedMatrix {
    // https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
    public int countNegatives(int[][] grid) {
        int negativeCount = 0;
        int rightIndex = grid[0].length - 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = rightIndex; j >= 0; ) {
                if (grid[i][j] < 0) {
                    negativeCount += grid.length - i;
                    j--;
                    rightIndex = j;
                } else {
                    break;

                }
            }
        }
        return negativeCount;
    }
}
