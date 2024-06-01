package com.ss.leetcode.LC2024.june;

public class ScoreOfAString {
    // https://leetcode.com/problems/score-of-a-string
    /** Algorithm
        1. Traverse string with i from [1..n-1].
        2. Increment your score by abs(s[i] - s[i-1]).
        3. Return sum.
     */
    public int scoreOfString(String s) {
        int score = 0;
        char prev = s.charAt(0), current;
        for (int i = 1; i < s.length(); i++) {
            current = s.charAt(i);
            score += Math.abs(prev - current);
            prev = current;
        }
        return score;
    }
}
