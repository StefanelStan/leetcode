package com.ss.leetcode.LC2025.april;

public class MinimumNumberOfOperationsToMakeElementsInArrayDistinct {
    // https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct
    public int minimumOperations(int[] nums) {
        int steps = 0;
        int[] count = new int[101];
        int duplicates = 0;
        for (int num : nums) {
            if (++count[num] == 2) {
                duplicates++;
            }
        }
        for (int i = 0; i < nums.length && duplicates > 0; i += 3) {
            for (int j = 0; j <= 2 && j + i < nums.length; j++) {
                if (--count[nums[i + j]] > 0) {
                    duplicates -= (count[nums[i + j]] == 1 ? 1 : 0);
                }
            }
            steps += 1;
        }
        return steps;
    }
}
