package com.ss.leetcode.august;

public class MaxAreaOfIsland {
    // https://leetcode.com/problems/max-area-of-island/
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(calculateArea(grid, i, j), maxArea);
                }
            }
        }
        return maxArea;
    }

    private int calculateArea(int[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int sum = 1;
        sum += calculateArea(grid, i - 1, j);
        sum += calculateArea(grid, i + 1, j);
        sum += calculateArea(grid, i, j - 1);
        sum += calculateArea(grid, i, j + 1);
        return sum;
    }

    public int maxAreaOfIsland2(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int[] tempSum = { 0 };
                    calculateArea2(grid, i, j, tempSum);
                    maxArea = Math.max(tempSum[0], maxArea);
                }
            }
        }
        return maxArea;
    }

    private void calculateArea2(int[][] grid, int i, int j, int[] tempSum) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        tempSum[0]++;
        calculateArea2(grid, i - 1, j, tempSum);
        calculateArea2(grid, i + 1, j, tempSum);
        calculateArea2(grid, i, j - 1, tempSum);
        calculateArea2(grid, i, j + 1, tempSum);
    }
}
