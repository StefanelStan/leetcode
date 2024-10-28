package com.ss.leetcode.LC2023.september;

import java.util.Arrays;

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

    // Sort + Binary Search square solution
    public int longestSquareStreak2(int[] nums) {
        Arrays.sort(nums);
        int[] streaks = new int[nums.length];
        int longestStreak = 0, prev = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            streaks[i] = nums[i] == prev ? streaks[i + 1] : 1 + findSquareStreak(i, nums.length -1, nums[i] * nums[i], nums, streaks);
            longestStreak = Math.max(longestStreak, streaks[i]);
            prev = nums[i];
        }
        return longestStreak == 1 ? -1 : longestStreak;
    }

    private int findSquareStreak(int left, int right, int target, int[] nums, int[] streaks) {
        int pivot;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) {
                return streaks[pivot];
            } else if (nums[pivot] > target) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return 0;
    }
}
