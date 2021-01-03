package com.ss.leetcode;

import java.util.LinkedList;
import java.util.List;

public class AddToArrayForm {
    // https://leetcode.com/problems/add-to-array-form-of-integer/
    public List<Integer> addToArrayForm(int[] digits, int K) {
        List<Integer> result = new LinkedList<>();
        int[] kDigits = getKAsArray(K);

        int[] longest = digits.length > kDigits.length ? digits : kDigits;
        int[] shortest = longest == digits ? kDigits : digits;

        int carryOver = 0;
        for(int i = longest.length -1, j = shortest.length -1; i >= 0 && j >= 0; i--, j--) {
            int currentSum = longest[i] + shortest[j] + carryOver;
            if (currentSum > 9) {
                longest[i] = currentSum % 10;
                carryOver = 1;
            } else {
                longest[i] = currentSum;
                carryOver = 0;
            }
        }
        for(int i = longest.length -1 - shortest.length; i >= 0;i--) {
            int currentSum = longest[i] + carryOver;
            if (currentSum > 9) {
                longest[i] = currentSum % 10;
                carryOver = 1;
            } else {
                longest[i] = currentSum;
                carryOver = 0;
            }
        }

        if(carryOver > 0) {
            result.add(1);
        }
        for(int digit : longest) {
            result.add(digit);
        }

        return result;
    }

    private int[] getKAsArray(int k) {
        String s = String.valueOf(k);
        int[] digits = new int[s.length()];
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            digits[i] = Integer.parseInt(chars[i]+"");
        }
        return digits;
    }
}
