package com.ss.leetcode.LC2021.september;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    // https://leetcode.com/problems/spiral-matrix/submissions/
    public List<Integer> spiralOrder(int[][] matrix) {
        int direction = 1, totalElements = matrix.length * matrix[0].length;
        int[][] corners = getCorners(matrix);
        List<Integer> order = new ArrayList<>(totalElements);
        while (order.size() < totalElements) {
            switch (direction) {
                case 1 -> {
                    moveHorizontally(matrix, corners[0], corners[1], 1, order);
                    direction++;
                }
                case 2 -> {
                    moveVertically(matrix, corners[1], corners[2], 1, order);
                    direction++;
                }
                case 3 -> {
                    moveHorizontally(matrix, corners[2], corners[3], -1, order);
                    direction++;
                }
                default -> {
                    moveVertically(matrix, corners[3], corners[0], -1, order);
                    adjustCorners(corners);
                    direction = 1;
                }
            }
        }
        return order;
    }

    private void moveHorizontally(int[][] matrix, int[] from, int[] to, int direction, List<Integer> order) {
        int col = from[1];
        boolean finished = false;
        while(!finished) {
            order.add(matrix[from[0]][col]);
            finished = col == to[1];
            col += direction;
        }
    }

    private void moveVertically(int[][] matrix, int[] from, int[] to, int direction, List<Integer> order) {
        int row = from[0] + direction;
        while(row != to[0]) {
            order.add(matrix[row][from[1]]);
            row += direction;
        }
    }

    private int[][] getCorners(int[][] matrix) {
        int[][] corners = new int[4][2];
        corners[0] = new int[]{0,0};
        corners[1] = new int[]{0, matrix[0].length -1};
        corners[2] = new int[]{matrix.length -1, matrix[0].length -1};
        corners[3] = new int[]{matrix.length -1, 0};
        return corners;
    }

    private void adjustCorners(int[][] corners) {
        corners[0][0]++;
        corners[0][1]++;
        corners[1][0]++;
        corners[1][1]--;
        corners[2][0]--;
        corners[2][1]--;
        corners[3][0]--;
        corners[3][1]++;
    }


    public List<Integer> spiralOrder2(int[][] matrix) {
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
