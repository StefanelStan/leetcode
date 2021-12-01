package com.ss.leetcode.LC2021.september;

public class SingleNumber {
    // https://leetcode.com/problems/single-number/
    public int singleNumber(int[] nums) {
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num ^= nums[i];
        }
        return num;
    }
}
