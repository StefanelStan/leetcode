package com.ss.leetcode.LC2022.august;

public class MaxSumOfRectangleNoLargerThanK {
    // https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int[][] matrixSum = getMatrixSum(matrix, k);
        // if we detect one element == k, then our submatrix has 1 element
        if (matrixSum == null) {
            return k;
        }
        int maxSum = Integer.MIN_VALUE, blockSum;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                blockSum = getBlockSum(matrixSum, i, j, k);
                if (blockSum <= k) {
                    maxSum = Math.max(blockSum, maxSum);
                }
            }
        }
        return maxSum;
    }

    // if we detect one element with value k, we hot-wire it and return null
    private int[][] getMatrixSum(int[][] matrix, int k) {
        int[][] blockSum = new int[matrix.length][matrix[0].length];
        blockSum[0][0] = matrix[0][0];
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == k) return null;
            blockSum[0][j] = blockSum[0][j-1] + matrix[0][j];
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == k) return null;
            blockSum[i][0] = blockSum[i-1][0] + matrix[i][0];
        }
        int rowSum;
        for (int i = 1; i < matrix.length; i++) {
            rowSum = matrix[i][0];
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == k) return null;
                rowSum += matrix[i][j];
                blockSum[i][j] = rowSum + blockSum[i-1][j];
            }
        }
        return blockSum;
    }

    private int getBlockSum(int[][] blockSum, int row, int col, int k) {
        int closestSum = Integer.MIN_VALUE;
        int segmentSum;
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                segmentSum = sumRegion(blockSum, i, j, row, col);
                if (segmentSum <= k) {
                    closestSum = Math.max(closestSum, segmentSum);
                }
            }
        }
        return closestSum;
    }

    public int sumRegion(int[][] blockSum, int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) {
            return blockSum[row2][col2];
        }
        int leftRegionSum = col1 == 0 ? 0 : blockSum[row2][col1-1];
        int topRegionSum = row1 == 0 ? 0 : blockSum[row1 -1][col2];
        int overlappingRegionSum = (col1 == 0 || row1 == 0 ? 0 : blockSum[row1-1][col1-1]);
        return blockSum[row2][col2] - (leftRegionSum + topRegionSum - overlappingRegionSum);
    }
}
