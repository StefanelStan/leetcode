package com.ss.leetcode.LC2024.april;

public class ExistenceOfASubstringInAStringAndItsReverse {
    //
    /** Algorithm
        1. Loop with i from 0 to n-2 (string has a length of n).
        2. Inside this loop, loop with j from n-1 to i-1.
        3. If s[i] == s[j] && s[i+1] == s[j-1] return true.
        4. Return false by default.
     */
    public boolean isSubstringPresent(String s) {
        char[] sChars = s.toCharArray();
        for (int i = 0; i < sChars.length - 1; i++) {
            for (int j = sChars.length - 1; j > i; j--) {
                if (sChars[i] == sChars[j] && sChars[i+1] == sChars[j-1]) {
                    return true;
                }
            }
        }
        return false;
    }
}
