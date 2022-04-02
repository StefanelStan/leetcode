package com.ss.leetcode.LC2022.april;

public class SumOfScoresOfBuiltStrings {
    // https://leetcode.com/contest/biweekly-contest-75/problems/sum-of-scores-of-built-strings/
    // TLE
    public long sumScores(String s) {
        int sumScore = 0;
        int longestPrefix = 0;
        for (int i = s.length() -1; i >= 1; i--) {
            if (longestPrefix > 0) {
                if (s.charAt(0) == s.charAt(i)) {
                    if (i < s.length() - 1 && s.charAt(1) == s.charAt(i+1)) {
                        longestPrefix = getCommonPrefixLength(s, i);
                        sumScore += longestPrefix;
                    } else {
                        sumScore += 1;
                        longestPrefix = 1;
                    }
                } else {
                    longestPrefix = 0;
                }
            } else {
                longestPrefix = getCommonPrefixLength(s, i);
                if (longestPrefix > 0) {
                    sumScore += longestPrefix;
                }
            }
        }
        sumScore += s.length();
        return sumScore;
    }

    private int getCommonPrefixLength(String s, int right) {
        int longestPrefix = 0;
        for (int i = 0; right < s.length(); right++, i++) {
            if (s.charAt(i) == s.charAt(right)) {
                longestPrefix++;
            } else {
                break;
            }
        }
        return longestPrefix;
    }
}
