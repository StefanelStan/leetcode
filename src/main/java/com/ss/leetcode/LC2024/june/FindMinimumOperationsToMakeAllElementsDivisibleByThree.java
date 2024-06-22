package com.ss.leetcode.LC2024.june;

public class FindMinimumOperationsToMakeAllElementsDivisibleByThree {
    // https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three
    /** Algorithm
        1. A number mod 3 can have 3 results: 0, 1 or 2.
        2. If modulo is zero, you need 0 steps.
        3. If the modulo is 1 or 2, then you can subtract 1 or add 1 (1 - 1 = 0 or 2 + 1 == 3 % 3 = 0)to make it divisible by 3
        4. Add the total steps for each numbers
     */
    public int minimumOperations(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += (num % 3 == 0 ? 0 : 1);
        }
        return total;
    }
}
