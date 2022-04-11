package com.ss.leetcode.LC2022.april;

public class CheckIfEveryRowAndColumnContainsAllNumbers {
    // https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/
    public boolean checkValid(int[][] matrix) {
        return checkValidRows(matrix) && checkValidColumns(matrix);
    }

    private boolean checkValidRows(int[][] matrix) {
        boolean[] seen;
        for(int[] row : matrix) {
            seen = new boolean[row.length + 1];
            for (int item : row) {
                if(seen[item]) {
                    return false;
                }
                seen[item] = true;
            }
        }
        return true;
    }

    private boolean checkValidColumns(int[][] matrix) {
        boolean[] seen;
        for(int j = 0; j < matrix.length; j++) {
            seen = new boolean[matrix.length + 1];
            for (int[] ints : matrix) {
                if (seen[ints[j]]) {
                    return false;
                }
                seen[ints[j]] = true;
            }
        }
        return true;
    }
}
