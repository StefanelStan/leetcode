package com.ss.leetcode.LC2021.july;

public class KthMissingPositiveNumber {
    // https://leetcode.com/problems/kth-missing-positive-number/
    public int findKthPositive(int[] arr, int k) {
        int missingInTotal = 0;
        missingInTotal += arr[0] - 1;
        int currentDifference;
        if (arr[0] > k) {
            return k;
        }
        for (int i = 1; i < arr.length; i++) {
            currentDifference = arr[i] - arr[i - 1];
            if (currentDifference > 1) {
                if (missingInTotal + currentDifference - 1 < k) {
                    missingInTotal += currentDifference - 1;
                } else {
                    return arr[i - 1] + k - missingInTotal;
                }
            }
        }
        return arr[arr.length - 1] + (k - missingInTotal);
    }
}
