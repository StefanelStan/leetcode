package com.ss.leetcode.LC2023.february;

public class PathWithMaximumGold {
    // https://leetcode.com/problems/path-with-maximum-gold
    /** Algorithm
        1. Starting from each cell, try to visit them one by one in all directions.
        2. Set current cell to 0, visit all 4 directions, then reset current cell.
        3. If current cell is a dead end, you can not travel anymore, so set the max gold collected so far.
     */
    private static final int[][] DIRECTIONS = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    public int getMaximumGold(int[][] grid) {
        int[] maxGold = {0};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                findMax(grid, i, j, 0, maxGold);
            }
        }
        return maxGold[0];
    }

    private void findMax(int[][] grid, int i, int j, int collected, int[] maxGold) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[i].length || grid[i][j] == 0) {
            maxGold[0] = Math.max(maxGold[0], collected);
            return;
        }
        collected += grid[i][j];
        int originalValue = grid[i][j];
        grid[i][j] = 0;
        for (int[] direction : DIRECTIONS) {
            findMax(grid, i + direction[0], j + direction[1], collected, maxGold);
        }
        grid[i][j] = originalValue;
    }

    public int getMaximumGold2(int[][] grid) {
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
