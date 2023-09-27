package com.ss.leetcode.LC2023.september;

public class MaximumNumberOfRemovableCharacters {
    // https://leetcode.com/problems/maximum-number-of-removable-characters
    /** Algorithm
        1. Use 2 pointers (i, j) over s and t to determine if p is a subsequence of s.
            If s.charAt(i) == p.charAt(j), advance j. Always advance i.
            If j == p.length(), it means j has reached the end and it's a subsequence
        2. Based on this principle, we need to know how many chars, removable items of s we can hide (make 0)
            - we can try in sequence (eliminare first of removable, then 2nd and so on)
            - or we can try binary search: if we can eliminate k, then try higher, else lower
        3. Apply binary search to the range 1 - removable.length to see how many removable items you can remove from s.
     */
    public int maximumRemovals(String s, String p, int[] removable) {
        int low = 1, high = removable.length, pivot;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            if (isASubsequenceAfterRemoving(s.toCharArray(), p.toCharArray(), removable, pivot)) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }
        return low - 1;
    }

    private boolean isASubsequenceAfterRemoving(char[] s, char[] p, int[] removable, int limit) {
        for (int i = 0; i < limit; i++) {
            s[removable[i]] = 0;
        }
        int i = 0, j = 0;
        while (i < s.length && j < p.length) {
            if (s[i] == p[j]) {
                j++;
            }
            i++;
        }
        return j == p.length;
    }
}
