package com.ss.leetcode.LC2024.august;

public class FindTheSumOfEncryptedIntegers {
    // https://leetcode.com/problems/find-the-sum-of-encrypted-integers
    /** Algorithm
        1. Add the encryption value of each num to a sum and return it
        2. Encrypting
        2.1: while the number > 0
            - determine the max digit by num % 10
            - keep track of number of divisions (length)
            - divide it by 10
        2.2 - while length-- > 0
            - num = num * 10 + max
     */
    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += encrypt(num);
        }
        return sum;
    }

    private int encrypt(int num) {
        int length = 0, max = 0;
        while(num > 0) {
            max = Math.max(max, num % 10);
            num = num / 10;
            length++;
        }
        while (length > 0) {
            num = num * 10 + max;
            length--;
        }
        return num;
    }
}
