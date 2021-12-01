package com.ss.leetcode.LC2021.september;

public class NonDecreasingArray {
    // https://leetcode.com/problems/non-decreasing-array/
    public boolean checkPossibility(int[] nums) {
        int unsorted = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (++unsorted > 1 || !canBeModified(i, nums)) {
                    unsorted = 2;
                    break;
                }
            }
        }
        return unsorted <= 1;
    }

    private boolean canBeModified(int index, int[] nums) {
        if (index == 0) {
            return true;
        }
        if (nums[index + 1] >= nums[index - 1]) {
            return true;
        }
        return nums[index] <= (index < nums.length - 2 ? nums[index + 2] : Integer.MAX_VALUE);
    }
}
