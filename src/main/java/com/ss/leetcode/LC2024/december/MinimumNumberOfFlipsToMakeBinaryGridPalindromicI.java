package com.ss.leetcode.LC2024.december;

public class MinimumNumberOfFlipsToMakeBinaryGridPalindromicI {
    // https://leetcode.com/problems/minimum-number-of-flips-to-make-binary-grid-palindromic-i
    /** Algorithm
        1. Determine the minimum between the cost of making all rows palindromic and making all columns palindromic
        2. For each row, loop with left, right (0, n-1) and if row[left] != row[right], add 1 to cost.
        3. Do the same for each column.
        4. Return the min between the two costs.
     */
    public int minFlips(int[][] grid) {
        return Math.min(flipRows(grid), flipColumns(grid));
    }

    private int flipRows(int[][] grid) {
        int cost = 0;
        for (int[] row : grid) {
            for (int i = 0, j = row.length - 1; i < j; i++, j--) {
                cost += (row[i] == row[j] ? 0 : 1);
            }
        }
        return cost;
    }

    private int flipColumns(int[][] grid) {
        int cost = 0;
        for (int c = 0; c < grid[0].length; c++) {
            for (int up = 0, down = grid.length - 1; up < down; up++, down--) {
                cost += (grid[up][c] == grid[down][c] ? 0 : 1);
            }
        }
        return cost;
    }
}
