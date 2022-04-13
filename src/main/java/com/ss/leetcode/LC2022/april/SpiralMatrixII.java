package com.ss.leetcode.LC2022.april;

public class SpiralMatrixII {
    // https://leetcode.com/problems/spiral-matrix-ii/
    public int[][] generateMatrix(int n) {
        int[][] generated;
        if (n == 1) {
            generated = new int[][]{{1}};
        } else if (n == 2) {
            generated = new int[][]{{1,2},{4,3}};
        } else {
            generated = generateSpiralMatrix(n);
        }
        return generated;
    }

    private int[][] generateSpiralMatrix(int n) {
        int[][] matrix = new int[n][n];
        int index = 1;
        int state = 1;
        int topLine = 0;
        int bottomLine = n -1;
        int left = 0;
        int right = n-1;
        while(index <= n * n) {
            switch (state) {
                case 1 -> {
                    for (int j = left; j <= right; j++) {
                        matrix[topLine][j] = index++;
                    }
                    state = 2;
                }
                case 2 -> {
                    for (int i = topLine + 1; i <= bottomLine; i++) {
                        matrix[i][right] = index++;
                    }
                    state = 3;
                }
                case 3 -> {
                    for (int j = right - 1; j >= left; j--) {
                        matrix[bottomLine][j] = index++;
                    }
                    bottomLine--;
                    right--;
                    state = 4;
                }
                case 4 -> {
                    topLine++;
                    for (int i = bottomLine; i >= topLine; i--) {
                        matrix[i][left] = index++;
                    }
                    left++;
                    state = 1;
                }
            }
        }
        return matrix;
    }
}
