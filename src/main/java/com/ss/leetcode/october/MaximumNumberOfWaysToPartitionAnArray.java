package com.ss.leetcode.october;

public class MaximumNumberOfWaysToPartitionAnArray {
    // https://leetcode.com/contest/biweekly-contest-62/problems/maximum-number-of-ways-to-partition-an-array/
    public int waysToPartition(int[] nums, int k) {
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        initializeSums(nums, leftSum, rightSum);
        int numOfWays = 0;
        int sumOfLeftElements, sumOfRightElements;
        for (int i = 1; i < nums.length; i++) {
            sumOfLeftElements = leftSum[i - 1];
            sumOfRightElements = rightSum[i];
            if (sumOfLeftElements == sumOfRightElements) {
                numOfWays++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            numOfWays = Math.max(numOfWays, calculatePotentialPartition(leftSum, rightSum, nums, i, k));
        }
        return numOfWays;
    }

    private int calculatePotentialPartition(int[] leftSum, int[] rightSum, int[] nums, int index, int k) {
        int sumOfLeftElements, sumOfRightElements, numOfWays = 0;
        for (int i = 1; i < leftSum.length; i++) {
            sumOfLeftElements = leftSum[i - 1];
            sumOfRightElements = rightSum[i];
            if (index < i) {
                sumOfLeftElements = (sumOfLeftElements - nums[index]) + k;
            } else {
                sumOfRightElements = (sumOfRightElements - nums[index]) + k;
            }
            if (sumOfLeftElements == sumOfRightElements) {
                numOfWays++;
            }
        }
        return numOfWays;
    }

    private void initializeSums(int[] nums, int[] leftSum, int[] rightSum) {
        leftSum[0] = nums[0];
        rightSum[rightSum.length - 1] = nums[nums.length -1];

        for(int i = 1, j = nums.length -2; j >= 0; i++, j--) {
            leftSum[i] += leftSum[i-1] + nums[i];
            rightSum[j] = rightSum[j + 1] + nums[j];
        }
    }
}
