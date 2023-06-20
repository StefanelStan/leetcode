package com.ss.leetcode.LC2023.june;

public class KRadiusSubarrayAverages {
    // https://leetcode.com/problems/k-radius-subarray-averages
    public int[] getAverages(int[] nums, int k) {
        int[] averages = new int[nums.length];
        if (k == 0) {
            return nums;
        }
        long sum = getAveragesAndSum(nums, averages, k);
        if (2 * k + 1 > nums.length) {
            return averages;
        }
        int count = 2 * k + 1;
        averages[k] = (int)(sum / count);
        for (int i = 1, j = 2 * k + 1; j < nums.length; i++, j++) {
            sum += nums[j] - nums[i-1];
            averages[i+k] = (int)(sum / count);
        }
        return averages;
    }

    private long getAveragesAndSum(int[] nums, int[] averages, int k) {
        long sum = 0;
        for (int i = 0; i <= Math.min(2*k, nums.length -1); i++) {
            sum += nums[i];
            if (i < k) {
                averages[i] = -1;
                averages[nums.length - 1 - i] = -1;
            }
        }
        return sum;
    }
}
