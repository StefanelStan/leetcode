package com.ss.leetcode.LC2023.december;

public class MinimumNumberOfChangesToMakeBinaryStringBeautiful {
    // https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/description
    /** Algorithm
        1. You need to focus on building substrings of length 2 that are balanced (00 or 11)
        2. Traverse string with index i (1..n-1), with steps of 2 (1,3,5..)
            - if current char != prev char (01 or 10), then you need to apply 1 change to make it balanced
        3. Return total number of changes.
     */
    public int minChanges(String s) {
        int minChanges = 0;
        for (int i = 1; i < s.length(); i += 2) {
            minChanges += (s.charAt(i) == s.charAt(i - 1) ? 0 : 1);
        }
        return minChanges;
    }
}
