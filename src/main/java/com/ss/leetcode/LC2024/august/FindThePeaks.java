package com.ss.leetcode.LC2024.august;

import java.util.ArrayList;
import java.util.List;

public class FindThePeaks {
    // https://leetcode.com/problems/find-the-peaks
    /** Algorithm
        1. Traverse nums with index i from [1, n-2].
        2. If current num > left and > right, then add current index to list of peaks
        3. Return peaks.
     */
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i] > mountain[i-1] && mountain[i] > mountain[i+1]) {
                peaks.add(i);
            }
        }
        return peaks;
    }
}
