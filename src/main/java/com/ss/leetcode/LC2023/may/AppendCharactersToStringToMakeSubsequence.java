package com.ss.leetcode.LC2023.may;

public class AppendCharactersToStringToMakeSubsequence {
    // https://leetcode.com/problems/append-characters-to-string-to-make-subsequence
    /** Algorithm
        1. In order for t to be a subsequence of s, all character of t need to be found in s in the given order.
        2. Traverse s and t with i and j and advance j only if s[i] == t[j].
        3. At the end, check how far j has reached. If it reached the end of t, it means all
            the chars have been found in the order they are in t,
            - Else, t.length() - j chars still need to be appended.
     */
    public int appendCharacters(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
            i++;
        }
        return t.length() - j;
    }
}
