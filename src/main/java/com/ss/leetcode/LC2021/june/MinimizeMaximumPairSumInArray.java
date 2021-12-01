package com.ss.leetcode.LC2021.june;

import java.util.Arrays;

public class MinimizeMaximumPairSumInArray {
    // https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxPair = 0, currentPair = 0;
        for (int i = 0, j = nums.length - 1; i < nums.length / 2; i++, j--) {
            currentPair = nums[i] + nums[j];
            if (currentPair > maxPair) {
                maxPair = currentPair;
            }
        }
        return maxPair;
    }
}
