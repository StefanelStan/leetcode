package com.ss.leetcode.LC2024.july;

public class NumberOfSubarraysThatMatchAPatternI {
    // https://leetcode.com/problems/number-of-subarrays-that-match-a-pattern-i
    /** Algorithm
        1. For each segment [i,j] of length pattern +1 we need to determine if two consecutive numbers follow the pattern format
        2. For an array of length n and a pattern of length p, you will have n -  p total segments
        3. Iterate with i from [1 .. n - p] and determine if the current segment matches the pattern
            - eg. for each index of segment check the pattern and verify:
            - pattern == 0 and prev != curr then break -> return false
        4. Return total matches.
     */
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int totalMatching = 0;
        for (int i = 1; i < 1 + nums.length - pattern.length; i++) {
            totalMatching += matchesPattern(i, nums, pattern) ? 1 : 0;
        }
        return totalMatching;
    }

    private boolean matchesPattern(int from, int[] nums, int[] pattern) {
        for (int i = 0; i < pattern.length; i++) {
            if ((nums[from + i - 1]  >= nums[from + i] && pattern[i] == 1)
                || (nums[from + i - 1] != nums[from + i] && pattern[i] == 0)
                || (nums[from + i - 1] <= nums[from + i] && pattern[i] == -1)) {
                return false;
            }
        }
        return true;
    }
}
