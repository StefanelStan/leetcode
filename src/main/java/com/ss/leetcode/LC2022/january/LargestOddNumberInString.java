package com.ss.leetcode.LC2022.january;

public class LargestOddNumberInString {
    // https://leetcode.com/problems/largest-odd-number-in-string/
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
