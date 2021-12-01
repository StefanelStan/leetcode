package com.ss.leetcode.LC2021.february;

public class FourDivisors {
    // https://leetcode.com/problems/four-divisors/
    public int sumFourDivisors(int[] nums) {
        int totalSumOfDivisors = 0;
        for(int num : nums) {
            totalSumOfDivisors += getSumOfFourDivisors(num);
        }
        return totalSumOfDivisors;
    }

    private int getSumOfFourDivisors(int num) {
        if(num < 6) {
            return 0;
        }
        int half = num /2 ;
        int sum = 1 + num;
        int numberOfDivisors = 2;
        for(int i = 2; i<= half; i++) {
            if (num % i == 0) {
                sum+=i;
                if(++numberOfDivisors > 4) {
                    return 0;
                }
            }
        }
        return numberOfDivisors < 4 ? 0 : sum;
    }
}
