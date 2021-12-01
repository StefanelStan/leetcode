package com.ss.leetcode.LC2021.october;

public class CheckNumbersAreAscendingSentence {
    // https://leetcode.com/problems/check-if-numbers-are-ascending-in-a-sentence/
    public boolean areNumbersAscending(String s) {
        int previousNumber = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    temp = temp * 10 + (s.charAt(i) - '0');
                    i++;
                }
                if (temp <= previousNumber) {
                    return false;
                } else {
                    previousNumber = temp;
                    temp = 0;
                }
            }
        }
        return true;
    }
}
