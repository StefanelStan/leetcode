package com.ss.leetcode.august;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        boolean insideWord = false;
        int endOfWordPosition = 0;
        for (int i = s.length() -1; i >= 0; i-- ) {
            if (s.charAt(i) != ' ' && !insideWord) {
                insideWord = true;
                endOfWordPosition = i;
            } else if (s.charAt(i) == ' ' & insideWord) {
                return endOfWordPosition - i;
            }
        }
        // edge case: "word   " and there is no terminal space
        return endOfWordPosition + 1;
    }
}
