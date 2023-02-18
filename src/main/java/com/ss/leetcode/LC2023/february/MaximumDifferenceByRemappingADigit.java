package com.ss.leetcode.LC2023.february;

import java.util.Arrays;

public class MaximumDifferenceByRemappingADigit {
    // https://leetcode.com/problems/maximum-difference-by-remapping-a-digit
    /** Algorithm
        1. Max: look for first digit that is NOT 9. Once encountered, copy it and set it to 9.
            All successive encounters of that digit will be replaced by 9.
        2. Min: Look for the first digit that is NOT 0. Once found, set it to 0.
            Also set all next future encounters of that digit to 0.
        3. Return the diff between the int value of the two numbers.
     */
    public int minMaxDifference(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        char[] min = Arrays.copyOf(digits, digits.length);
        char[] max = Arrays.copyOf(digits, digits.length);
        char minChar = '0';
        char maxChar = '9';
        boolean maxSet = false, minSet = false;
        for (int i = 0; i < digits.length; i++) {
            // set max
            if (digits[i] != '9') {
                if (!maxSet) {
                    maxSet = true;
                    maxChar = digits[i];
                    max[i] = '9';
                } else if (digits[i] == maxChar) {
                    max[i] = '9';
                }
            }
            if (digits[i] != '0') {
                if (!minSet) {
                    minSet = true;
                    minChar = digits[i];
                    min[i] = '0';
                } else if (digits[i] == minChar) {
                    min[i] = '0';
                }
            }
        }
        return Integer.parseInt(new String(max)) - Integer.parseInt(new String(min));
    }
}
