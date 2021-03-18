package com.ss.leetcode.march;

public class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String S) {
        int openingCount = 0, closingCount =0;
        for(int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                openingCount++;
            } else {
                if (openingCount > 0) {
                    openingCount--;
                } else {
                    closingCount++;
                }
            }
        }
        return openingCount + closingCount;
    }
}
