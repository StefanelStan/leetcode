package com.ss.leetcode.LC2022.march;

public class CountIntegersWithEvenDigitSum {
    // https://leetcode.com/problems/count-integers-with-even-digit-sum/
    public int countEven(int num) {
        int evenCount = 0;
        while(num >= 1) {
            evenCount += getEvenSumOfDigits(num--);
        }
        return evenCount;
    }

    private int getEvenSumOfDigits(int n) {
        int digitSum = 0;
        while (n > 9) {
            digitSum += n % 10;
            n = n/10;
        }

        digitSum += n;
        return (digitSum % 2 == 0 ? 1 : 0);
    }
}
