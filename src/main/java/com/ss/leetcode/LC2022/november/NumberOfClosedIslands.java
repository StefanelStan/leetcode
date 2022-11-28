package com.ss.leetcode.LC2022.november;

public class NumberOfClosedIslands {
    public int closedIsland(int[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        boolean[][] corrupted = new boolean[grid.length][grid[0].length];
        int closedIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0 && !seen[i][j] && !corrupted[i][j] && isClosedIsland(grid, i, j, seen, corrupted)) {
                    closedIslands++;
                }
            }
        }
        return closedIslands;
    }

    private boolean isClosedIsland(int[][] grid, int i, int j, boolean[][] seen, boolean[][] corrupted) {
        if (i == 0 || i == grid.length -1 || j == 0 || j == grid[0].length - 1) {
            seen[i][j] = true;
            if (grid[i][j] == 0) {
                corrupted[i][j] = true;
                return false;
            } else {
                return true;
            }
        }

        seen[i][j] = true;
        boolean answer;
        answer = checkIfCanTravel(grid, i - 1, j, seen, corrupted);
        if (answer) {
            answer = checkIfCanTravel(grid, i, j + 1, seen, corrupted);
        }
        if (answer) {
            answer = checkIfCanTravel(grid, i + 1, j, seen, corrupted);
        }
        if (answer) {
            answer = checkIfCanTravel(grid, i, j - 1, seen, corrupted);
        }
        if (!answer) {
            corrupted[i][j] = true;
        }
        return answer;
    }

    private boolean checkIfCanTravel(int[][] grid, int i, int j, boolean[][] seen, boolean[][] corrupted) {
        if (seen[i][j] && corrupted[i][j]) {
            return false;
        }
        if (grid[i][j] == 1) {
            seen[i][j] = true;
            return true;
        }
        if (grid[i][j] == 0) {
            if (!seen[i][j]) {
                boolean answer = isClosedIsland(grid, i, j, seen, corrupted);
                seen[i][j] = true;
                if (!answer) {
                    corrupted[i][j] = true;
                    return false;
                }
            } else {
                return !corrupted[i][j];
            }
        }
        return true;
    }
}
