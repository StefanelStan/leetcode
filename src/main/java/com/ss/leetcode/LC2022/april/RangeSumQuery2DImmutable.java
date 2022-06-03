package com.ss.leetcode.LC2022.april;

public class RangeSumQuery2DImmutable {
    // https://leetcode.com/problems/range-sum-query-2d-immutable/
    private int[][] cumulativeSum;
    // Highest efficient solution: only need 1 int[][] to store the cumulative row/column sum
    public RangeSumQuery2DImmutable(int[][] matrix) {
        determineSum(matrix);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) {
            return cumulativeSum[row2][col2];
        }
        int leftRegionSum = col1 == 0 ? 0 : cumulativeSum[row2][col1-1];
        int topRegionSum = row1 == 0 ? 0 : cumulativeSum[row1 -1][col2];
        int overlappingRegionSum = (col1 == 0 || row1 == 0 ? 0 : cumulativeSum[row1-1][col1-1]);
        return cumulativeSum[row2][col2] - (leftRegionSum + topRegionSum - overlappingRegionSum);
    }

    private void determineSum(int[][] matrix) {
        cumulativeSum = new int[matrix.length][matrix[0].length];
        cumulativeSum[0][0] = matrix[0][0];
        // cumulative sum for row 0
        for (int j = 1; j < matrix[0].length; j++) {
            cumulativeSum[0][j] = cumulativeSum[0][j-1] + matrix[0][j];
        }
        // cumulative sum for column 0
        for(int i = 1; i < matrix.length; i++) {
            cumulativeSum[i][0] = cumulativeSum[i-1][0] + matrix[i][0];
        }
        int rowSum = 0;
        for (int i = 1; i < matrix.length; i++) {
            rowSum = matrix[i][0];
            for (int j = 1; j < matrix[i].length; j++) {
                rowSum += matrix[i][j];
                cumulativeSum[i][j] = rowSum + cumulativeSum[i-1][j];
            }
        }
    }

    // Second efficient solution as it needs 2 extra int[][] to store cumulative row/column sum
    int[][] colSum;
    int[][] rowSum;
    public void RangeSumQuery2DImmutable2(int[][] matrix) {
        colSum = new int[matrix.length][matrix[0].length];
        rowSum = new int[matrix.length][matrix[0].length];
        cumulativeSum = new int[matrix.length][matrix[0].length];
        calculateSums(matrix);
    }

    private void calculateSums(int[][] matrix) {
        calculateColSum(matrix);
        calculateRowSum(matrix);
        calculateCumulativeSum(matrix);
    }

    private void calculateColSum(int[][] matrix) {
        System.arraycopy(matrix[0], 0, colSum[0], 0, matrix[0].length);
        for (int j =0; j < matrix[0].length; j++) {
            for (int i =1; i < matrix.length; i++) {
                colSum[i][j] = colSum[i-1][j] + matrix[i][j];
            }
        }
    }

    private void calculateRowSum(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            rowSum[i][0] = matrix[i][0];
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                rowSum[i][j] = rowSum[i][j-1] + matrix[i][j];
            }
        }
    }

    private void calculateCumulativeSum(int[][] matrix) {
        // copy row0 and column 0
        System.arraycopy(rowSum[0], 0, cumulativeSum[0], 0, rowSum[0].length);
        for (int i = 1; i < matrix.length; i++) {
            cumulativeSum[i][0] = colSum[i][0];
        }

        for (int i = 1; i < matrix.length; i++) {
            for(int j =1; j < matrix[i].length; j++) {
                cumulativeSum[i][j] = cumulativeSum[i-1][j-1] + rowSum[i][j-1] + colSum[i-1][j] + matrix[i][j];
            }
        }
    }

    // Least performant solution as it needs to calculate a -> b range query sum.
    private int[][] colSum3;
    public void RangeSumQuery2DImmutable3(int[][] ints) {
        calculateColSum3(ints);
    }

    public int sumRegion3(int row1, int col1, int row2, int col2) {
        int sum = 0, upSum;
        for (int j = col1; j <= col2; j++) {
            upSum = row1 > 0 ? colSum3[row1 -1][j] : 0;
            sum += (colSum3[row2][j] - upSum);
        }
        return sum;
    }

    private void calculateColSum3(int[][] ints) {
        colSum3 = new int[ints.length][ints[0].length];
        System.arraycopy(ints[0], 0, colSum3[0], 0, ints[0].length);
        for(int i = 1; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                colSum3[i][j] = colSum3[i-1][j] + ints[i][j];
            }
        }
    }
}
