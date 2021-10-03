package com.ss.leetcode.september;

import java.util.Arrays;

public class MajorityElement {
    // https://leetcode.com/problems/majority-element/
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}