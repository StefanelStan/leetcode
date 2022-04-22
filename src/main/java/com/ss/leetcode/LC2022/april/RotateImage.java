package com.ss.leetcode.LC2022.april;

public class RotateImage {
    // https://leetcode.com/problems/rotate-image/
    public void rotate(int[][] matrix) {
        int low = 0, high = matrix.length - 1;
        int cycles = 0;
        while (cycles < matrix.length / 2) {
            rotateLayer(matrix, low + cycles, high - cycles);
            cycles++;
        }
    }

    private void rotateLayer(int[][] matrix, int low, int high) {
        for (int j = low; j < high; j++) {
            rotateSegment(matrix, low, j, high);
        }
    }

    private void rotateSegment(int[][] matrix, int row, int col, int high) {
        int tempValue0 = 0, tempValue1 = 0, tempValue2 = 0;
        int status = 0;
        while (status < 4) {
            switch (status) {
                case 0 -> {
                    int newIndex = high + (col - row);
                    tempValue0 = matrix[row + newIndex - high][high];
                    matrix[row + newIndex - high][high] = matrix[row][col];
                    status++;
                }
                case 1 -> {
                    tempValue1 = matrix[high][high - (col - row)];
                    matrix[high][high - (col - row)] = tempValue0;
                    status++;
                }
                case 2 -> {
                    tempValue2 = matrix[row + (high - col)][row];
                    matrix[row + (high - col)][row] = tempValue1;
                    status++;
                }
                default -> {
                    matrix[row][col] = tempValue2;
                    status++;
                }
            }
        }
    }
}
