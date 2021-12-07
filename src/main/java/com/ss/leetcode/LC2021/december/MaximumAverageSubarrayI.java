package com.ss.leetcode.LC2021.december;

public class MaximumAverageSubarrayI {
    // https://leetcode.com/problems/maximum-average-subarray-i/
    public double findMaxAverage(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE;
        int tempSum = 0;
        for (int i = 0; i < k; i++) {
            tempSum += nums[i];
        }
        maxSum = tempSum;
        for (int i = 1; i <= nums.length - k; i++) {
            tempSum = tempSum - nums[i-1] + nums[i +k -1];
            maxSum = Math.max(tempSum, maxSum);
        }
        return (double)maxSum / k;
    }
}
