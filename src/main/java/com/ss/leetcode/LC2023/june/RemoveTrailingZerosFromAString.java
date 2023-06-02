package com.ss.leetcode.LC2023.june;

public class RemoveTrailingZerosFromAString {
    // https://leetcode.com/problems/remove-trailing-zeros-from-a-string
    /** Algorithm
        1. Use right = n-1 to iterate from back of the string while char(right) == 0.
            Right will stop when reaching the first non-zero char in string
        2. Return substring 0, right + 1.
    */
    public String removeTrailingZeros(String num) {
        int right = num.length() - 1;
        while (right >= 0 && num.charAt(right) == '0') {
            right--;
        }
        return num.substring(0, right + 1);
        // return num.subString(0, num.lastIndexOf('0'));
    }
}
