package com.ss.leetcode.LC2023.july;

public class HIndexII {
    // https://leetcode.com/problems/h-index-ii
    /** Algorithm
        1. Apply binary search: to check if given number of papers have enough citations
        2. If current citation[pivot] >= papers, then decrease high,as there might be more good papers to check
        3. Else increase low, as current selected papers do not have enough citations
        4. Return citations.length - low;
     */
    public int hIndex(int[] citations) {
        int low = 0, high = citations.length -1, pivot, papers;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            papers = citations.length - pivot;
            if (citations[pivot] >= papers) {
                high = pivot -1;
            } else {
                low = pivot + 1;
            }
        }
        return citations.length - low;
    }
}
