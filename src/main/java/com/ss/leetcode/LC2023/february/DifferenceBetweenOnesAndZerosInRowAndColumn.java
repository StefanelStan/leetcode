package com.ss.leetcode.LC2023.february;

public class DifferenceBetweenOnesAndZerosInRowAndColumn {
    // https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column
    /** Algorithm
        1. Traverse the matrix and count the 1s using two int[] for rows and columns.
        2. For each i, j calculate the difference using the two ints[] and mark it in the answer matrix;
        3. Return the answer matrix.
     */
    public int[][] onesMinusZeros(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int[][] differences = new int[r][c];
        int[] colCount = new int[c];
        int[] rowCount = new int[r];
        countOnes(colCount, rowCount, grid);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                differences[i][j] = 2 * rowCount[i] + 2 * colCount[j] - r - c;
            }
        }
        return differences;
    }

    private void countOnes(int[] colCount, int[] rowCount, int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
    }
}
