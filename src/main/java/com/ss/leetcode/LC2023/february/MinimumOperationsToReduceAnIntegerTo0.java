package com.ss.leetcode.LC2023.february;

public class MinimumOperationsToReduceAnIntegerTo0 {
    // https://leetcode.com/problems/minimum-operations-to-reduce-an-integer-to-0
    /** Algorithm
        1. Given a number n, there is a chance n is a power of two OR not.
        2. Calculate an int[] power representing the first 18 powers of two (1,2,4,8..131072)
        3. Binary Search - look for  n in the power array
        4. If n is a power of 2, power[returnedIndex] == n, then return 1 as you only need 1 step
        5. If n is NOT a power of 2, aka power[returnedIndex] != n, then we need to determine how many steps
            we need close the distance between n AND the closest power (power[rI -1], power[rI]).
            EG: n = 56.
            The binary search will return element 64 (the closest insertion index).
            As this is not a power of two, we need to recursively call this passing Math.min(64-56, 56-32).
            We want to find the min number of steps used by the smallest distance from n to closest power.
     */
    public int minOperations(int n) {
        int[] powerOfTwo = getPowerOfTwo();
        return getStepsToZero(powerOfTwo, n);
    }

    private int getStepsToZero(int[] powerOfTwo, int n) {
        int nextPower = getPowerIndex(powerOfTwo, n);
        int steps = 1;
        if (powerOfTwo[nextPower] != n) {
            // EG: n = 56. The closest power is 64. We need 1 extra step PLUS the steps to make Math.min(64-56, 54-32) = 0.
            steps += getStepsToZero(powerOfTwo, Math.min(powerOfTwo[nextPower] - n, n - powerOfTwo[nextPower -1]));
        }
        return steps;
    }

    private int getPowerIndex(int[] power, int n) {
        int left = 0, right = power.length -1;
        int pivot;
        while(left <= right) {
            pivot = left + (right - left) / 2;
            if (power[pivot] == n) {
                return pivot;
            } else if (power[pivot] > n) {
                right = pivot -1;
            } else {
                left = pivot + 1;
            }
        }
        return left;
    }

    private int[] getPowerOfTwo() {
        int[] power = new int[18];
        power[0] = 1;
        for (int i = 1; i < power.length; i++) {
            power[i] = 2 * power[i-1];
        }
        return power;
    }
}
