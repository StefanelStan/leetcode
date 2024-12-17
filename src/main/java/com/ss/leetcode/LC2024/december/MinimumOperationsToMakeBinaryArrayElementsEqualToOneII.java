package com.ss.leetcode.LC2024.december;

public class MinimumOperationsToMakeBinaryArrayElementsEqualToOneII {
    // https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-ii
    /** Algorithm
        1. Starting from the back, each alternation from [i+1] to i will cause a step, as the nums [i+1..] will need to be matched/made equal to [i]
        2. If first number is 0, then you need one extra swap as whole array will be matched to 0.
            - [1,0,0] -> just 1 alternation => 1 alternation + 0 (as nums[0] == 1)
            - [0,0,1] -> just 1 alternation => 1 alternation + 1 extra step (as nums[0] == 0)
     */
    public int minOperations(int[] nums) {
        int operations = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            operations += nums[i] == nums[i + 1] ? 0 : 1;
        }
        return operations + 1 - nums[0];
    }
}
