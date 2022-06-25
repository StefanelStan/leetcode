package com.ss.leetcode.LC2022.june;

public class CountAsterisks {
    /** Algorithm:
     *  1. Iterate over each character of string and keep a state boolean to determine if you're in a pair or outside pair
     *  2. If current char is asterisk and outside pair, then increment the general counter
     */
    public int countAsterisks(String s) {
        boolean pairMode = false;
        int asterisks = 0;
        for (char c : s.toCharArray()) {
            if (c == '|') {
                pairMode = !pairMode;
            } else if (c == '*') {
                asterisks += (pairMode ? 0 : 1);
            }
        }
        return asterisks;
    }
}
