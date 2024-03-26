package com.ss.leetcode.LC2024.march;

public class FindIndicesWithIndexAndValueDifferenceI {
    // https://leetcode.com/problems/find-indices-with-index-and-value-difference-i
    /** Algorithm
        1. Loop with i from 0 until n- indexDiff
        2. Inside, loop with j from indexDiff + i to n-1
        3. If Math.abs(nums[i] - nums[j]) satisfies the conditions, return the two indices
        4. Return [-1,-1] by default;
     */
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        for (int i = 0; i < nums.length - indexDifference; i++) {
            for (int j = indexDifference + i; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) >= valueDifference) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
