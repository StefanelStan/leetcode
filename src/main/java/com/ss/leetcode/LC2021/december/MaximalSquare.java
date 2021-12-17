package com.ss.leetcode.LC2021.december;

public class MaximalSquare {
    // https://leetcode.com/problems/maximal-square/
    public int maximalSquare(char[][] matrix) {
        int maxSquare = 0;
        for (int i = 0; i < matrix.length - maxSquare; i++) {
            for (int j = 0; j < matrix[i].length - maxSquare; j++) {
                if (matrix[i][j] == '1') {
                    maxSquare = Math.max(maxSquare, getMaxSquare(i, j, 0, matrix));
                }
            }
        }
        return maxSquare * maxSquare;
    }

    private int getMaxSquare(int row, int col, int level, char[][] matrix) {
        if (row+level >= matrix.length || col + level >= matrix[0].length) {
            return 0;
        }
        int targetRow = row + level;
        int targetCol = col + level;
        for (int j = col; j <= targetCol; j++) {
            if (matrix[targetRow][j] == '0') {
                return 0;
            }
        }
        for (int i = row; i <= targetRow; i++) {
            if (matrix[i][targetCol] == '0') {
                return 0;
            }
        }
        return 1 + getMaxSquare(row, col, level +1, matrix);
    }
}
