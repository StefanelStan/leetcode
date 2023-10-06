package com.ss.leetcode.LC2020.december;

import java.util.HashMap;
import java.util.Map;

public class IntegerBreak {
    // https://leetcode.com/problems/integer-break/
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        } else if (n == 4) {
            return 4;
        } else {
            return breakInteger(n);
        }
    }

    private int breakInteger(int n) {
        int div = n / 3;
        int mod = n % 3;
        if (mod == 1) {
            return (int)Math.pow(3, div - 1) * 4;
        }
        int result = (int)Math.pow(3, div);
        if (mod != 0) {
            result *= mod;
        }
        return result;
    }










    private static Map<Integer, Integer> bestBreak = new HashMap<>();
    static {
        bestBreak.put(1, 1);
        bestBreak.put(2, 1);
        bestBreak.put(3, 2);
        bestBreak.put(4, 4);
        bestBreak.put(5, 6);
    }

    public int integerBreak2(int n) {
        if(bestBreak.containsKey(n)) {
            return bestBreak.get(n);
        }
        int remainder = n % 3;
        int threeTimes = n / 3;
        int power = (int) Math.pow(3.0, threeTimes-1);
        if (remainder == 0) {
            power *= 3;
        } else if (remainder == 1) {
           power *= 4;
        } else if (remainder == 2 ) {
            power *= 3 * 2;
        }
        return power;
    }

}
