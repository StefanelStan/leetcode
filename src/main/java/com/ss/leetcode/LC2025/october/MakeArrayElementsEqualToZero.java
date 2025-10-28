package com.ss.leetcode.LC2025.october;

import java.util.Arrays;

public class MakeArrayElementsEqualToZero {
    // https://leetcode.com/problems/make-array-elements-equal-to-zero
    public int countValidSelections(int[] nums) {
        int ways = 0, nonZeroes = 0;
        for (int num : nums) {
            nonZeroes += (num != 0 ? 1 : 0);
        }
        if (nonZeroes == nums.length) {
            return 2 * nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                ways += canMove(Arrays.copyOf(nums, nums.length), i, nonZeroes, true)
                        + canMove(Arrays.copyOf(nums, nums.length), i, nonZeroes, false);
            }
        }
        return ways;
    }

    private int canMove(int[] nums, int from, int targetZeroes, boolean leftDirection) {
        while (from >= 0 && from < nums.length) {
            if (nums[from] > 0) {
                nums[from]--;
                leftDirection = !leftDirection;
                if (nums[from] == 0) {
                    targetZeroes--;
                }
            }
            from += (leftDirection ? -1 : 1);
        }
        return targetZeroes == 0 ? 1 : 0;
    }
}
