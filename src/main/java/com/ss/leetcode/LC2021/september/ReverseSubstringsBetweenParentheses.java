package com.ss.leetcode.LC2021.september;

import java.util.Stack;

public class ReverseSubstringsBetweenParentheses {
    // https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
    public String reverseParentheses(String s) {
        char[] sChars = s.toCharArray();
        reverseString(sChars);
        return buildString(sChars);
    }

    private void reverseString(char[] chars) {
        Stack<Integer> positions = new Stack<>();
        int index = 0;
        while (index < chars.length) {
            if (chars[index] == '(') {
                positions.push(index);
            } else if (chars[index] == ')') {
                int openingPosition = positions.pop();
                swapChars(chars, openingPosition + 1, index - 1);
                chars[openingPosition] = 0;
                chars[index] = 0;
            }
            index++;
        }
    }

    private void swapChars(char[] chars, int start, int end) {
        char temp;
        for (int i = start, j = end; i <= j; i++, j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }

    private String buildString(char[] chars) {
        StringBuilder stb = new StringBuilder();
        for (char c : chars) {
            if (c >= 'a') {
                stb.append(c);
            }
        }
        return stb.toString();
    }
}
