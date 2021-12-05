package com.ss.leetcode.LC2021.december;

public class ContinuousSubarraySum {
    // https://leetcode.com/problems/continuous-subarray-sum/
    // TLE
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        long[] leftSum = new long[nums.length];
        long[] rightSum = new long[nums.length];
        getSums(nums, leftSum, rightSum);
        if (rightSum[0] % k == 0) {
            return true;
        }
        long onLeft, onRight;
        for (int i = 0; i <= nums.length -2; i++) {
            for (int j = nums.length -1; j > i; j--) {
                onLeft = (i == 0 ? 0 : leftSum[i-1]);
                onRight = (j == nums.length -1 ? 0 : rightSum[j+1]);
                if ((rightSum[0] - (onLeft + onRight)) % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private void getSums(int[] nums, long[] leftSum, long[] rightSum) {
        leftSum[0] = nums[0];
        rightSum[nums.length -1] = nums[nums.length -1];
        for (int i = 1, j = nums.length -2; i < nums.length; i++, j--) {
            leftSum[i] = leftSum[i-1] + nums[i];
            rightSum[j] = rightSum[j+1] + nums[j];
        }
    }
}
