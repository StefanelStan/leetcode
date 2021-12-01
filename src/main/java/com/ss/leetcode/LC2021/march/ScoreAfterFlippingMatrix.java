package com.ss.leetcode.LC2021.march;

public class ScoreAfterFlippingMatrix {
    // https://leetcode.com/problems/score-after-flipping-matrix/
    public int matrixScore(int[][] matrix) {
        flipRows(matrix);
        flipColumns(matrix);
        return getSumOfMatrix(matrix);
    }

    private void flipRows(int[][] matrix) {
        for (int[] row: matrix) {
            if (row[0] == 0) {
                for (int i = 0; i < row.length; i++) {
                    row[i] = row[i] == 0 ? 1 : 0;
                }
            }
        }
    }

    private void flipColumns(int[][] matrix) {
        int zeroCount = 0;
        for (int j = 0; j < matrix[0].length; j++) {
            for (int[] ints : matrix) {
                if (ints[j] == 0) {
                    zeroCount++;
                }
            }
            if (zeroCount > matrix.length / 2) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = matrix[i][j] == 0 ? 1 : 0;
                }
            }
            zeroCount = 0;
        }
    }

    private int getSumOfMatrix(int[][] matrix) {
        int sum = 0;
        StringBuilder stb;
        for (int[] row : matrix) {
            stb = new StringBuilder();
            for (int column : row) {
                stb.append(column);
            }
            sum += Integer.parseInt(stb.toString(), 2);
        }
        return sum;
    }
}
