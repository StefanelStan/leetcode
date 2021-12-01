package com.ss.leetcode.LC2021.july;

public class MinimumOperationsArrayIncreasing {
    // https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing/
    /** Less performant with this
    public int minOperations(int[] nums) {
        int operations = 0, differennce = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i-1]) {
                differennce = nums[i-1] - nums[i] + 1;
                nums[i] += differennce;
                operations += differennce;
            }
        }
        return operations;
    }
     */
    // more performant
    public int minOperations(int[] nums) {
        int operations = 0, expectedMinimum = nums[0] + 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < expectedMinimum) {
                operations += expectedMinimum - nums[i];
                expectedMinimum++;
            } else {
                expectedMinimum = nums[i] +1;
            }
        }
        return operations;
    }
}
