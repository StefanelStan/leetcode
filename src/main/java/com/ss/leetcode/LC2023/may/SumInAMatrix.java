package com.ss.leetcode.LC2023.may;

import java.util.Arrays;

public class SumInAMatrix {
    // https://leetcode.com/problems/sum-in-a-matrix
    /** Algorithm
        1. Sort each row in increasing order.
        2. For each column j = m-1 .. 0:
            - loop on rows 0..n-1 and determine the max of that column.
            - add the max of that column to the sum and advance j.
        3. Return the sum.
     */
    public int matrixSum(int[][] nums) {
        for (int[] row : nums) {
            Arrays.sort(row);
        }
        int sum = 0, colMax;
        for (int j = nums[0].length - 1; j >= 0; j--) {
            colMax = 0;
            for (int[] row : nums) {
                colMax = Math.max(colMax, row[j]);
            }
            sum += colMax;
        }
        return sum;
    }
}
