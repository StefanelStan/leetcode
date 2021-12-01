package com.ss.leetcode.LC2021.october;

public class JumpGame {
    // https://leetcode.com/problems/jump-game/
    public boolean canJump(int[] nums) {
        int carry = 0;
        for (int i = 0; i < nums.length; i++) {
            carry = Math.max(carry - 1, nums[i]);
            if (carry <= 0 && i != nums.length - 1) {
                return false;
            }
        }
        return true;
    }
}
