package com.ss.leetcode.LC2021.april;

public class SortArrayByParityII {
    // https://leetcode.com/problems/sort-array-by-parity-ii/
    public int[] sortArrayByParityII(int[] nums) {
        int[] sorted = new int[nums.length];
        int evenIndex = 0;
        int oddIndex = 1;
        for (int nr : nums) {
            if (nr %2 == 0) {
                sorted[evenIndex] = nr;
                evenIndex += 2;
            } else {
                sorted[oddIndex] = nr;
                oddIndex += 2;
            }
        }
        return sorted;
    }
}
