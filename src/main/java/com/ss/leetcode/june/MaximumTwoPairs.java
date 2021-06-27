package com.ss.leetcode.june;

import java.util.Arrays;

public class MaximumTwoPairs {
    // https://leetcode.com/problems/maximum-product-difference-between-two-pairs/
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length -1] * nums[nums.length -2] - nums[0] * nums[1]);
    }
}
