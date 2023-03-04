package com.ss.leetcode.LC2023.march;

import java.util.Arrays;

public class SplitWithMinimumSum {
    // https://leetcode.com/problems/split-with-minimum-sum/
    /** Algorithm
        1. Sort the digits of the num (as char[])
        2. Iterate over them and add them to two ints/sum:
             if index is odd, add build and add it to sum1
            if index is even, add/build and add it to sum2
            EG: 4325 -> sorted 2345
            i = 0 sum1 = 2
            i = 1 sum2 = 3
            i = 2 sum1 = 24
            i = 3 sum2 = 35.
        3. Return the sum of two sums.
     */
    public int splitNum(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);
        int part1 = 0, part2 = 0;
        for (int i = 0; i < digits.length; i++) {
            if (i % 2 == 0) {
                part1 = part1 * 10 + (digits[i] - '0');
            } else {
                part2 = part2 * 10 + (digits[i] - '0');
            }
        }
        return part1 + part2;
    }
}
