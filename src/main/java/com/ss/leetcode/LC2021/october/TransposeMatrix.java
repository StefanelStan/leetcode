package com.ss.leetcode.LC2021.october;

public class TransposeMatrix {
    // https://leetcode.com/problems/transpose-matrix/
    public int[][] transpose(int[][] matrix) {
        int[][] transposed = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }
}
