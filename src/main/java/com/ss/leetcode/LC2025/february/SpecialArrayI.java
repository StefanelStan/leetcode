package com.ss.leetcode.LC2025.february;

public class SpecialArrayI {
    // https://leetcode.com/problems/special-array-i
    /** Algorithm
        1. Traverse nums and check if n[i] % 2 == n[i+1] % 2.
        2. Return false if any are equal, true otherwise.
     */
    public boolean isArraySpecial(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] % 2 == nums[i+1] % 2) {
                return false;
            }
        }
        return true;
    }
}
