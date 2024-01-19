package com.ss.leetcode.LC2024.january;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubarrayWithAtMostKFrequency {
    // https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency
    /** Algorithm
        1. Create a class SubarrayWindow that will encapsulate the logic of keeping track of each number count (in a Map<>),
            subarray validity (if a number has a too high frequency)
        2. Using 2 pointers (left and right) inside while loops (while right < nums.length) expand and shrink the window
            (left++, right++) based on window validity
        3. While window is valid, add nums[right] to window (map). If the new frequency is too high, set validity to false.
            - Also determine the last good length (right - left -1)
        4. You need to shrink the window until it becomes valid: remove the nums[left].
            - If the new frequency of that number == maxFrequency - 1, it means that number was the bad number that broke the frequency,
            so validity should be good now. Set the new maxLength of subarray
     */
    public int maxSubarrayLength(int[] nums, int k) {
        int left = 0, right = 0;
        int maxLength = 0;
        SubarrayWindow window = new SubarrayWindow(k);
        while (right < nums.length) {
            while (right < nums.length && window.isValid) {
                window.addNumber(nums[right]);
                right++;
            }
            maxLength = Math.max(maxLength, right - left - 1);
            while (left < right && !window.isValid) {
                window.removeNumber(nums[left]);
                left++;
            }
            if (window.isValid) {
                maxLength = Math.max(maxLength, right - left);
            }
        }
        return maxLength;
    }

    private static class SubarrayWindow {
        private Map<Integer, Integer> numMap;
        private int maxFrequency;
        private boolean isValid = true;

        public SubarrayWindow(int maxFrequency) {
            numMap = new HashMap<>();
            this.maxFrequency = maxFrequency;
        }

        public void addNumber(int number) {
            isValid = (numMap.merge(number, 1, Integer::sum) <= maxFrequency);
        }

        public void removeNumber(int number) {
            isValid = (numMap.merge(number, -1, Integer::sum) == maxFrequency - 1);
        }
    }
}
