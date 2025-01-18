package com.ss.leetcode.LC2025.january;

public class MinimumEqualSumOfTwoArraysAfterReplacingZeros {
    // https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros
    /** Algorithm
        1. Look at each array as a POTENTIAL MIN sum. [3,4,0] has a sum of 7, but the single 0 can be replaced by 1, thus the
            potention sum is 8.
        2. Traverse both arrays and return their potential sum[] in the form om [sum, countOfZerros].
            sum + countOfZeroes will give you the potential sum.
        3. If arrays have the same potential sum, then this is your answer
        4. Else, you need to "bring" the min potential sum to the same level as max potential sum (of two arrays)
        5. If min potential sum has zero zeroes, then we cannot lift the min sum; return -1
        6. Else, return max potential sum.
     */
    public long minSum(int[] nums1, int[] nums2) {
        long[] sumAndZeroes1 = getSumAndZeroes(nums1);
        long[] sumAndZeroes2 = getSumAndZeroes(nums2);
        if (sumAndZeroes1[0] + sumAndZeroes1[1] == sumAndZeroes2[0] + sumAndZeroes2[1]) {
            return sumAndZeroes1[0] + sumAndZeroes1[1];
        }
        long[] minSum = sumAndZeroes1[0] + sumAndZeroes1[1] < sumAndZeroes2[0] + sumAndZeroes2[1] ? sumAndZeroes1 : sumAndZeroes2;
        long[] maxSum = (minSum == sumAndZeroes1 ? sumAndZeroes2 : sumAndZeroes1);
        return minSum[1] == 0 ? -1 : maxSum[0] + maxSum[1];
    }

    private long[] getSumAndZeroes(int[] nums) {
        long[] sumAndZeroes = {0,0};
        for (int num : nums) {
            if (num == 0) {
                sumAndZeroes[1]++;
            }
            sumAndZeroes[0] += num;
        }
        return sumAndZeroes;
    }
}
