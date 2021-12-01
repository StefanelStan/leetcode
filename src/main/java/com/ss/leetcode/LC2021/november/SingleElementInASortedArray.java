package com.ss.leetcode.LC2021.november;

public class SingleElementInASortedArray {
    // https://leetcode.com/problems/single-element-in-a-sorted-array/
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1 || nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }

        int low = 2;
        int high = nums.length - 3;
        int middle;
        while (true) {
            if (nums[low] != nums[low + 1] && nums[low] != nums[low - 1]) {
                return nums[low];
            }
            if (nums[high] != nums[high - 1] && nums[high] != nums[high + 1]) {
                return nums[high];
            }
            middle = low + (high - low) / 2;
            if (middle % 2 == 0) {
                if (nums[middle] == nums[middle + 1]) {
                    low = middle + 1;
                } else {
                    high = middle - 1;
                }
            } else {
                if (nums[middle] != nums[middle - 1]) {
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
            }
        }
    }
}
