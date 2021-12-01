package com.ss.leetcode.LC2021.august;

public class SumOfUniqueElements {
    // https://leetcode.com/problems/sum-of-unique-elements/
    public int sumOfUnique(int[] nums) {
        int[] counts = new int[101];
        for (int nr : nums) {
            counts[nr]++;
        }

        int sum = 0;
        for (int i= 1; i < counts.length; i++) {
            if (counts[i] == 1) {
                sum += i;
            }
        }
        return sum;
    }
}
