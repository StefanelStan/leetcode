package com.ss.leetcode.LC2024.february;

import java.util.Arrays;

public class DivideArrayIntoArraysWithMaxDifference {
    // https://leetcode.com/problems/divide-array-into-arrays-with-max-difference
    /** Algorithm
        1. Sort the numbers
        2. Use an int[n/3][] division to store the result.
        3. Loop with an window [i-1, i+1] with i from 1 to n-2 in steps of 3
            - if nums[i+1] - nums[i-1] <= k, add the 3 elements to division[i/3]
            - else return new int[0][0]
        4. Return division
     */
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] division = new int[nums.length/3][];
        for (int i = 1; i < nums.length - 1; i += 3) {
            if (nums[i+1] - nums[i-1] <= k) {
                division[i/3] = new int[]{nums[i-1], nums[i], nums[i+1]};
            } else {
                return new int[0][0];
            }
        }
        return division;
    }
}
