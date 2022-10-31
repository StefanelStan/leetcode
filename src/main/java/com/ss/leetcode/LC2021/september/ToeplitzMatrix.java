package com.ss.leetcode.LC2021.september;

public class ToeplitzMatrix {
    // https://leetcode.com/problems/toeplitz-matrix/
    public boolean isToeplitzMatrix(int[][] matrix) {
        boolean isToeplitz = true;
        for(int j = 0; j < matrix[0].length - 1 && isToeplitz; j++) {
            isToeplitz = isToeplitzMatrix(0, j, matrix);
        }
        if (isToeplitz) {
            for (int i = 1; i < matrix.length - 1 && isToeplitz; i++) {
                isToeplitz = isToeplitzMatrix(i, 0, matrix);
            }
        }
        return isToeplitz;
    }

    private boolean isToeplitzMatrix(int row, int col, int[][] matrix) {
        for (int i = 0; i + row < matrix.length && i + col < matrix[row].length; i++) {
            if (matrix[row][col] != matrix[row + i][col + i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isToeplitzMatrix2(int[][] matrix) {
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
