package com.ss.leetcode.april;

public class ShuffleTheArray {
    // https://leetcode.com/problems/shuffle-the-array/
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        int resultIndex = 0;
        for (int i = 0; i < n; i++, resultIndex += 2) {
            result[resultIndex] = nums[i];
            result[resultIndex+1] = nums[i+n];
        }
        return result;
    }
}
