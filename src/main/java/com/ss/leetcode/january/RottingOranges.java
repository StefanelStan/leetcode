package com.ss.leetcode.january;

public class RottingOranges {
    // https://leetcode.com/problems/rotting-oranges/
    public int orangesRotting(int[][] grid) {
        boolean stillHasOrangesToRot = true;
        boolean unableToRot = false;
        int[][] tempGrid = new int[grid.length][grid[0].length];
        copyGrid(grid, tempGrid);
        int cycles = -1;
        while (stillHasOrangesToRot) {
            stillHasOrangesToRot = false;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        unableToRot = true;
                        if (hasRottenOrangeNearby(grid, i, j)) {
                            tempGrid[i][j] = 2;
                            stillHasOrangesToRot = true;
                            unableToRot = false;
                        }
                    }
                }
            }

            copyGrid(tempGrid, grid);
            cycles++;
        }

        return unableToRot ? -1 : cycles;
    }

    private void copyGrid(int[][] grid, int[][] tempGrid) {
        for (int i = 0; i < grid.length; i++) {
            System.arraycopy(grid[i], 0, tempGrid[i], 0, grid[i].length);
        }
    }

    private boolean hasRottenOrangeNearby(int[][] grid, int i, int j) {
        // down
        if (i < grid.length - 1 && grid[i + 1][j] == 2) {
            return true;
        }
        // up
        if (i != 0 && grid[i - 1][j] == 2) {
            return true;
        }
        // left
        if (j > 0 && grid[i][j - 1] == 2) {
            return true;
        }
        // right
        return j < grid[i].length - 1 && grid[i][j + 1] == 2;
    }
}
