package com.ss.leetcode.LC2024.november;

public class LargestCombinationWithBitwiseANDGreaterThanZero {
    // https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero
    /** Algorithm
        1. The longest combination will be given by the numbers that have 1 on the same position.
        2. Use an int[24] count to count the position of 1s of each number;
        3. Return the max count of a position;
     */
    public int largestCombination(int[] candidates) {
        int[] bitCount =  new int[24];
        for (int candidate : candidates) {
            markBitcount(candidate, bitCount);
        }
        int max = 0;
        for (int count : bitCount) {
            max = Math.max(max, count);
        }
        return max;
    }

    private void markBitcount(int num, int[] bitCount) {
        for (int i = 23; i >=0 && num > 0; i--) {
            bitCount[i] += (int)(num & 1);
            num = num >> 1;
        }
    }
}
