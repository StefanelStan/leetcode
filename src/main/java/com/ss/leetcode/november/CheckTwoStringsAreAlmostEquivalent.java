package com.ss.leetcode.november;

public class CheckTwoStringsAreAlmostEquivalent {
    // https://leetcode.com/contest/biweekly-contest-65/problems/check-whether-two-strings-are-almost-equivalent/
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] word1Letters = countLettersOf(word1);
        int[] word2Letters = countLettersOf(word2);

        for (int i = 0; i < word1Letters.length; i++) {
            if (Math.abs(word1Letters[i] - word2Letters[i]) > 3) {
                return false;
            }
        }
        return true;
    }

    private int[] countLettersOf(String word1) {
        int[] count = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            count[word1.charAt(i) - 'a']++;
        }
        return count;
    }
}
