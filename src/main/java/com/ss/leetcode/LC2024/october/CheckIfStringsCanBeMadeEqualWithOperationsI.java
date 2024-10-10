package com.ss.leetcode.LC2024.october;

public class CheckIfStringsCanBeMadeEqualWithOperationsI {
    // https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-i
    /** Algorithm
        1. For the two strings to match, they need to have the same letters of pos [0,2] and [1,3].
        2. For i = 0 and i = 1, check if they match on pairs (s1[i]== s2[i] & s1[i+2] == s2[i+2]) OR (s1[i] == s2[i+2] && s1[i+2] == s2[i]);
     */
    public boolean canBeEqual(String s1, String s2) {
        return areMatching(s1,s2, 0) && areMatching(s1, s2, 1);
    }

    public boolean areMatching(String s1, String s2, int i) {
        return ((s1.charAt(i) == s2.charAt(i) && s1.charAt(i+2) == s2.charAt(i+2))
            || (s1.charAt(i) == s2.charAt(i+2) && s1.charAt(i+2) == s2.charAt(i)));
    }
}
