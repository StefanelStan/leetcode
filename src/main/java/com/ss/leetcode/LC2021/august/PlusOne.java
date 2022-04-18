package com.ss.leetcode.LC2021.august;

public class PlusOne {

    // https://leetcode.com/problems/plus-one/
    public int[] plusOne(int[] digits) {
        int[] plusOne = new int[digits.length];
        // set carryOver 1 to simulate adding 1 to the whole integer.
        int carryOver = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            plusOne[i] = digits[i] + carryOver;
            if (plusOne[i] > 9) {
                plusOne[i] -= 10;
                carryOver = 1;
            } else {
                carryOver = 0;
            }
        }
        if (carryOver == 1) {
            int[] newAnswer = new int[digits.length + 1];
            newAnswer[0] = 1;
            System.arraycopy(plusOne, 0, newAnswer, 1, plusOne.length);
            plusOne = newAnswer;
        }
        return plusOne;
    }

    public int[] plusOne2(int[] digits) {
        int carried = 0;
        int tmp = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            tmp += digits[i] + carried;
            if (tmp > 9) {
                carried = 1;
                digits[i] = tmp - 10;
            } else {
                carried = 0;
            }
            tmp = 0;
        }
        if (carried == 1) {
            int[] answer = new int[digits.length + 1];
            System.arraycopy(digits, 0, answer, 1, digits.length);
            answer[0] = 1;
            return answer;
        }
        return digits;
    }
}
