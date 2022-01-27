package com.ss.leetcode.LC2022.january;

public class MinimumFallingPathSum {
    // https://leetcode.com/problems/minimum-falling-path-sum/
    public int minFallingPathSum(int[][] matrix) {
        int[][] minPathSums = new int[matrix.length][matrix[0].length];
        System.arraycopy(matrix[matrix.length-1], 0, minPathSums[matrix.length-1],0, matrix[0].length);
        for (int i = minPathSums.length -2; i >= 0; i--) {
            for (int j = 0; j < minPathSums[i].length; j++) {
                minPathSums[i][j] = minPathSum(i,j, minPathSums, matrix);
            }
        }
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i >= 0; i--) {
            for (int j = 0; j < minPathSums[i].length; j++) {
                minSum = Math.min(minSum, minPathSums[i][j]);
            }
        }
        return minSum;
    }

    private int minPathSum(int i, int j, int[][] minPathSums, int[][] matrix) {
        // case when matrix.length == 0;
        if (matrix.length == 1) {
            return matrix[i][j];
        }
        int minVal = minPathSums[i+1][j];
        if (j > 0) {
            minVal = Math.min(minVal, minPathSums[i+1][j-1]);
        }
        if (j < minPathSums[0].length-1) {
            minVal = Math.min(minVal, minPathSums[i+1][j+1]);
        }
        return minVal + matrix[i][j];
    }
}
