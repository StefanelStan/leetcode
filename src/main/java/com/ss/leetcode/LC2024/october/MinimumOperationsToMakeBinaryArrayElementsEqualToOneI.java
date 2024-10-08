package com.ss.leetcode.LC2024.october;

public class MinimumOperationsToMakeBinaryArrayElementsEqualToOneI {
    // https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i
    /** Algorithm
        1. Traverse with i from 0 to [n-3]
        2. If nums[i] == 0, then make nums[i] 1 and flip nums[i+1, i+2]. Increment operations
        3. At the end, if nums[n-1] == 0 OR nums[n-2] == 0, return -1, else number of operations.
     */
    public int minOperations(int[] nums) {
        int operations = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) {
                nums[i] = 1;
                nums[i+1] = 1 - nums[i+1];
                nums[i+2] = 1 - nums[i+2];
                operations++;
            }
        }
        return nums[nums.length -1] == 1 && nums[nums.length -2] == 1 ? operations : -1;
    }
}
