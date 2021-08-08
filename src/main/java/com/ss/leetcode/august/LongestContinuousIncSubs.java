package com.ss.leetcode.august;

public class LongestContinuousIncSubs {
    // https://leetcode.com/problems/longest-continuous-increasing-subsequence/
    public int findLengthOfLCIS(int[] nums) {
        int currentMax = 0, totalMax = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentMax++;
                if (currentMax > totalMax) {
                    totalMax = currentMax;
                }
            } else {
                currentMax = 0;
            }
        }
        return totalMax + 1;
    }
}
