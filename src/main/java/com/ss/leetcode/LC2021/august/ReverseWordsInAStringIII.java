package com.ss.leetcode.LC2021.august;

public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        StringBuilder stb = new StringBuilder(s.length());
        int spaceIndex = 0;
        for (int i = 0; i < s.length(); ) {
            if (s.charAt(i) != ' ') {
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == ' ') {
                        spaceIndex = j;
                        break;
                    }
                }
                if (spaceIndex <= i) {
                    spaceIndex = s.length();
                }
                appendInReverseOrder(i, spaceIndex == s.length() ? s.length() - 1 : spaceIndex - 1, s, stb);
                if (spaceIndex != s.length()) {
                    stb.append(' ');
                }
                i = spaceIndex + 1;
            }
        }
        return stb.substring(0, stb.length());

    }

    private void appendInReverseOrder(int frontIndex, int backIndex, String s, StringBuilder stb) {
        for (int i = backIndex; i >= frontIndex; i--) {
            stb.append(s.charAt(i));
        }
    }
}
