package com.ss.leetcode.LC2022.april;

public class CountPrefixesOfAGivenString {
    // https://leetcode.com/problems/count-prefixes-of-a-given-string/
    public int countPrefixes(String[] words, String s) {
        int count = 0;
        for (String word : words) {
            if (s.startsWith(word)) {
                count++;
            }
        }
        return count;
    }
}
