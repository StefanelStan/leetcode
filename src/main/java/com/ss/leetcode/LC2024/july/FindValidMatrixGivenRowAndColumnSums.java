package com.ss.leetcode.LC2024.july;

public class FindValidMatrixGivenRowAndColumnSums {
    // https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums
    /** Algorithm
        1. Use a matrix[n][m] to store the answer
        2. Traverse rowSum with I and inside for loop traverse colSum with J
        3. While rowSum[i] > 0, set mat[i][j] = min(rowSum[i], colSum[j]).
        4. Deduct the set value from rowSum / colSum
        5. Stop the inside forloop (looping through columns when rowSum[i] == 0)
     */
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] matrix = new int[rowSum.length][colSum.length];
        for (int i = 0; i < rowSum.length; i++) {
            for (int j = 0; j < colSum.length && rowSum[i] > 0; j++) {
                matrix[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= matrix[i][j];
                colSum[j] -= matrix[i][j];
            }
        }
        return matrix;
    }
}
