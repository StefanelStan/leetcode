package com.ss.leetcode.LC2022.january;

public class RangeSumQueryMutable {
    // https://leetcode.com/problems/range-sum-query-mutable/
    // TLE on 12/15
    int[] sums;
    int[] numz;
    public RangeSumQueryMutable(int[] nums) {
        this.numz = nums;
        sums = new int[nums.length];
        calculateSum(0);
    }

    public void update(int index, int val) {
        numz[index] = val;
        calculateSum(index);
    }

    public int sumRange(int left, int right) {
        int sumLeft = left == 0 ? 0 : sums[left -1];
        return sums[right] - sumLeft;
    }

    private void calculateSum(int from) {
        sums[from] = from == 0 ? numz[0] : sums[from-1] + numz[from];
        for (int i = from + 1; i < numz.length; i++) {
            sums[i] = sums[i-1] + numz[i];
        }
    }

    /* Wrong way, too slow and inefficient
    int[] nums;
    int[] leftSum;
    int[] rightSum;
    public RangeSumQueryMutable(int[] nums) {
        this.nums = nums;
        calculateSums();
    }

    public void update(int index, int val) {
        nums[index] = val;
        calculateSums();
    }

    public int sumRange(int left, int right) {
        int outLeftSum = (left == 0 ? 0 : leftSum[left -1]);
        int outRightSum = (right == nums.length -1 ? 0 : rightSum[right + 1]);
        return leftSum[nums.length -1] - (outLeftSum + outRightSum);
    }

    private void calculateSums() {
        leftSum = new int[nums.length];
        rightSum = new int[nums.length];
        leftSum[0] = nums[0];
        rightSum[nums.length -1] = nums[nums.length -1];
        for (int i = 1, j = nums.length -2; i < nums.length; i++, j--) {
            leftSum[i] = leftSum[i-1] + nums[i];
            rightSum[j] = rightSum[j+1] + nums[j];
        }
    }
     */
}
