package com.ss.leetcode.LC2021.september;

public class ToeplitzMatrix {
    // https://leetcode.com/problems/toeplitz-matrix/
    public boolean isToeplitzMatrix(int[][] matrix) {
        return topHasSameElements(matrix) && bottomHasSameElements(matrix);
    }

    private boolean topHasSameElements(int[][] matrix) {
        for (int pointer = 0; pointer < matrix[0].length; pointer++) {
            for (int i = 0, j = pointer; i < matrix.length - 1 && j < matrix[0].length - 1; i++, j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bottomHasSameElements(int[][] matrix) {
        for (int pointer = 1; pointer < matrix.length; pointer++) {
            for (int i = pointer, j = 0; i < matrix.length - 1 && j < matrix[0].length - 1; i++, j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
