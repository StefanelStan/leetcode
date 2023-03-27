package com.ss.leetcode.LC2022.january;

public class MinimumPathSum {
    // https://leetcode.com/problems/minimum-path-sum/
    /** Algorithm
        1. In order to reach grid[m][n] you need to come from grid[m-1][n] OR grid[m][n-1] (from above or right)
        2. Thus, we observe that for each step, we need to decide which option (above or right) is best/minimum
        3. For each i (0..m) and j [0..n] determine and set the min travel cost coming from the cell above or from
            the right cell.
            grid[i][j] = grid[i][j] + Math.min(cellAbove, cellRight);
        4. Return the min path calculated and stored at grid[m][n].
     */
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length, onLeft;
        for (int j = 1; j < m; j++) {
            grid[0][j] += grid[0][j-1];
        }
        for(int i = 1; i < n; i++) {
            onLeft = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                grid[i][j] += Math.min(grid[i-1][j], onLeft);
                onLeft = grid[i][j];
            }
        }
        return grid[n - 1][m - 1];
    }


    // TLE - Solved after 1 year via DP :)
    public int minPathSum2(int[][] grid) {
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
