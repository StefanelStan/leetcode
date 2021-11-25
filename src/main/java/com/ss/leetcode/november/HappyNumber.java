package com.ss.leetcode.november;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    private Set<Integer> sums;
    public boolean isHappy(int n) {
        setNums();
        while(true) {
            if (!sums.add(n)) {
                return false;
            }
            if ((n = getDigitSquares(n)) == 1) {
                return true;
            }
        }
    }

    private void setNums() {
        if(sums == null) {
            sums = new HashSet<>();
        }
    }

    private int getDigitSquares(int n) {
        int squareSum = 0;
        int remainder;
        while(n > 0) {
            remainder = n % 10;
            squareSum += remainder * remainder;
            n = n / 10;
        }
        return squareSum;
    }
}
