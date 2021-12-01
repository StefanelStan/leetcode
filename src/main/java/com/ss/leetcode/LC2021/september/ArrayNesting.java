package com.ss.leetcode.LC2021.september;

public class ArrayNesting {
    // https://leetcode.com/problems/array-nesting/
    public int arrayNesting(int[] nums) {
        int maxLength = 0;
        int[] setLengths = new int[nums.length];
        boolean[] touched = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (setLengths[i] == 0) {
                maxLength = Math.max(buildSetFromIndex(nums, i, setLengths, touched), maxLength);
            }
        }
        return maxLength;
    }

    private int buildSetFromIndex(int[] nums, int index, int[] setLengths, boolean[] touched) {
        if (setLengths[index] != 0) {
            return setLengths[index];
        }

        if (touched[index]) {
            return 0;
        } else {
            touched[index] = true;
        }
        if (nums[index] == index) {
            return 1;
        }
        int sum = 1;

        sum += buildSetFromIndex(nums, nums[index], setLengths, touched);
        setLengths[index] = sum;
        return sum;
    }
}
