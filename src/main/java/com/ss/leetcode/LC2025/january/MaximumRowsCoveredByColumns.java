package com.ss.leetcode.LC2025.january;

public class MaximumRowsCoveredByColumns {
    // https://leetcode.com/problems/maximum-rows-covered-by-columns
    /** Algorithm
        1. Get the count of 1s for each row. Use an int[matrix.length] onesCount.
        2. For each index, decide to select that column or to pick that column
        3. Picking a column will mean the onesCount[] will decrease for each row where that column has 1.
        4. Return the max result.
     */
    public int maximumRows(int[][] matrix, int numSelect) {
        int[] onesCount = getOnesCount(matrix);
        return pickColumns(0, numSelect, matrix, onesCount);
    }

    private int pickColumns(int index, int canSelect, int[][] matrix, int[] onesCount) {
        if (canSelect == 0 || canSelect > matrix[0].length - index || index == matrix[0].length) {
            return 0;
        }
        // skip
        int skip = pickColumns(index + 1, canSelect, matrix, onesCount);
        // pick
        int rowsCovered = coverRows(matrix, index, onesCount);
        int retVal = Math.max(skip, Math.max(rowsCovered, pickColumns(index + 1, canSelect - 1, matrix, onesCount)));
        uncoverRows(matrix, index, onesCount);
        return retVal;
    }

    private void uncoverRows(int[][] matrix, int index, int[] onesCount) {
        for (int i = 0; i < matrix.length; i++) {
            onesCount[i] += matrix[i][index];
        }
    }

    private int coverRows(int[][] matrix, int index, int[] onesCount) {
        int coveredRows = 0;
        for (int i = 0; i < matrix.length; i++) {
            onesCount[i] -= matrix[i][index];
            if (onesCount[i] == 0) {
                coveredRows++;
            }
        }
        return coveredRows;
    }

    private int[] getOnesCount(int[][] matrix) {
        int[] onesCount = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                onesCount[i] += matrix[i][j];
            }
        }
        return onesCount;
    }
}
