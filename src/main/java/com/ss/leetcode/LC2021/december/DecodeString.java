package com.ss.leetcode.LC2021.december;

public class DecodeString {
    // https://leetcode.com/problems/decode-string/
    public String decodeString(String s) {
        StringBuilder decoded = new StringBuilder();
        int openLevel = 0;
        char ch;
        for (int i = 0; i < s.length(); ) {
            ch = s.charAt(i);
            if (isLetter(ch)) {
                decoded.append(ch);
                i++;
            } else if (isDigit(ch)) {
                openLevel++;
                int values[] = getIntValueOf(s, i);
                int[] endingPoint = {values[1] + 1};
                decoded.append(getBetweenParentheses(s, endingPoint).repeat(values[0]));
                i = endingPoint[0] + 1;
            } else if (s.charAt(i) == ']') {
                openLevel--;
                i++;
            }  else if (s.charAt(i) == '[') {
                openLevel++;
                i++;
            }
        }

        return decoded.toString();
    }

    private String getBetweenParentheses(String s, int[] pointer) {
        StringBuilder decoded = new StringBuilder();
        int openLevel = 0;
        char ch;
        for (int i = pointer[0]; i < s.length(); ) {
            ch = s.charAt(i);
            if (isLetter(ch)) {
                decoded.append(ch);
                i++;
            } else if (isDigit(ch)) {
                openLevel++;
                int values[] = getIntValueOf(s, i);
                int[] endingPoint = {values[1] + 1};
                decoded.append(getBetweenParentheses(s, endingPoint).repeat(values[0]));
                i = endingPoint[0] + 1;
            } else if (s.charAt(i) == ']') {
                openLevel--;
                if (openLevel == 0) {
                    pointer[0] = i;
                    break;
                }
            } else if (s.charAt(i) == '[') {
                openLevel++;
                i++;
            }
        }

        return decoded.toString();
    }

    private boolean isLetter(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private int[] getIntValueOf(String s, int startPos) {
        // value[0] holds the int value of the string
        // value[1] holds the index where the last digit of number ends. Needed as numbers are > 9;
        int[] values = new int[2];
        for (int i = startPos; i <= s.length(); i++) {
            if (isDigit(s.charAt(i))) {
                values[0] = values[0] * 10 + s.charAt(i) - '0';
            } else {
                values[1] = i - 1;
                break;
            }
        }
        return values;
    }
}
