package com.ss.leetcode.LC2023.march;

public class CheckIfArrayIsSortedAndRotated {
    // https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
    public boolean check(int[] nums) {
        boolean rotationEncountered = false;
        int min = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] <= nums[i+1]) {
                if (rotationEncountered && nums[i+1] > min) {
                    return false;
                }
            } else {
                if(rotationEncountered || nums[i+1] > min) {
                    return false;
                }
                rotationEncountered = true;
            }
        }
        return true;
    }
}
