package com.ss.leetcode.LC2022.january;

public class MinimumPathSum {
    // https://leetcode.com/problems/minimum-path-sum/
    public int minPathSum(int[][] grid) {
        int[] minSum = {Integer.MAX_VALUE};
        traverseMatrix(grid, 0,0, 0, minSum);
        return minSum[0];
    }

    private void traverseMatrix(int[][] grid, int x, int y, int currSum, int[] minSum) {
        if (x >= grid.length || y >= grid[0].length) {
            return;
        }
        if (x == grid.length -1 && y == grid[x].length -1) {
            minSum[0] = Math.min(minSum[0], currSum + grid[x][y]);
        } else {
            traverseMatrix(grid, x + 1, y, currSum + grid[x][y], minSum);
            traverseMatrix(grid, x, y + 1, currSum + grid[x][y], minSum);
        }
    }
}
