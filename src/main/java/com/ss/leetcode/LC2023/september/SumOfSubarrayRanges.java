package com.ss.leetcode.LC2023.september;

public class SumOfSubarrayRanges {
    // https://leetcode.com/problems/sum-of-subarray-ranges
    /** Algorithm
        1. Due to size constraints, (1000 elements) we could try an n * n / 2 time complexity.
        2. Using two nested for i [0,n-2] and j [i+1, n-1], determine the min/max of the expanding segment [i,j]
        3. Calculate their sum and add it to a global variable
        4. Return the sum.
     */
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        int min, max, i, j;
        for (i = 0; i < nums.length - 1; i++) {
            min = nums[i];
            max = nums[i];
            for (j = i + 1; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                sum += (max - min);
            }
        }
        return sum;
    }
}
