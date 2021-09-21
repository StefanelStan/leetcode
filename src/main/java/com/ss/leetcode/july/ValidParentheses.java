package com.ss.leetcode.july;

import java.util.LinkedList;

public class ValidParentheses {
    // https://leetcode.com/problems/valid-parentheses/
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        LinkedList<Character> chars = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if(c == '}' || c == ')' || c == ']') {
                if (chars.isEmpty()) {
                    return false;
                } else if (!areComplementary(chars.removeLast(), c)) {
                    return false;
                }
            } else {
                chars.add(c);
            }
        }
        return chars.isEmpty();
    }

    private boolean areComplementary(char left, char right) {
        return switch (left) {
            case '(' -> right == ')';
            case '[' -> right == ']';
            default -> right == '}';
        };
    }


    public boolean isValid2(String s) {
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
