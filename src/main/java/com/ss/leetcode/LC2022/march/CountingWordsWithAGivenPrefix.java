package com.ss.leetcode.LC2022.march;

public class CountingWordsWithAGivenPrefix {
    // https://leetcode.com/problems/counting-words-with-a-given-prefix/
    public int prefixCount(String[] words, String pref) {
        int prefixWords = 0;
        for (String word : words) {
            if(word.startsWith(pref)) {
                prefixWords++;
            }
        }
        return prefixWords;
    }
}

