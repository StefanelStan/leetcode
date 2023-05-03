package com.ss.leetcode.LC2023.may;

public class MinimumSizeSubarraySum {
    // https://leetcode.com/problems/minimum-size-subarray-sum
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sum = 0;
        int minLength = Integer.MAX_VALUE;
        while (left < nums.length || right < nums.length) {
            if (sum < target) {
                if (right < nums.length) {
                    sum += nums[right];
                    right++;
                } else {
                    break;
                }
            } else {
                minLength = Math.min(minLength, right - left);
                sum -= nums[left];
                left++;
                right = Math.max(right, left);
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
