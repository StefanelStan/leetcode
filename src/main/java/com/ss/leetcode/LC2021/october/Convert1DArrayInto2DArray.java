package com.ss.leetcode.LC2021.october;

public class Convert1DArrayInto2DArray {
    // https://leetcode.com/contest/biweekly-contest-62/problems/convert-1d-array-into-2d-array/
    /** Algorithm
        1. Fail fast: if n * m != original.length return int[0][0]
        2. Else, allocate a new matrix[m][n]
        3. Iterate with index i over original. i / n will give you the row number to insert and i % n the column index
        4. Insert elements and return answer.
     */
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (n * m != original.length) {
            return new int[0][0];
        }
        int[][] answer = new int[m][n];
        for (int i = 0; i < original.length; i++) {
            answer[i / n][i % n] = original[i];
        }
        return answer;
    }


    public int[][] construct2DArray2(int[] original, int m, int n) {
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
