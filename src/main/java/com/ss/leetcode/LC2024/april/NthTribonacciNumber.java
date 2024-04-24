package com.ss.leetcode.LC2024.april;

public class NthTribonacciNumber {
    // https://leetcode.com/problems/n-th-tribonacci-number
    /** Algorithm
        1. Store the first 3 numbers in numbers[0,1,1]
        2. If n < 3, return numbers[n]
        3. Else, while (k = 3 && k <= n)
            - the next number will be prefixSum of first 3 numbers
            - when moving next, deduct first number from prefixSum and add next
            - shift the numbers ( 0 = 1, 1 =2, 2=next)
        4. Return numbers[2]
     */
    public int tribonacci(int n) {
        int[] numbers = {0,1,1};
        if (n < 3) {
            return numbers[n];
        }
        int prefixSum = 2, next;
        for (int k = 3; k <= n; k++) {
            next = prefixSum;
            prefixSum += next - numbers[0];
            numbers[0] = numbers[1];
            numbers[1] = numbers[2];
            numbers[2] = next;
        }
        return numbers[2];
    }
}
