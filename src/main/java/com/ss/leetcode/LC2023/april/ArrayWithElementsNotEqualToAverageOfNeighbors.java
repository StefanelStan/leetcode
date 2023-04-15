package com.ss.leetcode.LC2023.april;

import java.util.Arrays;

public class ArrayWithElementsNotEqualToAverageOfNeighbors {
    // https://leetcode.com/problems/array-with-elements-not-equal-to-average-of-neighbors
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 3) {
            swap(nums, 1, 2);
            return nums;
        }
        for (int i = nums.length -2; i >= 1; i--) {
            if (nums[i-1] + nums[i+1] == 2 * nums[i]) {
                swap(nums, 0, i-1);
            }
        }
        if (nums[0] + nums[2] == 2 * nums[1]) {
            swap(nums, 0, nums.length -1);
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
