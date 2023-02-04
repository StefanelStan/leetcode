package com.ss.leetcode.LC2023.february;

import java.util.ArrayList;
import java.util.List;

public class SeparateTheDigitsInAnArray {
    // https://leetcode.com/contest/biweekly-contest-97/problems/separate-the-digits-in-an-array/
    /** Algorithm
        1. Add the digits of each number into an int list
        2. Convert the list into an int[]
     */
    public int[] separateDigits(int[] nums) {
        List<Integer> digits = new ArrayList<>();
        for(int num : nums) {
            toDigits(num, digits);
        }
        int[] answer = new int[digits.size()];
        for (int i = 0; i < digits.size(); i++) {
            answer[i] = digits.get(i);
        }
        return answer;
    }

    private void toDigits(int num, List<Integer> toDigits) {
        char[] digits = String.valueOf(num).toCharArray();
        for (char c : digits) {
            toDigits.add(c - '0');
        }
    }
}
