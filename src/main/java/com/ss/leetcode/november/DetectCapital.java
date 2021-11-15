package com.ss.leetcode.november;

public class DetectCapital {
    // https://leetcode.com/problems/detect-capital/
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) {
            return true;
        }

        if (Character.isUpperCase(word.charAt(0))) {
            if (Character.isUpperCase(word.charAt(1))) {
                return checkAllBetween(word, 1, 'A', 'Z');
            } else {
                return checkAllBetween(word, 1, 'a', 'z');
            }
        } else {
            return checkAllBetween(word, 0, 'a', 'z');
        }
    }

    private boolean checkAllBetween(String word, int start, char min, char max) {
        for (; start < word.length(); start++) {
            if (word.charAt(start) < min || word.charAt(start) > max) {
                return false;
            }
        }
        return true;
    }
}
