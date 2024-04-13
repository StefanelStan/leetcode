package com.ss.leetcode.LC2024.april;

public class MaximalRectangle {
    // https://leetcode.com/problems/maximal-rectangle
    /** Algorithm
        1. Calculate the prefixSum for each row
        2. For each column j (0..n-1) expand a window on the column k = j ..n-1.
        3. For each expansion, traverser each row and compute the sum of prefixes.
            - EG: j = 3.
            - k = 3, traverse each row and compute the sum of the columns 3-3.
            - k = 4, traverse each row and compute the prefix sum for columns 3-4
        4. If the rowsum == 1 + k - j (ALL 1s), then that sum can be added to the block sum, else set it to 0.
        5. Return the max block sum for the block of columns [j-k] over rows 0..n
     */
    public int maximalRectangle(char[][] matrix) {
        int maxSize = 0;
        int[][] prefixSum = getPrefixSum(matrix);
        for (int j = 0; j < matrix[0].length; j++) {
            for (int k = j; k < matrix[0].length; k++) {
                maxSize = Math.max(maxSize, getMaxSize(prefixSum, j, k));
            }
        }
        return maxSize;
    }

    private int getMaxSize(int[][] prefixSum, int j, int k) {
        int maxSize = 0, currentSize = 0, onLeft;
        for (int[] ints : prefixSum) {
            onLeft = (j == 0 ? 0 : ints[j - 1]);
            currentSize = 1 + k - j == ints[k] - onLeft ? currentSize + 1 + k - j : 0;
            maxSize = Math.max(maxSize, currentSize);
        }
        return maxSize;
    }

    private int[][] getPrefixSum(char[][] matrix) {
        int[][] prefixSum = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < prefixSum.length; i++) {
            prefixSum[i][0] = matrix[i][0] - '0';
            for (int j = 1; j < matrix[0].length; j++) {
                prefixSum[i][j] = prefixSum[i][j-1] + (matrix[i][j] - '0');
            }
        }
        return prefixSum;
    }
}
