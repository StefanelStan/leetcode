package com.ss.leetcode.LC2025.october;

public class CheckIfDigitsAreEqualInStringAfterOperationsI {
    // https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i
    /** Algorithm
        1. Get the chars from s.
        2. Using 2 pointers (end = s.length -1)
            - loop with i from 0 to end - 1
             - replace each char[i] with the modulo sum of chars[i] + chars[i+1]
        3. At the end, return chars[0] == chars[1]
     */
    public boolean hasSameDigits(String s) {
        char[] chars = s.toCharArray();
        int end = chars.length - 1;
        while (end > 1) {
            for (int i = 0; i < end; i++) {
                chars[i] = (char)('0' + (((chars[i] - '0') + (chars[i+1] - '0')) % 10));
            }
            end--;
        }
        return chars[0] == chars[1];
    }
}
