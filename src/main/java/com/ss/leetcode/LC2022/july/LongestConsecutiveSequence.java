package com.ss.leetcode.LC2022.july;

import java.util.Arrays;

public class LongestConsecutiveSequence {
    // https://leetcode.com/problems/longest-consecutive-sequence/
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Arrays.sort(nums);
        int longest = 1;
        int currentLongest = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] == 1) {
                currentLongest++;
                longest = Math.max(longest, currentLongest);
            } else if (nums[i] - nums[i-1] > 1) {
                currentLongest = 1;
            }
        }
        return longest;
    }
}
