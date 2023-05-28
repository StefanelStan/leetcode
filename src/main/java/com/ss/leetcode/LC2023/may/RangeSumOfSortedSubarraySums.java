package com.ss.leetcode.LC2023.may;

import java.util.Arrays;

public class RangeSumOfSortedSubarraySums {
    // https://leetcode.com/problems/range-sum-of-sorted-subarray-sums
    /** Algorithm
        1. Create an array of sums that will store all sums of (i = 0..n j = i..n)
        2. Sort the array
        3. Calculate and sum from left to right and store it into a long
        4. Return modulo result.
     */
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] sums = fillSums(nums);
        long sum = 0;
        while (left <= right) {
            sum += sums[left-1];
            left++;
        }
        return (int)(sum % 1_000_000_007);
    }

    private int[] fillSums(int[] nums) {
        int[] sums = new int[nums.length * (nums.length + 1) / 2];
        int index = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                sums[index++] = sum;
            }
        }
        Arrays.sort(sums);
        return sums;
    }
}
