package com.ss.leetcode.LC2024.december;

public class MinimumNumberOfOperationsToReinitializeAPermutation {
    // https://leetcode.com/problems/minimum-number-of-operations-to-reinitialize-a-permutation
    public int reinitializePermutation(int n) {
        int matching = 0, steps = 0;
        int[] perm = new int[n];
        for (int i = 1; i < n; i++) {
            perm[i] = i;
        }
        int[] temp;
        while (matching != n) {
            steps++;
            matching = 0;
            temp = new int[n];
            for (int i = 0; i < n; i++) {
                temp[i] = (i % 2 == 0 ? perm[i/2] : perm[n / 2 + (i-1) / 2]);
                matching += temp[i] == i ? 1 : 0;
            }
            perm = temp;
        }
        return steps;
    }
}
