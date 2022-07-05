package com.ss.leetcode.LC2022.july;

public class CheckIfMatrixIsXMatrix {
    // https://leetcode.com/problems/check-if-matrix-is-x-matrix/
    /** Algorithm
         1. Traverse the matrix and do two checks:
             - if you're on main diagonal or 2nd diagolan and your element is 0, return false;
             - if you're not on these two diagonals and your element is not zero, return false;
         2. Return true by default
     */
    public boolean checkXMatrix(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                // if on main or second diagonal
                if (i == j || i == grid.length -1 - j) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else if (grid[i][j] != 0) { // if outside the two diagonals
                    return false;
                }
            }
        }
        return true;
    }
}
