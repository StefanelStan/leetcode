package com.ss.leetcode.LC2024.october;

public class SplitArrayIntoMaximumNumberOfSubarrays {
    // https://leetcode.com/problems/split-array-into-maximum-number-of-subarrays
    /** Algorithm
        1. Calculate the AND prefix of ALL numbers. This prefix will be the lowest prefixAnd that can be achieved.
        2. If prefixAnd is 0, then we can try to split it in as many chunks as possible, because 0 + 0 +.. + 0 = 0. The sum of all chunks is 0.
        3. However, if the prefix is not zero (eg: 7), splitting it into more chunks will lead to a sum of 7+7+..+7.
            - This is greater than 1 single chunk, so we only need to split it into 1 chunk, just to obtain the minumum score.
     */
    public int maxSubarrays(int[] nums) {
        int minAnd = nums[0];
        for (int num : nums) {
            minAnd &= num;
        }
        if (minAnd != 0) {
            return 1;
        }
        int segments = 0, prefixAnd = nums[0];
        for (int i = 0; i < nums.length; i++) {
            prefixAnd &= nums[i];
            if (prefixAnd == minAnd) {
                segments++;
                prefixAnd = i < nums.length - 1 ? nums[i+1] : -1;
            }
        }
        return segments;
    }
}
