package com.ss.leetcode.LC2021.december;

public class MaximumNumberOfWordsFoundInSentences {
    // https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/
    public int mostWordsFound(String[] sentences) {
        int maxWords = 0;
        int currentWords = 0;
        for (String sentence : sentences) {
            currentWords = 0;
            for (int i = 0; i < sentence.length(); i++) {
                if (sentence.charAt(i) == ' ') {
                    currentWords++;
                }
            }
            maxWords = Math.max(currentWords, maxWords);
        }

        return maxWords + 1;
    }
}
