package com.ss.leetcode.LC2022.march;

public class ConvertIntegerToTheSumOfTwoNoZeroIntegers {
    /** Algorithm
         1. Loop from 1 to n/2 and check if i & n - i are non zero integers.
         2. Non Zero Integer check : In a while loop, while nr > 0, check if number is div by 10
         If true, return false else nr = nr / 10;
         3. Return the first pair found.
     */
    public int[] getNoZeroIntegers(int n) {
        for (int i =1; i <= n/2; i++) {
            if (isNonZero(i) && isNonZero(n - i)) {
                return new int[]{i, n - i};
            }
        }
        return new int[]{0,0};
    }

    private boolean isNonZero(int val) {
        while (val > 0) {
            if (val % 10 == 0) {
                return false;
            }
            val = val / 10;
        }
        return true;
    }
}
