package com.ss.leetcode.LC2021.march;

import java.util.Arrays;

public class SortTheMatrixDiagonally {
    // https://leetcode.com/problems/sort-the-matrix-diagonally/
    public int[][] diagonalSort(int[][] mat) {
        if (mat.length == 1 || mat[0].length == 1) {
            return mat;
        }
        int[][] sorted = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            sortAndInsert(mat, sorted, i, 0);
        }
        for (int j = 1; j < mat[0].length; j++) {
            sortAndInsert(mat, sorted, 0, j);
        }
        return sorted;
    }

    private void sortAndInsert(int[][] mat, int[][] sorted, int row, int col) {
        int[] nrs = new int[Math.min(mat.length - row, mat[0].length - col)];
        for(int i = 0; i < nrs.length; i++) {
            nrs[i] = mat[row + i][col + i];
        }
        Arrays.sort(nrs);
        for (int i = 0; i < nrs.length; i++) {
            sorted[row + i][col + i] =  nrs[i];
        }
    }


    public int[][] diagonalSort2(int[][] mat) {
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
