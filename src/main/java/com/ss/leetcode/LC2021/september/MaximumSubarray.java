package com.ss.leetcode.LC2021.september;

public class MaximumSubarray {
    // https://leetcode.com/problems/maximum-subarray/
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int tempSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tempSum = Math.max(tempSum + nums[i], nums[i]);
            maxSum = Math.max(tempSum, maxSum);
        }
        return maxSum;
    }

    public int maxSubArray2(int[] nums) {
        int[] sums = new int[nums.length + 1];
        sums[0] = nums[0];
        int max = sums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = Math.max(sums[i - 1] + nums[i], nums[i]);
            max = Math.max(max, sums[i]);
        }
        return max;
    }


    public int maxSubArray3(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(Math.max(nums[0], nums[1]), (nums[0] + nums[1]));
        }
        int[] leftSum =  new int[nums.length];
        int[] rightSum = new int[nums.length];
        getLeftAndRightSum(leftSum, rightSum, nums);

        int maxSubArray = Integer.MIN_VALUE;
        int tempSum;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                tempSum = rightSum[0] - ((i == 0 ? 0 : leftSum[i-1]) + (j == nums.length -1 ? 0 : rightSum[j + 1]));
                maxSubArray = Math.max(maxSubArray, tempSum);
            }
        }

        return maxSubArray;
    }

    private void getLeftAndRightSum(int[] leftSum, int[] rightSum, int[] nums) {
        leftSum[0] =  nums[0];
        rightSum[nums.length -1] = nums[nums.length -1];

        for (int i = 1, j = nums.length - 2; i < nums.length; i++, j--) {
            leftSum[i] = leftSum[i -1] + nums[i];
            rightSum[j] = rightSum[j + 1] + nums[j];
        }
    }
}
