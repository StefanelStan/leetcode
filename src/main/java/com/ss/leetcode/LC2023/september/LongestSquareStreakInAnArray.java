package com.ss.leetcode.LC2023.september;

public class LongestSquareStreakInAnArray {
    // https://leetcode.com/problems/longest-square-streak-in-an-array
    /** Algorithm
        1. Map the present numbers in an int[100001]. If a number is present, set it to 1.
        2. Loop with i from Math.sqrt(100000) to 2 and if present[i] > 0 && present[i*i] > 0
            (so both numbers are present), then set present[i] += present[i*i]
        3. Each time, set a global longestSeq = Math.max(present[i], longestSeq)
        4. Return global longestSeq.
     */
    public int longestSquareStreak(int[] nums) {
        int[] presentNums = getPresentNums(nums);
        int longestSeq = 0;
        for (int i = (int)Math.sqrt(100000); i >= 2; i--) {
            if (presentNums[i] > 0 && presentNums[i*i] > 0) {
                presentNums[i] += presentNums[i*i];
                longestSeq = Math.max(longestSeq, presentNums[i]);
            }
        }
        return longestSeq <= 1 ? -1 : longestSeq;
    }

    private int[] getPresentNums(int[] nums) {
        int[] presentNums = new int[100001];
        for (int num : nums) {
            presentNums[num] = 1;
        }
        return presentNums;
    }
}
