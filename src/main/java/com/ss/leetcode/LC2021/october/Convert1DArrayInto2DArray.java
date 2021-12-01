package com.ss.leetcode.LC2021.october;

public class Convert1DArrayInto2DArray {
    // https://leetcode.com/contest/biweekly-contest-62/problems/convert-1d-array-into-2d-array/
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) {
            return new int[0][0];
        }
        int[][] result = new int[m][n];
        int rowIndex = 0;
        for (int i = 0; i < m; i++) {
            System.arraycopy(original, rowIndex, result[i],0, n);
            rowIndex += n;
        }
        return result;
    }
}
