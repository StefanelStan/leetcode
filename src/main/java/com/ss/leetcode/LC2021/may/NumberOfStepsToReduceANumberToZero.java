package com.ss.leetcode.LC2021.may;

public class NumberOfStepsToReduceANumberToZero {
    // https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
    public int numberOfSteps(int num) {
        int nrOfSteps = 0;
        while (num != 0) {
            num = (num % 2 == 0) ? num / 2 : num - 1;
            nrOfSteps++;
        }
        return nrOfSteps;
    }
}
