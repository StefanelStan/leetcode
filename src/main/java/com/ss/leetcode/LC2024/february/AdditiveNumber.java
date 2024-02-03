package com.ss.leetcode.LC2024.february;

public class AdditiveNumber {
    // https://leetcode.com/problems/additive-number
    /** Algorithm
        1. fail fast: if length < 3 return false.
        2. if first 2 chars are 0 , 0 then all the string must be 0
        3. loop with i from 0 to n-3 and j from i+ to n -2.
            use two longs first, second to mark the long value of numbers represented by value indices of i, j
        4. for each loop of i
            - if i+1 is zero, then you need to find a next number first + 0 from index i+2
            - else, loop with j and create second and find first + second.
        5. Stop when hitting overflows (first/second < 0)
     */
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) {
            return false;
        }
        if (num.charAt(0) == '0' && num.charAt(1) == '0') {
            return num.codePoints().sum() == (int)'0' * num.length();
        }
        char[] digits = num.toCharArray();
        long first = 0, second;
        for (int i = 0; i < digits.length -2 && first >= 0; i++) {
            // If first character was 0 and you still not found a valid sequence (eg: 01123), then return false;
            if (i > 0 && digits[0] == '0') {
                return false;
            }
            first = first * 10 + digits[i] - '0';
            second = 0;
            // you have edge case EG: 1230123
            if (digits[i+1] == '0') {
                if (canMakeAdditiveChain(first, second, i + 2, digits)) {
                    return true;
                }
            } else {
                for (int j = i + 1; j < digits.length - 1 && second >= 0 && first >= 0; j++) {
                    second = second * 10 + digits[j] - '0';
                    if (canMakeAdditiveChain(first, second, j + 1, digits)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean canMakeAdditiveChain(long first, long second, int from, char[] digits) {
        if (from == digits.length) {
            return true;
        }
        // you can't have your 3rd, 4th number is seq starting with 0
        if (digits[from] == '0' || first + second < 0 || second < 0) {
            return false;
        }
        long expectedSum = first + second;
        long currentSum = 0;
        for (; from < digits.length && currentSum >= 0 && currentSum < expectedSum; from++) {
            currentSum =  currentSum * 10 + digits[from] - '0';
            if (currentSum == expectedSum) {
                return canMakeAdditiveChain(second, currentSum, from + 1, digits);
            }
        }
        return false;
    }
}
