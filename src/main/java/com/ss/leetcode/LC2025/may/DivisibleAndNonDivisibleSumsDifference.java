package com.ss.leetcode.LC2025.may;

public class DivisibleAndNonDivisibleSumsDifference {
    // https://leetcode.com/problems/divisible-and-non-divisible-sums-difference
    public int differenceOfSums(int n, int m) {
        int notDivisibleByM = 0, divisibleByM = 0;
        while (n >= 1) {
            if (n % m == 0) {
                divisibleByM += n;
            } else {
                notDivisibleByM += n;
            }
            n--;
        }
        return notDivisibleByM - divisibleByM;
    }
}
