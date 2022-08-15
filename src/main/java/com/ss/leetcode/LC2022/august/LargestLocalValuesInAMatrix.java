package com.ss.leetcode.LC2022.august;

public class LargestLocalValuesInAMatrix {
    // https://leetcode.com/problems/largest-local-values-in-a-matrix/
    /** Algorithm
         1. Declare a result[n-2][n-2] matrix that will hold the result.
         2. In a loop with i=[0,n-2) and j=[0,n-2), set result[][] the max of each square (i->i+2 j->j+2).
         3. Return the result.
     */
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] result = new int[n-2][n-2];
        for (int i = 0; i < n -2; i++) {
            for (int j = 0; j < n-2; j++) {
                result[i][j] = getMax(grid, i, j);
            }
        }
        return result;
    }

    private int getMax(int[][] grid, int row, int col) {
        int max = grid[row][col];
        for (int i = row; i < row + 3; i++) {
            for(int j = col; j < col + 3; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }
}
