package com.ss.leetcode.LC2024.june;

import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique {
    // https://leetcode.com/problems/minimum-increment-to-make-array-unique
    /** Algorithm
        1. Sort the numbers
        2. Traverse numbers starting from second.
            - If prev >= current, then prev needs to be bumped by 1 + prev - current. Prev becomes prev + 1. Incremented
            - Else prev = current.
        3. This way, each time two numbers match, the current one will be bumped to the next highest number.
     */
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int minIncrement = 0, prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prev >= nums[i]) {
                minIncrement += (prev - nums[i]) + 1;
                prev = prev + 1;
            } else {
                prev = nums[i];
            }
        }
        return minIncrement;
    }
}
