package com.ss.leetcode.LC2021.august;

public class MaximumNumberWordsYouCanType {
    // https://leetcode.com/problems/maximum-number-of-words-you-can-type/
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] brokenMapping = getBrokenMapping(brokenLetters);
        String[] words = text.split(" ");
        int brokenWords = 0;
        for(String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if(brokenMapping[word.charAt(i)]) {
                    brokenWords++;
                    break;
                }
            }
        }
        return words.length - brokenWords;
    }

    private boolean[] getBrokenMapping(String letters) {
        boolean[] b = new boolean['z' + 1];
        for (int i = 0; i < letters.length(); i++) {
            b[letters.charAt(i)] = true;
        }
        return b;
    }
}
