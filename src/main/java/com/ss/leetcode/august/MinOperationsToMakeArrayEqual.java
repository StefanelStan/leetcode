package com.ss.leetcode.august;

public class MinOperationsToMakeArrayEqual {
    // https://leetcode.com/problems/minimum-operations-to-make-array-equal/
    public int minOperations(int n) {
        int minOperations= 0;
        for (int i = 1; i <= n; i += 2) {
            minOperations += n - i;
        }
        return minOperations;
    }
}
