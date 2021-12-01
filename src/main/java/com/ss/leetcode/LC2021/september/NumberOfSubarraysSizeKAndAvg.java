package com.ss.leetcode.LC2021.september;

public class NumberOfSubarraysSizeKAndAvg {
    // https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int tempSum = 0;
        int subarrays = 0;
        for (int i = 0; i < k; i++) {
            tempSum += arr[i];
        }
        if (tempSum / k >= threshold ) {
            subarrays++;
        }
        for (int i = 1, j = k; j < arr.length; i++, j++) {
            tempSum -= arr[i -1];
            tempSum += arr[j];
            if (tempSum / k >= threshold) {
                subarrays++;
            }
        }
        return subarrays;
    }
}
