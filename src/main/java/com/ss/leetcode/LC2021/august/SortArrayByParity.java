package com.ss.leetcode.LC2021.august;

public class SortArrayByParity {
    // https://leetcode.com/problems/sort-array-by-parity/
    public int[] sortArrayByParity(int[] nums) {
        int[] sorted = new int[nums.length];
        int leftIndex = 0, rightIndex = nums.length -1;
        for (int num : nums) {
            if (num % 2 == 0) {
                sorted[leftIndex] = num;
                leftIndex++;
            } else {
                sorted[rightIndex] = num;
                rightIndex--;
            }
        }
        return sorted;
    }
}
