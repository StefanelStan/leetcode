package com.ss.leetcode.LC2021.december;

import java.util.Arrays;

public class CheckIfAStringCanBreakAnotherString {
    // https://leetcode.com/problems/check-if-a-string-can-break-another-string/
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] c1Chars = s1.toCharArray();
        char[] c2Chars = s2.toCharArray();
        Arrays.sort(c1Chars);
        Arrays.sort(c2Chars);
        boolean lower = false, higher = false;
        for (int i = 0; i < c1Chars.length; i++) {
            if (c1Chars[i] < c2Chars[i]) {
                lower = true;
            } else if (c1Chars[i] > c2Chars[i]) {
                higher = true;
            }
            if (higher && lower) {
                return false;
            }
        }
        return true;
    }
}
