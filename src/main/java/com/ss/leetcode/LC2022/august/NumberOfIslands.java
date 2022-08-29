package com.ss.leetcode.LC2022.august;

public class NumberOfIslands {
    // https://leetcode.com/problems/number-of-islands/
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    markIsland(grid, i, j);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    private void markIsland(char[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        markIsland(grid, i - 1, j);
        markIsland(grid, i + 1, j);
        markIsland(grid, i, j - 1);
        markIsland(grid, i, j + 1);
    }
}
