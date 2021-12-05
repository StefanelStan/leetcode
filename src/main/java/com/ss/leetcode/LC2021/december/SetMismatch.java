package com.ss.leetcode.LC2021.december;

public class SetMismatch {
    // https://leetcode.com/problems/set-mismatch/
    public int[] findErrorNums(int[] nums) {
        boolean[] present = new boolean[nums.length +1];
        int duplicate = 0;
        int sum = 0;
        for (int num : nums) {
            if (present[num]) {
                duplicate = num;
            }
            present[num] = true;
            sum += num;
        }
        int expectedSum = (1 + nums.length) * (nums.length /2);
        if (nums.length % 2 != 0) {
            expectedSum += ((1 + nums.length) / 2);
        }
        return new int[]{duplicate, expectedSum - (sum - duplicate)};
    }
}
