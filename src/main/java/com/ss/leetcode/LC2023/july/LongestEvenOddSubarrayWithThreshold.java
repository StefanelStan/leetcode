package com.ss.leetcode.LC2023.july;

public class LongestEvenOddSubarrayWithThreshold {
    // https://leetcode.com/problems/longest-even-odd-subarray-with-threshold
    /** Algorithm
        1. Use two variables: longest (holds the answer) and start (marks the start of a good sequence)
        2. Iterate over each number and check against threshhold and/or even/odd against previous number
            - If current > threshold, reset start to -1 and continue.
            - If current and previous have same modulo, set start to -1
                (if current is odd (eg:1,1) or start = i if current is even) (eg: 4,4): the 2nd 4 can be the start of a new sequence
            - If the two numbers have different modulos and start is -1 and current is odd,
                set start to i, as this number is even and can be the start of a good sequence
        3. At any step, if start != -1 (you have a valid sequence), set longest = max(longest, windowSize)
        4. Return longest.
     */
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int longest = 0, start = -1, prev = 2;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > threshold) {
                start = -1;
            } else if (nums[i] % 2 == prev % 2) {
                start = nums[i] % 2 == 0 ? i : -1;
            } else if (nums[i] % 2 == 0 && start == -1) {
                start = i;
            }
            prev = nums[i];
            if (start != -1) {
                longest = Math.max(longest, i + 1 - start);
            }
        }
        return longest;
    }
}
