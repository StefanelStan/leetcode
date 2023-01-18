package com.ss.leetcode.LC2023.january;

public class MaximumSumCircularSubarray {
    // https://leetcode.com/problems/maximum-sum-circular-subarray/
    /** Algorithm
     *  1. Apply the best continuous sum algorithm to detect best cont sum (if bestSum = max(nums[i], nums[i] + bestSum)
     *  2. At the same time, use 2 ints[] to store the best/max sum from left and from right;
     *  3. Iterate from n-2 to 1 and determine the max (bestSum, bestFromLeft[i-1] + bestFromRight[i+1])
     *  4. Return bestSum;
     */
    public int maxSubarraySumCircular(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] maxFromLeft = new int[nums.length];
        int[] maxFromRight = new int[nums.length];
        maxFromLeft[0] = nums[0];
        maxFromRight[maxFromRight.length -1] = nums[nums.length -1];
        int currentLeftSum = nums[0], currentRightSum = nums[nums.length -1];
        int bestContSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1, j = nums.length - 2; i < nums.length; i++, j--) {
            currentLeftSum += nums[i];
            currentRightSum += nums[j];
            maxFromLeft[i] = Math.max(maxFromLeft[i-1], currentLeftSum);
            maxFromRight[j] = Math.max(maxFromRight[j+1], currentRightSum);
            bestContSum = Math.max(nums[i], bestContSum + nums[i]);
            maxSum = Math.max(maxSum, bestContSum);
        }

        for (int j = nums.length - 2; j > 0; j--) {
            maxSum = Math.max(maxSum, maxFromRight[j+1] + maxFromLeft[j-1]);
        }
        return maxSum;
    }
}
