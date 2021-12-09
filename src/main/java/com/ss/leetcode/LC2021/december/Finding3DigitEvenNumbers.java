package com.ss.leetcode.LC2021.december;

import java.util.Arrays;

public class Finding3DigitEvenNumbers {
    // https://leetcode.com/problems/finding-3-digit-even-numbers/

    /** Algorithm
     *  1. Count how many unique digits there are in digits[] array. (x 0s, y 1s, z 2s etc).
     *  2. Loop from 100 to 998 and increase by 2 steps and check if the number can be formed.
     *  3. For each number, determine if each of its digits count is lower or equal than the digit count of the given array
     */
    public int[] findEvenNumbers(int[] digits) {
        int[] digitCount = new int[10];
        for (int digit : digits) {
            digitCount[digit]++;
        }
        int[] evenNrs = new int[450];
        int index = 0;
        for (int i = 100; i <= 998; i += 2) {
            if (canBeFormed(i, digitCount)) {
                evenNrs[index++] = i;
            }
        }
        return Arrays.copyOf(evenNrs, index);
    }

    private boolean canBeFormed(int number, int[] digitCount) {
        int[] numberDigits = new int[10];
        int modulo;
        while (number > 0) {
            modulo = number % 10;
            numberDigits[modulo]++;
            number /= 10;
        }
        for (int i = 0; i < numberDigits.length; i++) {
            if (numberDigits[i] > digitCount[i]) {
                return false;
            }
        }
        return true;
    }
}
