package com.ss.leetcode.LC2021.september;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    // https://leetcode.com/problems/spiral-matrix/submissions/
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>(matrix.length * matrix[0].length);
        traverseMatrix(matrix, spiral);
        return spiral;
    }

    private void traverseMatrix(int[][] matrix, List<Integer> spiral) {
        int m = matrix.length;
        int n = matrix[0].length;
        int direction = 1;
        int[] points = {0, 0};
        spiral.add(matrix[0][0]);
        matrix[0][0] = 101;
        while (spiral.size() < m * n) {
            switch (direction) {
                case 1 -> {
                    traverseLeftRight(matrix, points, spiral);
                    direction++;
                }
                case 2 -> {
                    traverseTopBottom(matrix, points, spiral);
                    direction++;
                }
                case 3 -> {
                    traverseRightLeft(matrix, points, spiral);
                    direction++;
                }
                default -> {
                    traverseBottomUp(matrix, points, spiral);
                    direction = 1;
                }
            }
        }
    }

    private void traverseLeftRight(int[][] matrix, int[] points, List<Integer> spiral) {
        int j = points[1] + 1;
        for (; j < matrix[0].length && matrix[points[0]][j] != 101; j++) {
            spiral.add(matrix[points[0]][j]);
            matrix[points[0]][j] = 101;
        }
        points[1] = j - 1;
    }

    private void traverseTopBottom(int[][] matrix, int[] points, List<Integer> spiral) {
        int i = points[0] + 1;
        for (; i < matrix.length && matrix[i][points[1]] != 101; i++) {
            spiral.add(matrix[i][points[1]]);
            matrix[i][points[1]] = 101;
        }
        points[0] = i - 1;
    }

    private void traverseRightLeft(int[][] matrix, int[] points, List<Integer> spiral) {
        int j = points[1] -1;
        for (; j >= 0 && matrix[points[0]][j] != 101; j--) {
            spiral.add(matrix[points[0]][j]);
            matrix[points[0]][j] = 101;
        }
        points[1] = j + 1;
    }

    private void traverseBottomUp(int[][] matrix, int[] points, List<Integer> spiral) {
        int i = points[0] - 1;
        for (; i >= 0 && matrix[i][points[1]] != 101; i--) {
            spiral.add(matrix[i][points[1]]);
            matrix[i][points[1]] = 101;
        }
        points[0] = i + 1;
    }
}
