package com.ss.leetcode.august;

public class PlusOne {
    // https://leetcode.com/problems/plus-one/
    public int[] plusOne(int[] digits) {
        int carried = 0;
        int tmp = 1;
        for (int i = digits.length -1; i >= 0; i--) {
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
