package com.ss.leetcode.LC2022.october;

public class CountNumberOfDistinctIntegersAfterReverseOperations {
    // https://leetcode.com/problems/count-number-of-distinct-integers-after-reverse-operations/
    /** Algorithm
         1. Use a boolean[1_000_001] to mark the present numbers.
         2. Iterate and calculate reverse of each num.
         3. Mark the presence of num and its reverse. If present[] is false, then this is a
            new distinct number, so count it. If present[] is true, it was already counted.
         4. Return number of distinct integers.
     */
    public int countDistinctIntegers(int[] nums) {
        boolean[] present = new boolean[1_000_001];
        int distinct = 0, reverse;
        for (int num : nums) {
            if (!present[num]) {
                distinct++;
            }
            present[num] = true;
            reverse = getReverse(num);
            if (!present[reverse]) {
                distinct++;
            }
            present[reverse] = true;
        }
        return distinct;
    }

    private int getReverse(int num) {
        int rem = 0, val = 0;
        while (num > 0) {
            rem = num % 10;
            val = val * 10 + rem;
            num = num / 10;
        }
        return val;
    }
}
