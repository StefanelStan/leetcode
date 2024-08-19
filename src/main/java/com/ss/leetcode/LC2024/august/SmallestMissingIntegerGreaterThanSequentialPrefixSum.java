package com.ss.leetcode.LC2024.august;

public class SmallestMissingIntegerGreaterThanSequentialPrefixSum {
    // https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum
    /** Algorithm
        1. Map the present numbers in a boolean[51]
        2. Traverse nums and to a prefixSum while current = prev + 1;
        3. Traverse present[] starting with prefixSum and stop when reaching length or present[prefixSum] = false;
     */
    public int missingInteger(int[] nums) {
        boolean[] present = new boolean[51];
        int sum = nums[0];
        for (int num : nums) {
            present[num] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] != 1) {
                break;
            } else {
                sum += nums[i];
            }
        }
        return findMissing(present, sum);
    }

    private int findMissing(boolean[] present, int i) {
        while(i < present.length && present[i]) {
            i++;
        }
        return i;
    }
}
