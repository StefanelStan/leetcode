package com.ss.leetcode.LC2025.november;

public class MinimumOperationsToMakeArraySumDivisibleByK {
    // https://leetcode.com/problems/minimum-operations-to-make-array-sum-divisible-by-k
    /** Algorithm
        1. Get the sum of numbers
        2. The min ops will be the number of deduction required to reach a modulo of 0.
        3. Return sum % k;
     */
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum % k;
    }
}
