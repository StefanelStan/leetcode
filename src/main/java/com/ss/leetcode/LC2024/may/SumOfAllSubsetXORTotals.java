package com.ss.leetcode.LC2024.may;

public class SumOfAllSubsetXORTotals {
    // https://leetcode.com/problems/sum-of-all-subset-xor-totals
    /** Algorithm
        1. Use an Int[n][32] to chache the xor results of index i with a rolling xor value of x
        2. Apply DP: if current index and xor are not yet computed, they are the sum of skip (index + 1, xor) and
            select (index+1, xor ^ nums[index]).
     */
    public int subsetXORSum(int[] nums) {
        Integer[][] xorSum = new Integer[nums.length][32];
        calculateXor(nums, 0, 0, xorSum);
        return xorSum[0][0];
    }

    private int calculateXor(int[] nums, int index, int xor, Integer[][] xorSum) {
        if (index == nums.length) {
            return xor;
        }
        if (xorSum[index][xor] == null) {
            xorSum[index][xor] = calculateXor(nums, index + 1, xor, xorSum) + calculateXor(nums, index + 1, (nums[index] ^ xor), xorSum);
        }
        return xorSum[index][xor];
    }
}
