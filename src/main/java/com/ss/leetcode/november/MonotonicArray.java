package com.ss.leetcode.november;

public class MonotonicArray {
    // https://leetcode.com/problems/monotonic-array/
    /** Algorithm:
         - Pre-determine the way first and last element relate and how the array should be.
             if [0] < [n], then array should be monotonicIncreasing, else monotonicDecreasing.
         - Traverse the array and compare each two elements against the predetermined expected rule. If they do not respect the
             preset rule, return false immediately.
     */
    public boolean isMonotonic(int[] nums) {
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
