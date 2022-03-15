package com.ss.leetcode.LC2022.march;

import java.util.Deque;
import java.util.LinkedList;

public class MinimumRemoveToMakeValidParentheses {
    // https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> indices = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                indices.addLast(i);
            } else if (s.charAt(i) == ')'){
                if (!indices.isEmpty() && s.charAt(indices.peekLast()) == '(') {
                    indices.removeLast();
                } else {
                    indices.addLast(i);
                }
            }
        }

        if (indices.isEmpty()) {
            return s;
        }
        StringBuilder stb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (indices.isEmpty()) {
                stb.append(s.charAt(i));
            } else {
                if (i == indices.peekFirst()) {
                    indices.removeFirst();
                } else {
                    stb.append(s.charAt(i));
                }
            }
        }
        return stb.toString();
    }
}
