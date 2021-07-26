package com.ss.leetcode.july;

public class FindNUniqueIntegersSumUpToZero {
    // https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
    public int[] sumZero(int n) {

        int[] nrs = new int[n];
        int sum = 0;
        for(int i = 1; i < n; i++) {
            nrs[i] = i;
            sum += i;
        }
        nrs[0] =  (-1 * sum);
        return nrs;
    }
}
