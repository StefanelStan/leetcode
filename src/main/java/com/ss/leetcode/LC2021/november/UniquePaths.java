package com.ss.leetcode.LC2021.november;

import java.util.Arrays;

public class UniquePaths {
    // https://leetcode.com/problems/unique-paths/
    public int uniquePaths(int m, int n) {
        int[][] gridPaths = new int[m][n];
        Arrays.fill(gridPaths[0], 1);
        for (int i = 1; i < m; i++) {
            gridPaths[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                gridPaths[i][j] = gridPaths[i][j-1] + gridPaths[i-1][j];
            }
        }
        return gridPaths[m-1][n-1];
    }
}
