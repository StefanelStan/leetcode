package com.ss.leetcode.LC2021.august;

public class LengthOfLastWord {
    // https://leetcode.com/problems/length-of-last-word/
    public int lengthOfLastWord(String s) {
        char[] chrs = s.toCharArray();
        int length = 0;
        for(int i = chrs.length -1; i >=0; i--) {
            if (chrs[i] != ' ') {
                length++;
            } else if (length > 0) {
                return length;
            }
        }
        return length;
    }

    public int lengthOfLastWord2(String s) {
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
