package com.ss.leetcode.november;

public class ReverseVowelsOfAString {
    // https://leetcode.com/problems/reverse-vowels-of-a-string/
    private boolean[] vowels;

    public String reverseVowels(String s) {
        if (s.length() == 1) {
            return s;
        }
        setLetters();
        char[] chrs = s.toCharArray();
        int start = 0, end = chrs.length -1;
        while (start < end) {
            while (start < end && !vowels[chrs[start]]) {
                start++;
            }
            while (start < end && !vowels[chrs[end]]) {
                end--;
            }
            swapLetters(chrs, start, end);
            start++;
            end--;
        }
        return new String(chrs);
    }

    private void swapLetters(char[] chrs, int start, int end) {
        char tmp = chrs[start];
        chrs[start] = chrs[end];
        chrs[end] = tmp;
    }

    private void setLetters() {
        if (vowels == null) {
            vowels = new boolean[256];
            vowels['a'] = true;
            vowels['e'] = true;
            vowels['i'] = true;
            vowels['o'] = true;
            vowels['u'] = true;
            vowels['A'] = true;
            vowels['E'] = true;
            vowels['I'] = true;
            vowels['O'] = true;
            vowels['U'] = true;
        }
    }
}
