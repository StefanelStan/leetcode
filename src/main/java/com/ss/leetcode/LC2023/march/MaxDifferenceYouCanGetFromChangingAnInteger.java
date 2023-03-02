package com.ss.leetcode.LC2023.march;

import java.util.Arrays;

public class MaxDifferenceYouCanGetFromChangingAnInteger {
    // https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer
    /** Algorithm
        1. Use 2 helper methods that will determine the max and min
        2. Max: We want to transform the first and identical non-9 digit to 9.
            Iterate over the characters. Once you found the first digit != 9,
            replace it with 9 and ALL successive similar digits with 9.
        3. Due to problem constraint (no leading zeroes) we cannot make the first digit 0,
            Iterate over the characters and stop at the first digit > 1.
            If your index is 0, then this digit can only be transformed into 1
            EG: (eg: 3abc3) => 1abc1
            If your index is not 0, then this digit can be transformed into 0:
            eg: 11004abc4 -> 11000abc0
        4. Return the int diff between the two int chars.
     */
    public int maxDiff(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int max = getMaxValue(digits);
        int min = getMinValue(digits);
        return max - min;
    }

    private int getMaxValue(char[] digits) {
        char[] maxValue = Arrays.copyOf(digits, digits.length);
        char selectedDigit = 0;
        for(int i = 0; i < maxValue.length; i++) {
            if (maxValue[i] != '9') {
                if (selectedDigit == 0) {
                    selectedDigit = maxValue[i];
                    maxValue[i] = '9';
                }
            }
            if (maxValue[i] == selectedDigit) {
                maxValue[i] = '9';
            }
        }
        return Integer.parseInt(new String(maxValue));
    }

    private int getMinValue(char[] digits) {
        char[] minValue = Arrays.copyOf(digits, digits.length);
        char selectedDigit = 0;
        char targetDigit = 0;
        for(int i = 0; i < minValue.length; i++) {
            if (selectedDigit == 0 && minValue[i] > '1') {
                selectedDigit = minValue[i];
                targetDigit = i == 0 ? '1' : '0';
                minValue[i] = targetDigit;
            } else if (minValue[i] == selectedDigit) {
                minValue[i] = targetDigit;
            }
        }
        return Integer.parseInt(String.valueOf(minValue));
    }
}
