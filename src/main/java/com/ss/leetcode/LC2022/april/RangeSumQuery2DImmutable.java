package com.ss.leetcode.LC2022.april;

public class RangeSumQuery2DImmutable {
    // https://leetcode.com/problems/range-sum-query-2d-immutable/
    private int[][] colSum;
    public RangeSumQuery2DImmutable(int[][] ints) {
        calculateColSum(ints);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0, upSum;
        for (int j = col1; j <= col2; j++) {
            upSum = row1 > 0 ? colSum[row1 -1][j] : 0;
            sum += (colSum[row2][j] - upSum);
        }
        return sum;
    }

    private void calculateColSum(int[][] ints) {
        colSum = new int[ints.length][ints[0].length];
        System.arraycopy(ints[0], 0, colSum[0], 0, ints[0].length);
        for(int i = 1; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                colSum[i][j] = colSum[i-1][j] + ints[i][j];
            }
        }
    }
}
