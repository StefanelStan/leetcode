package com.ss.leetcode.june;

public class ReplaceAllDigitsWithCharacters {
    // https://leetcode.com/problems/replace-all-digits-with-characters/
    public String replaceDigits(String s) {
        char[] formatted = s.toCharArray();
        for(int i = 1; i < formatted.length; i+=2) {
            formatted[i] = (char) (formatted[i-1] + Character.digit(formatted[i], 10));
        }
        return new String(formatted);
    }
}
