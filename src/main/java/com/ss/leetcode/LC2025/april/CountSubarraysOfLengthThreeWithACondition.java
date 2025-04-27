package com.ss.leetcode.LC2025.april;

public class CountSubarraysOfLengthThreeWithACondition {
    // https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition
    public int countSubarrays(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            count += nums[i] == 2 * (nums[i-1] + nums[i+1]) ? 1 : 0;
        }
        return count;
    }
}
