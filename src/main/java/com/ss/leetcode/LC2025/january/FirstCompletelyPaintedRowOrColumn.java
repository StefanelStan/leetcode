package com.ss.leetcode.LC2025.january;

public class FirstCompletelyPaintedRowOrColumn {
    // https://leetcode.com/problems/first-completely-painted-row-or-column
    /** Algorithm
        1. Use an int[arr.length + 1] to save the position (x/y) of each number from matrix.
            - The target would be i * mat[0].length + j;
        2. Use two int[]rowCount, colCount to keep track of how many colors cells have on each row
        3. Traverse arr and get the position of the number from position arr.
            - Get its x,y and paint the rowCount, colCount.
        4. When rowCount[x] == mat[0].length Or colCount[y] == mat.length return the index.
     */
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int[] position = new int[arr.length + 1];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                position[mat[i][j]] = i * mat[0].length + j;
            }
        }
        int[] rowColors = new int[mat.length];
        int[] colColors = new int[mat[0].length];
        int targetRow, targetCol;
        for (int i = 0; i < arr.length; i++) {
            targetRow = position[arr[i]] / mat[0].length;
            targetCol = position[arr[i]] % mat[0].length;
            rowColors[targetRow]++;
            colColors[targetCol]++;
            if (rowColors[targetRow] == mat[0].length || colColors[targetCol] == mat.length) {
                return i;
            }
        }
        return mat.length * mat[0].length;
    }
}
