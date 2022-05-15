package com.ss.leetcode.LC2022.may;

public class Largest3SameDigitNumberInString {
    // https://leetcode.com/problems/largest-3-same-digit-number-in-string/
    public String largestGoodInteger(String num) {
        int max = -1;
        char[] digits = num.toCharArray();
        for(int i = 0; i < digits.length -2; i++) {
            if (digits[i] == digits[i+1] && digits[i+1] == digits[i+2]) {
                max = Math.max(max, getIntValueOf(digits[i]));
                if (max == 999) {
                    break;
                }
            }
        }
        return max == -1 ? "" : max == 0 ? "000" : String.valueOf(max);
    }

    private int getIntValueOf(char digit) {
        int val = digit - '0';
        return 100 * val + 10 * val + val;
    }
}
