package com.ss.leetcode.LC2022.march;

public class ScoreOfParentheses {
    // https://leetcode.com/problems/score-of-parentheses/
    public int scoreOfParentheses(String s) {
        int openLevel = 0;
        int answer =0;
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openLevel++;
            } else {
                openLevel--;
                if (i > 0 && s.charAt(i-1) == '(') {
                    answer += Math.pow(2, openLevel);
                }
            }
        }
        return answer;
    }
}
