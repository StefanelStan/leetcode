package com.ss.leetcode.LC2022.october;

public class NumberOfCommonFactors {
    // https://leetcode.com/problems/number-of-common-factors/
    /** Algorithm
        1. Any common factors will be lesser than the half of min between a and b
        2. Loop from 2 to half of min(a,b) and check if i divides both a and b.
        3. Edge case: as you stop at half of min (eg: 13 half of min (26,52), also check if max (52) divides min(26).
           (Do it only if min is not 1 to avoid starting the loop from 1).
     */
    public int commonFactors(int a, int b) {
        int min = Math.min(a,b);
        int max = Math.max(a,b);
        int commonFactors = 1;
        for (int i = 2; i <= min /2; i++) {
            if (min % i == 0 && max % i == 0) {
                commonFactors++;
            }
        }
        if (min != 1 && max % min == 0) {
            commonFactors++;
        }
        return commonFactors;
    }
}
