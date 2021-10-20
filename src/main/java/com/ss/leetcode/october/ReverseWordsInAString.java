package com.ss.leetcode.october;

public class ReverseWordsInAString {
    // https://leetcode.com/problems/reverse-words-in-a-string/
    public String reverseWords(String s) {
        StringBuilder stb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; ) {
            if (s.charAt(i) != ' ') {
                i = appendLetters(s, stb, i) - 1;
            } else {
                i--;
            }
        }
        return stb.substring(0, stb.length() - 1);
    }

    private int appendLetters(String str, StringBuilder stb, int i) {
        StringBuilder tmp = new StringBuilder();
        while (i >= 0) {
            if (str.charAt(i) == ' ') {
                break;
            }
            tmp.append(str.charAt(i));
            i--;
        }
        stb.append(tmp.reverse());
        stb.append(' ');
        return i;
    }
}
