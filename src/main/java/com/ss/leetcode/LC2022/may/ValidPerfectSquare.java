package com.ss.leetcode.LC2022.may;

public class ValidPerfectSquare {
    // https://leetcode.com/problems/valid-perfect-square/
    public boolean isPerfectSquare(int num) {
        int low = 0, high = num;
        int mid;
        long square;
        while(low <= high) {
            mid = low + (high - low) /2;
            square = (long) mid * mid;
            if (num == square) {
                return true;
            } else if (square < num) {
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        return false;
    }
}
