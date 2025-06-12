package com.ss.leetcode.LC2025.june;

public class MaximumDifferenceBetweenAdjacentElementsInACircularArray {
    // https://leetcode.com/problems/maximum-difference-between-adjacent-elements-in-a-circular-array
    /** Algorithm
        1. Use a variable maxDistance to keep max distance between each pair i,j [0, n-1]
        2. Return the max between maxDistance and [0] - [n-1]
     */
    public int maxAdjacentDistance(int[] nums) {
        int maxDistance = 0;
        for (int i = 0; i < nums.length -1; i++) {
            maxDistance = Math.max(maxDistance, Math.abs(nums[i] - nums[i+1]));
        }
        return Math.max(maxDistance, Math.abs(nums[0] - nums[nums.length -1]));
    }
}
