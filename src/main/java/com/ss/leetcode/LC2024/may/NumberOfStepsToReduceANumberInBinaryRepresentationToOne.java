package com.ss.leetcode.LC2024.may;

public class NumberOfStepsToReduceANumberInBinaryRepresentationToOne {
    // https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one
    public int numSteps(String s) {
        char[] sChars = s.toCharArray();
        int steps = 0, carryOver = 0, sDigit, computedDigit, ones = 0;
        for (char sChar : sChars) {
            ones += (sChar - '0');
        }
        for (int i = sChars.length - 1; i >= 0 && ones > 0; i--) {
            sDigit = sChars[i] - '0';
            ones -= sDigit;
            computedDigit = sDigit + carryOver;
            steps += computedDigit == 0 || computedDigit == 2
                ? 1
                : ones == 0
                    ? 0
                    : 2;
            carryOver = computedDigit > 0 ? 1 : 0;
        }
        return steps;
    }
}
