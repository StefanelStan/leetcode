package com.ss.leetcode.LC2021.december;

public class CheckAll1AreAtLeastKDistance {
    // https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/
    public boolean kLengthApart(int[] nums, int k) {
        int lastPos = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (lastPos != -1 && i - lastPos <= k) {
                    return false;
                }
                lastPos = i;
            }
        }
        return true;
    }
}
