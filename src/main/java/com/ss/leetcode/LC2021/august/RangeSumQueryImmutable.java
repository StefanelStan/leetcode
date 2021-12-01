package com.ss.leetcode.LC2021.august;

public class RangeSumQueryImmutable {
    // https://leetcode.com/problems/range-sum-query-immutable/
    private int[] nums;
    private int[] leftSum;
    private int[] rightSum;
    public RangeSumQueryImmutable(int[] nums) {
        this.nums = nums;
        initializeSums();
    }

    public int sumRange(int left, int right) {
        int onLeft = left > 0? leftSum[left -1] : 0;
        int onRight = right == nums.length -1 ? 0 : rightSum[right + 1];
        return rightSum[0] - (onLeft + onRight);
    }

    private void initializeSums() {
        leftSum = new int[nums.length];
        rightSum = new int[nums.length];

        leftSum[0] = nums[0];
        rightSum[rightSum.length - 1] = nums[nums.length -1];

        for(int i = 1, j = nums.length -2; j >= 0; i++, j--) {
            leftSum[i] += leftSum[i-1] + nums[i];
            rightSum[j] = rightSum[j + 1] + nums[j];
        }
    }
}
