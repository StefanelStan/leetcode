package com.ss.leetcode.LC2024.august;

public class MinimumNumberOfDaysToDisconnectIsland {
    // https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island
    /** Algorithm
        1. Use a method to determine the number and size of islands (DFS) on the grid. If number of islands is > 1, then return size -1.
        2. Why size? because if size is 0,1,3 you can disconnect the cells in 0 or 1 step. If size is 2, you need 2 steps.
        3. If the returned method value is -1, then you already have 2 islands
        4. For each land cell, mark it as water and check if number of islands is more than 1.
     */
    public int minDays(int[][] grid) {
        int size = getIslandSize(grid);
        return size <= 0 ? 0 : size <= 2 ? size : size == 3 ? 1 : findMinDays(grid);
    }

    private int getIslandSize(int[][] grid) {
        int size = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    if (size > 0) {
                        return -1;
                    } else {
                        size = populateIsland(grid, i, j, visited);
                    }
                }
            }
        }
        return size;
    }

    private int findMinDays(int[][] grid) {
        int minDays = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length && minDays != 1; i++) {
            for (int j = 0; j < grid[0].length && minDays != 1; j++) {
                if (grid[i][j] == 1) {
                    minDays = Math.min(minDays, disconnectCell(grid, i, j));
                }
            }
        }
        return minDays;
    }

    private int disconnectCell(int[][] grid, int x, int y) {
        return canDisconnect(grid, x, y) ? 1 : 2;
    }

    private boolean canDisconnect(int[][] grid, int x, int y) {
        grid[x][y] = 0;
        int islandSize = getIslandSize(grid);
        grid[x][y] = 1;
        return islandSize == -1;
    }

    private int populateIsland(int[][] grid, int x, int y, boolean[][] visited) {
        if (x < 0 || x == grid.length || y < 0 || y == grid[0].length || grid[x][y] == 0 || visited[x][y]) {
            return 0;
        }
        visited[x][y] = true;
        return 1 + populateIsland(grid, x-1, y, visited) + populateIsland(grid, x, y + 1, visited)
            + populateIsland(grid, x + 1, y, visited) + populateIsland(grid, x, y - 1, visited);
    }
}
