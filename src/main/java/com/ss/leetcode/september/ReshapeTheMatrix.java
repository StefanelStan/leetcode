package com.ss.leetcode.september;

public class ReshapeTheMatrix {
    // https://leetcode.com/problems/reshape-the-matrix/
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if ((r == mat.length && c == mat[0].length) || (r * c != mat.length * mat[0].length)) {
            return mat;
        }
        int[][] reshape = new int[r][c];
        int index = 0;
        for (int[] row : mat) {
            for (int col : row) {
                reshape[index / c][index % c] = col;
                index++;
            }
        }
        return reshape;
    }
}
