package com.ss.leetcode.LC2022.may;

public class NumberOfWaysToSplitArray {
    // https://leetcode.com/contest/biweekly-contest-78/problems/number-of-ways-to-split-array/
    /** Algorithm
        1. Get the array sum
        2. Traverse again and for each position, add to a prefix sum.
        3. If prefixsum > sum - prefixsum, add 1 to answer.
     */
    public int waysToSplitArray(int[] nums) {
        long sum = 0, cumulativeSum = 0;
        int numberOfSplits = 0;
        for(int num : nums) {
            sum += num;
        }
        for(int i = 0; i < nums.length -1; i++) {
            cumulativeSum += nums[i];
            if (cumulativeSum >= (sum - cumulativeSum)) {
                numberOfSplits++;
            }
        }
        return numberOfSplits;
    }
}
