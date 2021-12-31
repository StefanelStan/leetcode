package com.ss.leetcode.LC2021.december;

public class ValidMountainArray {
    // https://leetcode.com/problems/valid-mountain-array/
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int increasingIndex = 0;
        for (; increasingIndex < arr.length - 1 && arr[increasingIndex] < arr[increasingIndex + 1]; increasingIndex++) {
            if (arr[increasingIndex] == arr[increasingIndex + 1]) {
                return false;
            }
        }
        if (increasingIndex == arr.length - 1 || increasingIndex == 0) {
            return false;
        }
        for (; increasingIndex < arr.length - 1; increasingIndex++) {
            if (arr[increasingIndex] <= arr[increasingIndex + 1]) {
                return false;
            }
        }
        return true;
    }
}
