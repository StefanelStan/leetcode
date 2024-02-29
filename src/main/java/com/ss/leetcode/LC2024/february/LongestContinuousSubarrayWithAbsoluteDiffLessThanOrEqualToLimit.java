package com.ss.leetcode.LC2024.february;

import java.util.TreeMap;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    // https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit
    public int longestSubarray(int[] nums, int limit) {
        SubarrayWindow sw = new SubarrayWindow(limit);
        int left = 0, right = 1, longest = 1;
        sw.addNumber(nums[0]);
        while(right < nums.length) {
            while(right < nums.length && sw.isValid()) {
                longest = Math.max(longest, right - left);
                sw.addNumber(nums[right++]);
            }
            while (left < right && !sw.isValid()) {
                sw.removeNumber(nums[left++]);
            }
            longest = Math.max(longest, right - left);
        }
        return longest;
    }

    private static class SubarrayWindow {
        private final TreeMap<Integer, Integer> nums;
        private final int limit;

        public SubarrayWindow(int limit) {
            this.nums = new TreeMap<>();
            this.limit = limit;
        }

        public void addNumber(int number) {
            nums.merge(number, 1, Integer::sum);
        }

        public void removeNumber(int number) {
            int result = nums.merge(number, -1, Integer::sum);
            if (result == 0) {
                nums.remove(number);
            }
        }

        public boolean isValid() {
            return nums.lastKey() - nums.firstKey() <= limit;
        }
    }
}
