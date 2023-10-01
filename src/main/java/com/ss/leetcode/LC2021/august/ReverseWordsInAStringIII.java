package com.ss.leetcode.LC2021.august;

public class ReverseWordsInAStringIII {
    // https://leetcode.com/problems/reverse-words-in-a-string-iii
    public String reverseWords(String s) {
        char[] ch = s.toCharArray();
        int left = 0;
        for (int i = 0; i < ch.length; i++) {
            if (s.charAt(i) == ' ') {
                reverseChars(ch, left, i-1);
                left = i + 1;
            }
        }
        reverseChars(ch, left, s.length() - 1);
        return new String(ch);
    }

    private void reverseChars(char[] ch, int from, int end) {
        char temp;
        while (from < end) {
            temp = ch[from];
            ch[from++] = ch[end];
            ch[end--] = temp;
        }
    }



    public String reverseWords2(String s) {
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
