package com.ss.leetcode.LC2025.march;

public class FindMissingAndRepeatedValues {
    // https://leetcode.com/problems/find-missing-and-repeated-values
    /** Algorithm
        1. Use a boolean[n+1] existing to mark the numbers that already exist. If existing[num] = true, than you have the duplicate number
        2. The expected sum of 1+ .. + n*n is n*n * (n * n + 1).
        3. Traverse grid and mark the present numbers. Also calculate their cumulative sum
        4. The difference between expectedSum and  (cumulativeSum - duplicate) is the missing number.
     */
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int totalExpected = n * n * (n * n + 1) / 2;
        boolean[] existing = new boolean[n * n + 1];
        int duplicate = 0, currentSum = 0;
        for (int[] row : grid) {
            for (int num : row) {
                if (existing[num]) {
                    duplicate = num;
                }
                existing[num] = true;
                currentSum += num;
            }
        }
        return new int[]{duplicate, totalExpected - (currentSum - duplicate)};
    }
}
