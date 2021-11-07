package com.ss.leetcode.november;

public class SumOfAbsoluteDiffSortedArray {
    // https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] leftSum =  new int[nums.length];
        int[] rightSum = new int[nums.length];
        calculateSums(nums, leftSum, rightSum);
        return getDifferences(nums, leftSum, rightSum);
    }

    private void calculateSums(int[] nums, int[] leftSum, int[] rightSum) {
        leftSum[0] = nums[0];
        rightSum[nums.length -1] = nums[nums.length-1];
        for (int i = 1, j = nums.length-2; i < nums.length; i++, j--) {
            leftSum[i] = leftSum[i-1] + nums[i];
            rightSum[j] = rightSum[j+1] + nums[j];
        }
    }

    private int[] getDifferences(int[] nums, int[] leftSum, int[] rightSum) {
        int[] differences = new int[nums.length];
        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            left = (i == 0 ? 0 : ( nums[i] * i - leftSum[i-1]));
            right = (i == nums.length -1 ? 0 : (rightSum[i+1] - nums[i] * (nums.length - i -1)));
            differences[i] = left + right;
        }
        return differences;
    }
}
