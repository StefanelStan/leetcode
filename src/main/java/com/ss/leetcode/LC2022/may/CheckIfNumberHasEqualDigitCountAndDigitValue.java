package com.ss.leetcode.LC2022.may;

public class CheckIfNumberHasEqualDigitCountAndDigitValue {
    // https://leetcode.com/problems/check-if-number-has-equal-digit-count-and-digit-value/
    /** Algorithm
     1. hold a int[] count to count each digit from num
     2. loop over each char of num and set the count of its value
     3. for each digit in num, check if value is different than its count. return false if so.
     */
    public boolean digitCount(String num) {
        int[] count = new int[10];
        char[] chrs = num.toCharArray();
        for (char c : chrs) {
            count[c - '0']++;
        }
        for (int i = 0; i < chrs.length; i++) {
            if(count[i] != chrs[i] - '0') {
                return false;
            }
        }
        return true;
    }
}
