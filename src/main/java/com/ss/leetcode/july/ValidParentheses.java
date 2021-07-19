package com.ss.leetcode.july;

public class ValidParentheses {
    // https://leetcode.com/problems/valid-parentheses/
    public boolean isValid(String s) {
        if (s.length() == 1 || s.charAt(0) == (')') || s.charAt(0) == ']' || s.charAt(0) == '}') {
            return false;
        }
        boolean[] marked = new boolean[s.length()];
        int previousPosition = 0;
        int moves = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isClosingParentheses(s.charAt(i))) {
                previousPosition = getPreviousPosition(marked, i - 1);
                if (previousPosition == -1) {
                    return false;
                }
                if (s.charAt(previousPosition) == oppositeOf(s.charAt(i))) {
                    marked[previousPosition] = true;
                    marked[i] = true;
                    moves += 2;
                } else {
                    return false;
                }
            }
        }
        return moves == s.length();
    }

    private int getPreviousPosition(boolean[] marked, int i) {
        for (; i >= 0; i--) {
            if (!marked[i]) {
                return i;
            }
        }
        return -1;
    }

    private char oppositeOf(char ch) {
        return ch == ')' ? '(' : ch == ']' ? '[' : '{';
    }

    private boolean isClosingParentheses(char ch) {
        return ch == ')' || ch == ']' || ch == '}';
    }

}
