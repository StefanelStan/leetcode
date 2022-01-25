package com.ss.leetcode.LC2021.december;

public class ValidMountainArray {
    // https://leetcode.com/problems/valid-mountain-array/
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int index = 0;
        while (index < arr.length - 1 && arr[index] < arr[index + 1]) {
            index++;
        }
        if (index == 0 || index == arr.length - 1) {
            return false;
        }
        while(index < arr.length - 1 && arr[index] > arr[index + 1]) {
            index++;
        }
        return index == arr.length - 1;
    }

    public boolean validMountainArray2(int[] arr) {
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
