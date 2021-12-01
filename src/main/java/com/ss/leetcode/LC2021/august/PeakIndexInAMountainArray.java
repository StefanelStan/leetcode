package com.ss.leetcode.LC2021.august;

public class PeakIndexInAMountainArray {
    // https://leetcode.com/problems/peak-index-in-a-mountain-array/
    // Note: array has one single mountain. Retutn the first appearance of a mountain
    public int peakIndexInMountainArray(int[] arr) {
        int maxPosition = 0, maxPeak = 0;
        for (int i = 1; i < arr.length -1; i++) {
            if (arr[i-1] < arr[i] && arr[i] > arr[i+1]) {
                return i;
            }
        }
        return maxPosition;
    }
}
