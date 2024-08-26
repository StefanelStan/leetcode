package com.ss.leetcode.LC2024.august;

public class PermutationDifferenceBetweenTwoStrings {
    // https://leetcode.com/problems/permutation-difference-between-two-strings
    /** Algorithm
        1. Use an int[] positions to mark the position of each char of s and t when traversing them at the same time.
        2. If 'a' is located at index 2 in s and index 7 in t, then:
            - at index 2 and position[a] will become abs(2-0) = 2
            - at index 7, the position[a] will become/be updated abs(7-2) = 5;
        3. Return the sum of position diffs.
     */
    public int findPermutationDifference(String s, String t) {
        int[] positions = new int[26];
        int ch1, ch2;
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            ch1 = s.charAt(i) - 'a';
            ch2 = t.charAt(i) - 'a';
            positions[ch1] = Math.abs(positions[ch1] - i);
            positions[ch2] = Math.abs(positions[ch2] - i);
        }
        for (int d : positions) {
            diff += d;
        }
        return diff;
    }
}
