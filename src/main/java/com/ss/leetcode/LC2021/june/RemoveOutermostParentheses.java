package com.ss.leetcode.LC2021.june;

public class RemoveOutermostParentheses {
    // https://leetcode.com/problems/remove-outermost-parentheses/
    public String removeOuterParentheses(String s) {
        StringBuilder stb = new StringBuilder();
        int start = 0, openLevel = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openLevel++;
                if (openLevel == 1) {
                    start = i;
                }
            } else {
                openLevel--;
                if (openLevel == 0) {
                    stb.append(s.substring(start+1, i));
                    start = 0;
                }
            }
        }
        return stb.toString();
    }
}
