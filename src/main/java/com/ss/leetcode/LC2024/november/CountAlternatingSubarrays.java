package com.ss.leetcode.LC2024.november;

public class CountAlternatingSubarrays {
    // https://leetcode.com/problems/count-alternating-subarrays
    /** Algorithm
        1. Expand a window (left, right) while char[right] != char[right + 1]
        2. Inside this valid window you have n * (n+1) /2 substrings. (1 + right - left)
        3. Adjust left and right to right +1 (window starts at next position where right stopped)
     */
    public long countAlternatingSubarrays(int[] nums) {
        long count = 0L;
        int left = 0, right = 0;
        while (left < nums.length) {
            while (right < nums.length - 1 && nums[right] != nums[right + 1]) {
                right++;
            }
            count += (long)(1 + right - left) * (2 + right - left) / 2;
            left = ++right;
        }
        return count;
    }
}
