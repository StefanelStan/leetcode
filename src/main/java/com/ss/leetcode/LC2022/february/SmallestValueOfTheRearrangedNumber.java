package com.ss.leetcode.LC2022.february;

import java.util.Arrays;
import java.util.Comparator;

public class SmallestValueOfTheRearrangedNumber {
    // https://leetcode.com/contest/weekly-contest-279/problems/smallest-value-of-the-rearranged-number/
    public long smallestNumber(long num) {
        if (num < 0) {
            return getMaxNumber(String.valueOf(-num).toCharArray());
        } else if (num > 0) {
            return getMinNumber(String.valueOf(num).toCharArray());
        } else {
            return 0;
        }
    }

    private long getMinNumber(char[] digits) {
        Arrays.sort(digits);
        if (digits[0] != '0') {
            return Long.parseLong(new String(digits));
        } else {
            int zeroIndex = 0;
            for (char digit : digits) {
                if (digit == '0') {
                    zeroIndex++;
                } else {
                    break;
                }
            }
            StringBuilder stb = new StringBuilder();
            stb.append(digits[zeroIndex++]);
            stb.append("0".repeat(zeroIndex -1));
            while(zeroIndex < digits.length) {
                stb.append(digits[zeroIndex++]);
            }
            return Long.parseLong(stb.toString());
        }
    }

    private long getMaxNumber(char[] digits) {
        Arrays.sort(digits);
        StringBuilder stb = new StringBuilder();
        for (int i = digits.length -1; i >= 0; i--) {
            stb.append(digits[i]);
        }
        return -Long.parseLong(stb.toString());
    }
}
