package com.ss.leetcode.LC2022.may;

public class Largest3SameDigitNumberInString {
    // https://leetcode.com/problems/largest-3-same-digit-number-in-string/
    /** Algorithm
        1. Traverse num and keep track of the largest 3-same char: largestChar.
        2. While traversing, if prev 2 chars match the current one, then set the max largestChar
        3. If largestChar is 0, (no 3 alike met) return "", else a string made out of largestChar reperated 3 times.
     */
    public String largestGoodInteger(String num) {
        char largestChar = 0, minusTwo = 0, minusOne = 0, current;
        for (int i = 0; i < num.length(); i++) {
            current = num.charAt(i);
            if (minusTwo == minusOne && minusOne == current) {
                largestChar = (char)Math.max(largestChar, current);
            }
            minusTwo = minusOne;
            minusOne = current;
        }
        return largestChar == 0 ? "" : new String(new char[]{largestChar,largestChar,largestChar});
    }


    public String largestGoodInteger2(String num) {
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
