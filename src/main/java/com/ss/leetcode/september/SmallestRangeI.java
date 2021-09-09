package com.ss.leetcode.september;

public class SmallestRangeI {
    // https://leetcode.com/problems/smallest-range-i/
    public int smallestRangeI(int[] nums, int k) {
        if (nums.length == 1) {
            return 0;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }

        return Math.max((max - k) - (min + k), 0);
//        if (min + k >= max - k) {
//            return 0;
//        } else {
//            return (max - k) - (min + k);
//        }
    }
}
