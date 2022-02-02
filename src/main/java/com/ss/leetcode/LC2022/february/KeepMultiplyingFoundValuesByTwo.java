package com.ss.leetcode.LC2022.february;

public class KeepMultiplyingFoundValuesByTwo {
    // https://leetcode.com/problems/keep-multiplying-found-values-by-two/
    /** Algorithm
         1. Map the present nums via the help of a boolean[1001] (max num is 1000) (faster than Map<>)
         2. In a while loop, keep duplicating original while original < 1001 && boolean[original]==true
         3. Return original
     */
    public int findFinalValue(int[] nums, int original) {
        boolean[] existing = new boolean[1001];
        for(int num : nums) {
            existing[num] = true;
        }
        while(original < existing.length && existing[original]) {
            original *= 2;
        }
        return original;
    }
}
