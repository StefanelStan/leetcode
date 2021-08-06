package com.ss.leetcode.august;

public class MinOperationsToMakeArrayEqual {
    // https://leetcode.com/problems/minimum-operations-to-make-array-equal/
    public int minOperations(int n) {
        int minOperations= 0;
        int possiblesum = n %2 != 0? (n-1)/2 * (1 + n) : n /2 * (1+n);
        for (int i = 1; i <= n; i += 2) {
            minOperations += n - i;
        }
        return minOperations;
    }
}
