package com.ss.leetcode.LC2022.june;

public class CountSquareSubmatricesWithAllOnes {
    // https://leetcode.com/problems/count-square-submatrices-with-all-ones/
    public int countSquares(int[][] matrix) {
        int squares = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                squares += countExpandingSquares(i, j, matrix);
            }
        }
        return squares;
    }

    private int countExpandingSquares(int i, int j, int[][] matrix) {
        if (matrix[i][j] == 1) {
            return 1 + expandSquare(i, j, 1, matrix);
        } else {
            return 0;
        }
    }

    private int expandSquare(int i, int j, int distance, int[][] matrix) {
        if (validLine(i, j, distance, matrix) && validColumn(i, j, distance, matrix)) {
            return expandSquare (i, j, distance +1, matrix);
        } else {
            return distance -1;
        }
    }

    private boolean validLine(int i, int j, int distance, int[][] matrix) {
        if (j + distance >= matrix[0].length || i + distance >= matrix.length) {
            return false;
        }
        for (int line = i + distance, col = j; col <= j + distance; col++) {
            if (matrix[line][col] == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean validColumn(int i, int j, int distance, int[][] matrix) {
        if (i + distance >= matrix.length || j + distance >= matrix[0].length) {
            return false;
        }
        for (int row = i, col = j + distance; row <= i + distance; row++) {
            if (matrix[row][col] == 0) {
                return false;
            }
        }
        return true;
    }
}
