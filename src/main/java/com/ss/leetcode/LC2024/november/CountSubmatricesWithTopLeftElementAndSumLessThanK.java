package com.ss.leetcode.LC2024.november;

public class CountSubmatricesWithTopLeftElementAndSumLessThanK {
    // https://leetcode.com/problems/count-submatrices-with-top-left-element-and-sum-less-than-k
    /** Algorithm
        1. Fail fast: if grid[i][j] > k return 0 (So sum is possible)
        2. Else, traverse each row / column and determine/set the current prefixSum + prevRow prefix sum for each column.
            - use a rowSum[n] to keep the value of prefix sum of previous row/matrix
            - use a nextRowSum[] to compute the prefix sum of current row  + prevRow[j]
            - break the 2nd for when nextRowSum[j] > k
            - if nextRowSum[j] <= k, increment a totalCount
        3. Return totalCount
     */
    public int countSubmatrices(int[][] grid, int k) {
        if (grid[0][0] > k) {
            return 0;
        }
        int[] rowSum = new int[grid[0].length];
        int[] nextRowSum;
        int count = 0, prefixRowSum;
        for (int[] row : grid) {
            nextRowSum = new int[rowSum.length];
            prefixRowSum = 0;
            for (int j = 0; j < rowSum.length; j++) {
                prefixRowSum += row[j];
                nextRowSum[j] = prefixRowSum + rowSum[j];
                if (nextRowSum[j] > k) {
                    break;
                } else {
                    count++;
                }
            }
            rowSum = nextRowSum;
        }
        return count;
    }
}
