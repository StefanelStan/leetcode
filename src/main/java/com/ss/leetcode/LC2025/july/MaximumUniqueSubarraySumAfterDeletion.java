package com.ss.leetcode.LC2025.july;

public class MaximumUniqueSubarraySumAfterDeletion {
    // https://leetcode.com/problems/maximum-unique-subarray-sum-after-deletion
    /** Algorithm
        1. Use a boolean[201] present to traverse nums and mark the presence of each number
        2. Iterate from 200 to 0 and if current position is present
            - if adding current index - 100 to sum would increse the maxSum, add it and set the new maxsum
            - else break, as you have reached negative numbers, and adding them would keep decreasing the sum;
     */
    public int maxSum(int[] nums) {
        boolean[] present = new boolean[201];
        for (int num : nums) {
            present[num + 100] = true;
        }
        int maxSum = Integer.MIN_VALUE, currentSum = 0;
        for (int i = 200; i >= 0; i--) {
            if (present[i]) {
                if (currentSum + (i - 100) > maxSum) {
                    currentSum += i - 100;
                    maxSum = currentSum;
                } else {
                    break;
                }
            }
        }
        return maxSum;
    }
}
