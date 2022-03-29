package com.ss.leetcode.LC2022.march;

public class FindTheDuplicateNumber {
    // https://leetcode.com/problems/find-the-duplicate-number/submissions/
    public int findDuplicate(int[] nums) {
        boolean[] seen = new boolean[nums.length + 1];
        for (int num : nums) {
            if(seen[num]) {
                return num;
            }
            seen[num] = true;
        }
        return -1;
    }
}
