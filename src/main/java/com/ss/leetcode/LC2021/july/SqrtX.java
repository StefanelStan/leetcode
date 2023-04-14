package com.ss.leetcode.LC2021.july;

public class SqrtX {
    // https://leetcode.com/problems/sqrtx/
    public int mySqrt(int x) {
        int low = 1, high = Math.max(1, x / 2), pivot;
        long possibleSquare;
        while(low <= high) {
            pivot = low + (high - low) / 2;
            possibleSquare = (long)pivot * pivot;
            if (possibleSquare == x) {
                return pivot;
            } else if (possibleSquare > x) {
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
        }
        return low - 1;
    }

    public int mySqrt2(int x) {
        switch(x) {
            case 0 : return 0;
            case 1,2,3 : return 1;
        }
        int possibleSquare = 0;
        for (int i = 1; i < x; i++) {
            possibleSquare = i * i;
            if (possibleSquare == x) {
                return i;
            }
            if (possibleSquare > x || possibleSquare < 0) {
                return i - 1;
            }
        }
        return 1;
    }
}
