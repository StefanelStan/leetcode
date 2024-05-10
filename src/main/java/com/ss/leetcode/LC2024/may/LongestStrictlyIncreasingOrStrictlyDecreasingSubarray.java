package com.ss.leetcode.LC2024.may;

public class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {
    // https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray
    /** Algorithm
        1. Keep track of longestIncreasing, longestDecreasing known so far
        2. Traverse the nums and use two variables: currentIncreasing, currentDecreasing
        3. If current num > prevNum, increment currentIncreasing and reset currentDecreasing
        4. If current num < prevNum, increment currentDecreasing and reset currentIncreasing
        5. Else reset both.
        6. At each step, keep track of max longestIncreasing and longestDecreasing
        7. Return 1 + max(longestIncreasing, longestDecreasing)
     */
    public int longestMonotonicSubarray(int[] nums) {
        int longestIncreasing = 0, longestDecreasing = 0;
        int currentIncreasing = 0, currentDecreasing = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                currentIncreasing++;
                currentDecreasing = 0;
                longestIncreasing = Math.max(longestIncreasing, currentIncreasing);
            } else if (nums[i - 1] > nums[i]) {
                currentDecreasing++;
                longestDecreasing = Math.max(longestDecreasing, currentDecreasing);
                currentIncreasing = 0;
            } else {
                currentDecreasing = 0;
                currentIncreasing = 0;
            }
        }
        return 1 + Math.max(longestIncreasing, longestDecreasing);
    }
}
