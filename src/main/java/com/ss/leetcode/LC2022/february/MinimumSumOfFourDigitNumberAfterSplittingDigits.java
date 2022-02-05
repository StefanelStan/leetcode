package com.ss.leetcode.LC2022.february;

import java.util.Arrays;

public class MinimumSumOfFourDigitNumberAfterSplittingDigits {
    // https://leetcode.com/contest/biweekly-contest-71/problems/minimum-sum-of-four-digit-number-after-splitting-digits/
    public int minimumSum(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);
        // 0 and 123
        StringBuilder stb1 = new StringBuilder();
        StringBuilder stb2 = new StringBuilder();
        StringBuilder stb3 = new StringBuilder();
        stb1.append(digits[1]).append(digits[2]).append(digits[3]);
        stb2.append(digits[0]).append(digits[3]);
        stb3.append(digits[1]).append(digits[2]);

        return Math.min(Integer.parseInt(String.valueOf(digits[0])) + Integer.parseInt(stb1.toString()),
            Integer.parseInt(stb2.toString()) + Integer.parseInt(stb3.toString()));
    }
}
