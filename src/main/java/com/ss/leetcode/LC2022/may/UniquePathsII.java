package com.ss.leetcode.LC2022.may;

public class UniquePathsII {
    // https://leetcode.com/problems/unique-paths-ii/
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }
        int[][] uniquePaths = new int[m][n];
        setRowAndColumnFirstLines(obstacleGrid, m, n, uniquePaths);
        for(int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    uniquePaths[i][j] = uniquePaths[i][j-1] + uniquePaths[i-1][j];
                }
            }
        }
        return uniquePaths[m-1][n-1];
    }

    private void setRowAndColumnFirstLines(int[][] obstacleGrid, int m, int n, int[][] uniquePaths) {
        boolean bumpedStone = false;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                bumpedStone = true;
            }
            uniquePaths[i][0] = bumpedStone ? 0 : 1;
        }
        bumpedStone = false;
        for(int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                bumpedStone = true;
            }
            uniquePaths[0][j] = bumpedStone ? 0 : 1;
        }
    }
}
