package com.ss.leetcode.LC2021.february;

public class FindNumbersWithEvenNumberOfDigits {
    public int findNumbers(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            if (numberHasEvenDigits(num)) {
                sum++;
            }
        }
        return sum;
    }

    private boolean numberHasEvenDigits(int num) {
        boolean answer;
        if (num < 9 ) {
            answer = false;
        } else if (num < 100 ) {
            answer = true;
        } else if (num < 1000) {
            answer = false;
        } else if (num < 10000) {
            answer = true;
        } else if (num < 100000) {
            answer = false;
        } else if (num < 1000000) {
            answer = true;
        } else if (num < 10000000) {
            answer = false;
        } else if (num < 100000000) {
            answer =  true;
        } else answer = num >= 1000000000;
        return answer;
    }
}
