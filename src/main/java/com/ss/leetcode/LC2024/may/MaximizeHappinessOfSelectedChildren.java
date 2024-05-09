package com.ss.leetcode.LC2024.may;

import java.util.Arrays;

public class MaximizeHappinessOfSelectedChildren {
    // https://leetcode.com/problems/maximize-happiness-of-selected-children
    /** Algorithm
        1. Sort the happiness in ASC order
        2. Starting with i from (n-1) and round = 0, add the max(0, happiness[i] - round) to current sum
        3. Decrement i and increment round
        4. Stop when round reaches k OR gained value reaches 0
     */
    public long maximumHappinessSum(int[] happiness, int k) {
        long sum = 0L;
        Arrays.sort(happiness);
        int gained = happiness[happiness.length - 1];
        for (int i = happiness.length - 1, round = 0; round < k && gained > 0; i--, round++) {
            gained = Math.max(0, happiness[i] - round);
            sum += gained;
        }
        return sum;
    }
}
