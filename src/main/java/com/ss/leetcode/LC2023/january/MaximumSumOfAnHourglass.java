package com.ss.leetcode.LC2023.january;

public class MaximumSumOfAnHourglass {
    // https://leetcode.com/problems/maximum-sum-of-an-hourglass
    /** Algorithm
        1. For each position i from 0 to grid.length -1 and j from 0 to grid[i].length -2 calculate the hourglass sum.
        2. Return the max hourglass sum ever recorded.
     */
    public int maxSum(int[][] grid) {
        int maxSum = 0, tempSum;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[i].length - 2; j++) {
                maxSum = Math.max(maxSum, getHourglassSum(grid, i,j));
            }
        }
        return maxSum;
    }

    private int getHourglassSum(int[][] grid, int i, int j) {
        return grid[i][j] + grid[i][j+1] + grid[i][j+2]
            + grid[i+1][j+1]
            + grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2];
    }
}
