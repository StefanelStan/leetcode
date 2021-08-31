package com.ss.leetcode.august;

public class MaxAreaOfIsland {
    // https://leetcode.com/problems/max-area-of-island/
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int[] tempSum = { 0 };
                    calculateArea(grid, i, j, tempSum);
                    maxArea = Math.max(tempSum[0], maxArea);
                }
            }
        }
        return maxArea;
    }

    private void calculateArea(int[][] grid, int i, int j, int[] tempSum) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        tempSum[0]++;
        calculateArea(grid, i - 1, j, tempSum);
        calculateArea(grid, i + 1, j, tempSum);
        calculateArea(grid, i, j - 1, tempSum);
        calculateArea(grid, i, j + 1, tempSum);
    }
}
