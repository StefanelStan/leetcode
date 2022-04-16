package com.ss.leetcode.LC2021.november;

public class MonotonicArray {
    // https://leetcode.com/problems/monotonic-array/
    /** Algorithm:
         - Pre-determine the way first and last element relate and how the array should be.
             if [0] < [n], then array should be monotonicIncreasing, else monotonicDecreasing.
         - Traverse the array and compare each two elements against the predetermined expected rule. If they do not respect the
             preset rule, return false immediately.
     */
    public boolean isMonotonic(int[] nums) {
        if (nums.length < 3) {
            return true;
        }
        if (nums[0] <= nums[nums.length -1]) {
            return areInIncreasingOrder(nums, 0, nums.length-1, 1);
        }  else {
            return areInIncreasingOrder(nums, nums.length-1, 0, -1);
        }
    }

    private boolean areInIncreasingOrder(int[] nums, int start, int stop, int direction) {
        for (int i = start; i != stop; i+= direction) {
            if (nums[i] > nums[i + direction]) {
                return false;
            }
        }
        return true;
    }

    public boolean isMonotonic2(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        boolean monotonicI = nums[0] <= nums[nums.length -1];
        boolean monotonicD = !monotonicI;
        for (int i = 0; i < nums.length -1; i++) {
            if (nums[i] < nums[i+1] && monotonicD) {
                return false;
            } else if (nums[i] > nums[i+1] && monotonicI) {
                return false;
            }
        }
        return true;
    }
}
