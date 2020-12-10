package com.ss.leetcode;

import java.util.HashMap;
import java.util.Map;

public class BestBreak {
    // https://leetcode.com/problems/integer-break/
    private static Map<Integer, Integer> bestBreak = new HashMap<>();

    static {
        bestBreak.put(1, 1);
        bestBreak.put(2, 1);
        bestBreak.put(3, 2);
        bestBreak.put(4, 4);
        bestBreak.put(5, 6);
    }

    public int integerBreak(int n) {
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
