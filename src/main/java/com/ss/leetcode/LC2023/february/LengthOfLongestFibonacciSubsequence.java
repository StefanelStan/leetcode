package com.ss.leetcode.LC2023.february;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestFibonacciSubsequence {
    // https://leetcode.com/problems/length-of-longest-fibonacci-subsequence
    /** Algorithm
        1. Traverse and add all numbers to a set.
        2. Traverse arr with i from 0 to n-1 and j from i+1 to n.
        3. For each pair i,j check if set contains i+j, if yes, then check if set contains j + (i+2) (their fibonacci sum)
            Stop when the set does not contain their sum anymore
        4. Keep track of the longest fibonacci sequence.
           !Note: starting with 1, fib(42) > 10^9. Ideally, you would NOT want to check the same sequence again
           eg: 1,3,4,7,11,18
           i = 0;  1+4 = 4. Found 4. 3+4 -> found 7 ... the max chain is 6.
           i = 1:  3+4 = 7. Found 7. 4+7 -> found 11. You are repeating and walking the previous chain.
           However, it is only max 40 steps. Keeping track of chains would actually slow down.
     */
    public int lenLongestFibSubseq(int[] arr) {
        int maxFibonacci = 0;
        Set<Integer> nums = new HashSet<>();
        for (int num : arr) {
            nums.add(num);
        }
        for (int i = 0; i < arr.length -1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                maxFibonacci = Math.max(maxFibonacci, searchForFibonacci(arr[i], arr[j], nums));
            }
        }
        return maxFibonacci;
    }

    private int searchForFibonacci(int num1, int num2, Set<Integer> nums) {
        int sequence = 0;
        while(nums.contains(num1 + num2)) {
            num2 += num1;
            num1 = num2 - num1;
            if (sequence == 0) {
                sequence = 2;
            }
            sequence++;
        }
        return sequence;
    }
}
