package com.ss.leetcode.LC2024.january;

public class DetectPatternOfLengthMRepeatedKOrMoreTimes {
    // https://leetcode.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times
    /** Algorithm
        1. Sliding window: with i = 0..length - m, chose a window [i..m-1]
        2. For each such window, check if you have (k-1) equal such windows in interval [m, 2*m-1], [2m.3m-1]
     */
    public boolean containsPattern(int[] arr, int m, int k) {
        if (m * k > arr.length) {
            return false;
        }
        boolean found = false;
        for (int i = 0; !found && i + m * k <= arr.length; i++) {
            found = findInPattern(i, m, k, arr);
        }
        return found;
    }

    private boolean findInPattern(int start, int size, int repeated, int[] arr) {
        int times = 1;
        for (int i = start + size; i + size <= arr.length && times < repeated; i += size) {
            for (int k = 0; k < size; k++) {
                if (arr[i + k] != arr[start + k]) {
                    return false;
                }
            }
            times++;
        }
        return times >= repeated;
    }
}
