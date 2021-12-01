package com.ss.leetcode.LC2021.august;

import java.util.Arrays;

public class ArrayPartitionI {
    // https://leetcode.com/problems/array-partition-i/
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int minSum = 0;
        for (int i = 0; i < nums.length -1; i+=2) {
            minSum += Math.min(nums[i], nums[i + 1]);
        }
        return minSum;
    }
}
