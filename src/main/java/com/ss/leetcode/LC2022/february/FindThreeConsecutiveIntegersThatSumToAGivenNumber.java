package com.ss.leetcode.LC2022.february;

public class FindThreeConsecutiveIntegersThatSumToAGivenNumber {
    // https://leetcode.com/contest/biweekly-contest-72/problems/find-three-consecutive-integers-that-sum-to-a-given-number/
    public long[] sumOfThree(long num) {
        if (num % 3 != 0) {
            return new long[0];
        }
        long middle = num / 3;
        return new long[]{middle-1, middle, middle +1};
    }
}
