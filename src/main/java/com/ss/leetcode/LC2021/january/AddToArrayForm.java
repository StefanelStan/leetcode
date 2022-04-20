package com.ss.leetcode.LC2021.january;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AddToArrayForm {
    // https://leetcode.com/problems/add-to-array-form-of-integer/
    public List<Integer> addToArrayForm(int[] num, int k) {
        char[] kChar = String.valueOf(k).toCharArray();
        // You could add a linkedList and add it in front, but this is slower and uses more memory in the end
        int[] result = new int[Math.max(num.length, kChar.length)];
        int carryOver = 0, temp;
        for (int rI = result.length - 1, nI = num.length -1, kI = kChar.length -1; rI >= 0; rI--, nI--, kI--) {
            result[rI] += carryOver;
            if (nI >= 0) {
                result[rI] += num[nI];
            }
            if(kI >= 0) {
                result[rI] += (kChar[kI] - '0');
            }
            if (result[rI] > 9) {
                result[rI] -= 10;
                carryOver = 1;
            } else {
                carryOver =  0;
            }
            if (carryOver == 0 && nI < 0 && kI < 0) {
                break;
            }
        }
        List<Integer> sum = new ArrayList<>(result.length + carryOver);
        if(carryOver == 1) {
            sum.add(1);
        }
        for(int item : result) {
            sum.add(item);
        }
        return sum;
    }

    public List<Integer> addToArrayForm2(int[] digits, int K) {
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
