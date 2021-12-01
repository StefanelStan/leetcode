package com.ss.leetcode.LC2021.june;

public class CheckIfWordSumTwoWords {
    // https://leetcode.com/problems/check-if-word-equals-summation-of-two-words/

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return sumOf(firstWord) + sumOf(secondWord) == sumOf(targetWord);
    }

    private int sumOf(String word) {
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            sum += Math.pow(10, word.length() -1 -i) * (word.charAt(i) - 'a');
        }
        return sum;
    }
}
