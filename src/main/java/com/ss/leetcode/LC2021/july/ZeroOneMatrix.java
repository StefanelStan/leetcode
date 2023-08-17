package com.ss.leetcode.LC2021.july;

import java.util.Arrays;

public class ZeroOneMatrix {
    // https://leetcode.com/problems/01-matrix
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] distance = new int[m][n];
        // traverse left-> right, up->down
        int temp1, temp2;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    temp1 = i == 0 ? 20001 : distance[i-1][j];
                    temp2 = j == 0 ? 20001 : distance[i][j-1];
                    distance[i][j] = 1 + Math.min(temp1, temp2);
                }
            }
        }
        // traverse right->left, down->up
        for (int i = m -1; i >= 0; i--) {
            for (int j = n -1; j >=0; j--) {
                if (mat[i][j] == 1) {
                    temp1 = i == m - 1 ? 20001 : distance[i+1][j];
                    temp2 = j == n - 1 ? 20001 : distance[i][j+1];
                    distance[i][j] = Math.min(distance[i][j], 1 + Math.min(temp1, temp2));
                }
            }
        }
        return distance;
    }


    public int[][] updateMatrix2(int[][] matrix) {
        int[][] mat = new int[matrix.length][matrix[0].length];
        for (int[] row : mat) Arrays.fill(row, Integer.MAX_VALUE - 100_000);
        // iterate from left to right, top to bottom
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (matrix[i][j] == 0) {
                    mat[i][j] = 0;
                } else {
                    if (i > 0) {
                        mat[i][j] = Math.min(mat[i][j], mat[i - 1][j] + 1);
                    }
                    if (j > 0) {
                        mat[i][j] = Math.min(mat[i][j], mat[i][j - 1] + 1);
                    }
                }
            }
        }
        // iterate from right to left, bottom to top
        for (int i = mat.length - 1; i >= 0; i--) {
            for (int j = mat[i].length - 1; j >= 0; j--) {
                if (mat[i][j] != 0) {
                    if (i < mat.length - 1) {
                        mat[i][j] = Math.min(mat[i][j], mat[i + 1][j] + 1);
                    }
                    if (j < mat[i].length - 1) {
                        mat[i][j] = Math.min(mat[i][j], mat[i][j + 1] + 1);
                    }
                }
            }
        }
        return mat;
    }
}
