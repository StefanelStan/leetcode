package com.ss.leetcode.LC2023.may;

public class NumberOfEvenAndOddBits {
    // https://leetcode.com/problems/number-of-even-and-odd-bits
    /** Algorithm:
        While n > 0
        1. Extract the last bit on n (n & 1).
        2. If last bit is 1, increment even or odd index by 1
        3. As index can be odd or even, simply adjust the index by (index+ 1) % 2.
        4. Shift n right by 1 (n >> 1)
     */
    public int[] evenOddBit(int n) {
        int index = 0;
        int[] evenOdd = {0,0};
        while(n > 0) {
            if ((n & 1) == 1) {
                evenOdd[index]++;
            }
            index = (index + 1) % 2;
            n = n >> 1;
        }
        return evenOdd;
    }
}
