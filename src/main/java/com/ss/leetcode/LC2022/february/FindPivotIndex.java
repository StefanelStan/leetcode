package com.ss.leetcode.LC2022.february;

public class FindPivotIndex {
    // https://leetcode.com/problems/find-pivot-index/
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (left == totalSum - (left + nums[i])) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }
}
