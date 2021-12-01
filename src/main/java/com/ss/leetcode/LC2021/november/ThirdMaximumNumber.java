package com.ss.leetcode.LC2021.november;

public class ThirdMaximumNumber {
    // https://leetcode.com/problems/third-maximum-number/
    public int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        Integer[] maximums = new Integer[3];
        for (int num : nums) {
            injectMaximum(maximums, num);
        }
        if (maximums[0] == null) {
            return maximums[2];
        } else {
            return maximums[0];
        }
    }

    private void injectMaximum(Integer[] maximums, int num) {
        if (maximums[2] == null) {
            maximums[2] = num;
            return;
        }
        if (num > maximums[2]) {
            maximums[0] = maximums[1];
            maximums[1] = maximums[2];
            maximums[2] = num;
            return;
        }
        if (maximums[1] == null) {
            if (num != maximums[2]) {
                maximums[1] = num;
            }
            return;
        }
        if (num > maximums[1] && num != maximums[2]) {
            maximums[0] = maximums[1];
            maximums[1] = num;
            return;
        }
        if (num != maximums[1] && num != maximums[2] && (maximums[0] == null || num > maximums[0])){
            maximums[0] =  num;
        }
    }
}
