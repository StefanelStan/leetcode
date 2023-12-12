package com.ss.leetcode.LC2021.july;

import java.util.Arrays;

public class MaximumProductOfTwoElements {
    // https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/submissions/
    public int maxProduct(int[] nums) {
        int[] highest = {-2, -1};
        for (int num : nums) {
            setHighest(highest, num);
        }
        return (highest[0] - 1) * (highest[1] - 1);
    }

    private void setHighest(int[] highest, int num) {
        if (highest[1] <= num) {
            highest[0] = highest[1];
            highest[1] = num;
        } else if (num > highest[0]) {
            highest[0] = num;
        }
    }

    public int maxProduct2(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] -1);
    }
}
