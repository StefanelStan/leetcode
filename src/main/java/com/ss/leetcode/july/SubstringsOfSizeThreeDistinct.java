package com.ss.leetcode.july;

public class SubstringsOfSizeThreeDistinct {
    // https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/
    public int countGoodSubstrings(String s) {
        int goodSubstrings = 0;
        if (s.length() < 3) {
            return 0;
        }
        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) != s.charAt(i + 1) && s.charAt(i) != s.charAt(i + 2)  && s.charAt(i + 1) != s.charAt(i + 2)) {
                goodSubstrings++;
            }
        }
        return goodSubstrings;
    }
}
