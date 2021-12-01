package com.ss.leetcode.LC2021.september;

public class MaximumAscendingSubarraySum {
    // https://leetcode.com/problems/maximum-ascending-subarray-sum/
    public int maxAscendingSum(int[] nums) {
        int maxSum = nums[0];
        int tempSum = maxSum;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                tempSum += nums[i];
            } else {
                tempSum = nums[i];
            }
            maxSum = Math.max(tempSum, maxSum);
        }
        return maxSum;

    }
}
