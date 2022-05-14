package com.ss.leetcode.LC2022.may;

public class NumberOfWaysToSplitArray {
    // https://leetcode.com/contest/biweekly-contest-78/problems/number-of-ways-to-split-array/
    public int waysToSplitArray(int[] nums) {
        long sum = 0;
        int numberOfSplits = 0;
        for(int num : nums) {
            sum += num;
        }
        long cumulativeSum = 0;
        for(int i = 0; i < nums.length -1; i++) {
            cumulativeSum += nums[i];
            if (cumulativeSum >= (sum - cumulativeSum)) {
                numberOfSplits++;
            }
        }
        return numberOfSplits;
    }
}
