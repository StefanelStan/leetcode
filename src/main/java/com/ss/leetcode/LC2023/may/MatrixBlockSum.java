package com.ss.leetcode.LC2023.may;

public class MatrixBlockSum {
    // https://leetcode.com/problems/matrix-block-sum
    /** Algorithm
        1. Think of 1D arrays and prefix sum: you can find the range sum 3-7 by prefixSum[7] - prefixSum[2];
        2. The matrix is a 2D array and the same prefixSum but for blocks of matrix [0,0] to [i,j] can be calculated:
            the prefix blockSum of [i,j] is blockSum[i-1][j] + prefixRow[i][j-1].
            - Basically the block from above + the sum of elements from current row including current element.
        3. Given the range k, we observe this actually forms a block. An elment at [3,3] with a range 2 (k =2)
            will determine a block that starts from [1,1] (top left) and ends at [5,5] (bottom right).
        4. How to apply prefix sum and determine the block sum? Pay attention if i & j +/- k go over the size of matrix
            - Determine the blockSum from [0,0] to [5,5].
            - From this blockSum we need to eliminate the block the left [0,0] -> [0,5] and the block from above [0,0] -> [0,5].
            - As these two left and above blocks overlap at 0,0, means [0,0] was deducted twice, so we need to add in back.
        5. For each (i,j,k) you answer is blockSum[i+k][j+k] - (blockSum[i+k -1][j-k-1] - blockSum[i-k-1][j+k]) + blockSum[i-k-1][j-k-1])
            totalBlockSum - (leftBlock - upperBlock) + overlappingBlock between left and upper.
     */
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] prefixSum = getPrefixBlockSum(mat);
        int[][] blockRangeSum = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                blockRangeSum[i][j] = getBlockSum(prefixSum, i, j, k);
            }
        }
        return blockRangeSum;
    }

    private int getBlockSum(int[][] prefixSum, int i, int j, int range) {
        int r = prefixSum.length -1, c = prefixSum[r].length -1;

        int maxBlockSum = prefixSum[Math.min(r, i + range)][Math.min(c, j + range)];
        int leftSum = getLeftSum(prefixSum, i + range, (j - range) -1);
        int upperSum = getUpperSum(prefixSum, (i - range) -1, j + range);
        int overlappingBlockSum = getOverlappingBlockSum(prefixSum, (i -range) -1, (j- range) -1);
        return maxBlockSum + overlappingBlockSum - (leftSum + upperSum);
    }

    private int getLeftSum(int[][] prefixSum, int i, int j) {
        return j < 0 ? 0 : prefixSum[Math.min(prefixSum.length -1, i)][j];
    }

    private int getUpperSum(int[][] prefixSum, int i, int j) {
        return i < 0 ? 0 : prefixSum[i][Math.min(prefixSum[0].length -1, j)];
    }

    private int getOverlappingBlockSum(int[][] prefixSum, int i, int j) {
        return i < 0 || j < 0 ? 0 : prefixSum[i][j];
    }

    private int[][] getPrefixBlockSum(int[][] mat) {
        int[][] prefixSum = new int[mat.length][mat[0].length];
        int leftPrefix, upPrefix;
        for (int i = 0; i < mat.length; i++) {
            leftPrefix = 0;
            for (int j = 0; j < mat[0].length; j++) {
                upPrefix = i == 0 ? 0 : prefixSum[i-1][j];
                prefixSum[i][j] = upPrefix + leftPrefix + mat[i][j];
                leftPrefix += mat[i][j];
            }
        }
        return prefixSum;
    }
}
