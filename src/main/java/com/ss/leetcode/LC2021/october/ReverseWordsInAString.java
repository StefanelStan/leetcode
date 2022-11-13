package com.ss.leetcode.LC2021.october;

public class ReverseWordsInAString {
    // https://leetcode.com/problems/reverse-words-in-a-string/
    public String reverseWords(String s) {
        StringBuilder stb = new StringBuilder();
        char[] chrs = s.toCharArray();
        int start = -1, end = -1;
        for (int i = chrs.length - 1; i >= 0; i--) {
            if (chrs[i] != ' ') {
                if (end == -1) {
                    end = i;
                    start = i;
                } else {
                    start = i;
                }
            } else if (start != -1) {
                appendWord(stb, chrs, start, end);
                start = -1;
                end = -1;
            }
        }
        if (start != -1) {
            appendWord(stb, chrs, start, end);
        }
        stb.setLength(stb.length() - 1);
        return stb.toString();
    }

    private void appendWord(StringBuilder stb, char[] chrs, int start, int end) {
        while (start <= end) {
            stb.append(chrs[start++]);
        }
        stb.append(' ');
    }

    public String reverseWords2(String s) {
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
