package com.ss.leetcode.november;

public class MissingNumber {
    // https://leetcode.com/problems/missing-number/
    public int missingNumber(int[] nums) {
        int zeroPos = -1;
        int index = 0;
        while(index < nums.length) {
            if (nums[index] == index +1) {
                index++;
            } else {
                if (nums[index] != 0) {
                    swap(nums, index, nums[index] -1);
                } else {
                    zeroPos = index;
                    index++;
                }
            }
        }
        return zeroPos +1;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
