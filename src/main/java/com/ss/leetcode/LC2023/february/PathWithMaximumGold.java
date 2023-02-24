package com.ss.leetcode.LC2023.february;

public class PathWithMaximumGold {
    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    maxGold = Math.max(maxGold, visit(grid, i, j));
                }
            }
        }
        return maxGold;
    }

    private int visit(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] <= 0) {
            return 0;
        }
        int gold = grid[i][j];
        grid[i][j] = -1;
        int left = visit(grid, i, j-1);
        int right = visit(grid, i, j+1);
        int up = visit(grid, i-1, j);
        int down = visit(grid, i+1, j);

        grid[i][j] = gold;
        return grid[i][j] + Math.max(Math.max(up, down), Math.max(left, right));
    }

}
