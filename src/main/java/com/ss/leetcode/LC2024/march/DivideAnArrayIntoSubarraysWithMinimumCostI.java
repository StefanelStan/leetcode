package com.ss.leetcode.LC2024.march;

public class DivideAnArrayIntoSubarraysWithMinimumCostI {
    // https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-i
    /** Algorithm
        1. nums[0] will have to be the head of a partition, so it needs to be added by default to answer
        2. Starting from index 1, you need to find the lowest 2 numbers. These will be the heads of the two other partitions
        3. Return nums[0] + sumOfLowestTwoNumbers.
     */
    public int minimumCost(int[] nums) {
        int min = 100, secondMin = 100;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= min) {
                secondMin = min;
                min = nums[i];
            } else if (nums[i] < secondMin) {
                secondMin = nums[i];
            }
        }
        return nums[0] + min + secondMin;
    }
}
