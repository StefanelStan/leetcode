package com.ss.leetcode.august;

public class LongestUncommonSubsequenceI {
    /**
     * Theory: If two strings have different lengths, then the longest one cannot be a subsequence of the shorter one.
     *         Eg: zzz and zz. zz is a subsequence of zzz but zzz cannot be a subsequence of zz.
     * If the strings have same length, then we verify if the two strings are identical.
     */
    public int findLUSlength(String a, String b) {
        if (a.length() != b.length()) {
            return Math.max(a.length(), b.length());
        } else return (a.equals(b) ? -1 : a.length());
    }
}
