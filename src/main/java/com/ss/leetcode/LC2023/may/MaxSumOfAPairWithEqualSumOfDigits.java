package com.ss.leetcode.LC2023.may;

public class MaxSumOfAPairWithEqualSumOfDigits {
    // https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits
    /** Algorithm
        1. As numbers are in the range 1 - 10^9, the highest sum of digits is given by 999.999.999 = 81.
            So ALL the numbers will have a digit sum between 1 and 81.
        2. Use an int[82][2] sumOfDigits to store the highest two numbers for each digit sum.
        3. Traverse nums and calculate digitSum (ds). Determine/set the max/highest numbers for their [digitSum]
            sumOfDigits[ds][1] - will store the max number for that digit sum, while [0] will store 2nd highest.
        4. Traverse sumOfDigits and if sumOfDigits[i][0] != 0 (you have two numbers for this sum),
            determine their sum and compare with the max sum ever encountered.
     */
    public int maximumSum(int[] nums) {
        int[][] sumOfDigits = mapSumOfDigits(nums);
        int max = -1;
        for (int[] digitSum : sumOfDigits) {
            if (digitSum[0] != 0) {
                max = Math.max(max, digitSum[0] + digitSum[1]);
            }
        }
        return max;
    }

    private int[][] mapSumOfDigits(int[] nums) {
        int[][] sumOfDigits =  new int[82][2];
        int digitsSum;
        for (int num : nums) {
            digitsSum = getSumOfDigits(num);
            if (num >= sumOfDigits[digitsSum][1]) {
                sumOfDigits[digitsSum][0] = sumOfDigits[digitsSum][1];
                sumOfDigits[digitsSum][1] = num;
            } else if (num > sumOfDigits[digitsSum][0]) {
                sumOfDigits[digitsSum][0] = num;
            }
        }
        return sumOfDigits;
    }

    private int getSumOfDigits(int num) {
        int sum = 0;
        while(num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}
