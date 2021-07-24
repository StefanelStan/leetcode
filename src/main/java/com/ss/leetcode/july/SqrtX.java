package com.ss.leetcode.july;

public class SqrtX {
    // https://leetcode.com/problems/sqrtx/
    public int mySqrt(int x) {
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
