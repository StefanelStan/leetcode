package com.ss.leetcode.LC2021.march;

public class MinimumAddToMakeParenthesesValid {
    // https://leetcode.com/problems/minimum-add-to-make-parentheses-valid
    /** Algorithm
        1. Traverse s and keep track of opened and closed parenthesis
        2. If current char is (, increment open
        3. Else, if open > 0, decrement open, else increment closed.
        4. Return openend + closed;
     */
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
