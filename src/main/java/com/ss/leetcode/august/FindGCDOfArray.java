package com.ss.leetcode.august;

public class FindGCDOfArray {
    // https://leetcode.com/problems/find-greatest-common-divisor-of-array/
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }

        if (max % min == 0) {
            return min;
        }
        int i = min / 2;
        while (i >= 1) {
            if (max % i == 0 && min % i == 0) {
                return i;
            }
            i--;
        }
        return 1;
    }
}
