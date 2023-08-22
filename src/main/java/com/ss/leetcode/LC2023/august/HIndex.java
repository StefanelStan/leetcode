package com.ss.leetcode.LC2023.august;

import java.util.Arrays;

public class HIndex {
    // https://leetcode.com/problems/h-index
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int low = 0, high = citations.length - 1;
        int coveredPapers, pivot;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            coveredPapers = citations.length - pivot;
            if (citations[pivot] >= coveredPapers) {
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
        }
        return citations.length - low;
    }
}
