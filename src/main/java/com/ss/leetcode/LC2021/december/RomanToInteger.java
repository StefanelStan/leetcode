package com.ss.leetcode.LC2021.december;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    // https://leetcode.com/problems/roman-to-integer/
    private static Map<Character, Integer> numerals;

    public RomanToInteger() {
        if (numerals == null) {
            numerals = new HashMap<>();
            numerals.put('I', 1);
            numerals.put('V', 5);
            numerals.put('X', 10);
            numerals.put('L', 50);
            numerals.put('C', 100);
            numerals.put('D', 500);
            numerals.put('M', 1000);
        }
    }

    public int romanToInt(String s) {
        int[] total = {0};
        romanToInt(s, 0, total);
        return total[0];
    }

    private void romanToInt(String s, int i, int[] total) {
        if (i >= s.length()) {
            return;
        }
        char val = s.charAt(i);
        if (val == 'M' || val == 'D' || val == 'L' || val == 'V' || i == s.length() -1) {
            total[0] += numerals.get(val);
            romanToInt(s, i + 1, total);
        } else if (s.charAt(i + 1) == val) {
            total[0] += (numerals.get(val) * 2);
            romanToInt(s, i + 2, total);
        } else if (numerals.get(val) > numerals.get(s.charAt(i + 1))) {
            total[0] += numerals.get(val);
            romanToInt(s, i + 1, total);
        } else {
            total[0] += (numerals.get(s.charAt(i + 1)) - numerals.get(val));
            romanToInt(s, i + 2, total);
        }
    }
}
