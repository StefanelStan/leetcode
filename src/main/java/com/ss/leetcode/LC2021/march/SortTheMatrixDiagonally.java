package com.ss.leetcode.LC2021.march;

import java.util.Arrays;

public class SortTheMatrixDiagonally {
    // https://leetcode.com/problems/sort-the-matrix-diagonally/
    public int[][] diagonalSort(int[][] mat) {
        // you have to calculate for column n to col 1 ;
        // second for to go from line 1 to line n
        for (int j = mat[0].length - 1; j >= 0; j--) {
            sortOutMatrixOfArray(mat, mat, 0, j);
        }
        for (int i = 1; i < mat.length; i++) {
            sortOutMatrixOfArray(mat, mat, i, 0);
        }

        return mat;
    }

    // copy the diagonal from the matrix into the bucket, sort it then put it back into the matrix
    private void sortOutMatrixOfArray(int[][] src, int[][] dest, int i, int j) {
        int size = Math.min(src.length - i, src[0].length - j);
        int[] bucket = new int[size];
        int index = 0;
        for(int row = i, col = j; row < src.length && col < src[row].length; row++, col++) {
            bucket[index] = src[row][col];
            index++;
        }
        Arrays.sort(bucket);
        index = 0;
        for(int row = i, col = j; row < src.length && col < src[row].length; row++, col++) {
            dest[row][col] = bucket[index];
            index++;
        }
    }
}
