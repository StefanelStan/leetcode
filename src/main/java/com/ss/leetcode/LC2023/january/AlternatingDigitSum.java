package com.ss.leetcode.LC2023.january;

public class AlternatingDigitSum {
    // https://leetcode.com/problems/alternating-digit-sum
    /** Algorithm
        1. get the char[] digits of the int
        2. Traverse the char[] with an index i from 0 (most significant -> least significant)
            If i % 2 == 0 (even index), then add its positive value, else add its negative value.
        3. Return the sum of digits.
     */
    public int alternateDigitSum(int n) {
        int sum = 0;
        char[] digits = String.valueOf(n).toCharArray();
        for(int i = 0; i < digits.length; i++) {
            sum += i % 2 == 0 ? digits[i] - '0' : -(digits[i] - '0');
        }
        return sum;
    }
}
