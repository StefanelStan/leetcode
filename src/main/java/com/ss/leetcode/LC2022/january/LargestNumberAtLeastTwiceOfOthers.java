package com.ss.leetcode.LC2022.january;

public class LargestNumberAtLeastTwiceOfOthers {
    // https://leetcode.com/problems/largest-number-at-least-twice-of-others/
    public int dominantIndex(int[] nums) {
        int maxIndex = -1;
        if (nums.length == 1) {
            return 0;
        }
        int[] maxes = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxes[1]) {
                maxes[0] = maxes[1];
                maxes[1] = nums[i];
                maxIndex = i;

            } else if (nums[i] > maxes[0]) {
                maxes[0] = nums[i];
            }
        }
        return maxes[0] * 2 <= maxes[1] ? maxIndex : -1;
    }
}
