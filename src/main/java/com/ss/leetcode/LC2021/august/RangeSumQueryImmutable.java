package com.ss.leetcode.LC2021.august;

public class RangeSumQueryImmutable {
    // https://leetcode.com/problems/range-sum-query-immutable/
    private final int[] leftSum;
    private final int[] rightSum;

    public RangeSumQueryImmutable(int[] nums) {
        leftSum = new int[nums.length];
        rightSum = new int[nums.length];
        calculateSums(nums);
    }

    public int sumRange(int left, int right) {
        int leftExclusion = left == 0 ? 0 : leftSum[left -1];
        int rightExclusion = right == rightSum.length -1 ? 0 : rightSum[right + 1];
        return rightSum[0] - (leftExclusion + rightExclusion);
    }

    private void calculateSums(int[] nums) {
        leftSum[0] = nums[0];
        rightSum[nums.length -1] = nums[nums.length -1];
        for(int i = 1, j = nums.length -2; i < nums.length; i++, j--) {
            leftSum[i] = leftSum[i-1] + nums[i];
            rightSum[j] = rightSum[j+1] + nums[j];
        }
    }
}
