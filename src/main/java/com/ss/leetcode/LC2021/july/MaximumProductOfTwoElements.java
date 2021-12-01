package com.ss.leetcode.LC2021.july;

import java.util.Arrays;

public class MaximumProductOfTwoElements {
    // https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/submissions/
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] -1);
    }
}
