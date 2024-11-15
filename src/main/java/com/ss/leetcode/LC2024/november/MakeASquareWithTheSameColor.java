package com.ss.leetcode.LC2024.november;

public class MakeASquareWithTheSameColor {
    // https://leetcode.com/problems/make-a-square-with-the-same-color
    /** Algorithm
        1. As you have 9 cells (W and B), you can make a special submatrix (2x2) only if that matrix does not have 2 W or 2B.
        2. Any other combination (0-4, 1-3, 3-1, 4-0) will make a special submatrix.
     */
    public boolean canMakeSquare(char[][] grid) {
        boolean canMake = false;
        for (int i = 0; i < 2 && !canMake; i++) {
            for (int j = 0; j < 2; j++) {
                canMake = canMake || checkCells(grid, i, j);
            }
        }
        return canMake;
    }

    private boolean checkCells(char[][] grid, int i, int j) {
        int white = (grid[i][j] == 'W' ? 1 : 0) +
            (grid[i][j + 1] == 'W' ? 1 : 0) +
            (grid[i + 1][j] == 'W' ? 1 : 0) +
            (grid[i + 1][j + 1] == 'W' ? 1 : 0);
        return white != 2;
    }
}
