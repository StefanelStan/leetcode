package com.ss.leetcode.july;

public class FindPeakElement {
    // https://leetcode.com/problems/find-peak-element/
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums.length == 2) return (nums[0] > nums[1] ? 0 : 1);
        for (int i = 1; i < nums.length -1; i++) {
            if (nums[i + 1] > nums[i]) {
                continue;
            }
            if (nums[i] > nums[i -1]) {
                return i;
            }
        }
        return nums[0] > nums[1] ? 0 : nums[nums.length -1] > nums[nums.length-2] ? nums.length -1 : 0;
    }
}
