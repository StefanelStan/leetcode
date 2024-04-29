package com.ss.leetcode.LC2024.april;

public class MinimumNumberOfOperationsToMakeArrayXOREqualToK {
    // https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k
    /** Algorithm
        1. The idea is to compute the XOR of all numbers and compare this result with k
        2. If there is any diference in any of the bytes, it means we "could" have changed the last number of
            nums in a way when it would get xored with the prev numbers, the result would be k
            - EG: [4,2] , k = 7
            - the XOR of [4,2] is 110 and 7 = 111
            - we observe that there is a bit difference on the least significant bit.
            - this means we "could" have changed 2 (010) to (011) (3) so that 4 ^ 3 (100 ^ 011) = 111 (7)
        3. Return how many bit differences are between XOR of array and k
     */
    public int minOperations(int[] nums, int k) {
        int xorResult = nums[0];
        int steps = 0;
        for (int i = 1; i < nums.length; i++) {
            xorResult = xorResult ^ nums[i];
        }
        while (k > 0 || xorResult > 0) {
            steps += ((k & 1) == (xorResult & 1) ? 0 : 1);
            k = k >> 1;
            xorResult = xorResult >> 1;
        }
        return steps;
    }
}
