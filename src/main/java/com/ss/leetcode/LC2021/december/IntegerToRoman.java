package com.ss.leetcode.LC2021.december;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    // https://leetcode.com/problems/integer-to-roman/
    private static Map<Integer, Character> numerals;

    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public IntegerToRoman() {
        if (numerals == null) {
            numerals = new HashMap<>();
            numerals.put(1, 'I');
            numerals.put(5, 'V');
            numerals.put(10, 'X');
            numerals.put(50, 'L');
            numerals.put(100, 'C');
            numerals.put(500, 'D');
            numerals.put(1000, 'M');
        }
    }

    public String intToRoman(int num) {
        StringBuilder stb = new StringBuilder();

        for (int i = 0;  i < values.length; i++) {
            while (num >= values[i]) {
                stb.append(symbols[i]);
                num -= values[i];
            }
        }
        return stb.toString();
    }

    public String intToRoman2(int num) {
        StringBuilder stb = new StringBuilder();
        intToRoman(num, stb);
        return stb.toString();
    }

    private void intToRoman(int num, StringBuilder stb) {
        if (num == 0) {
            return;
        }
        if (num >= 1000) {
            appendTimes(stb, num / 1000, numerals.get(1000));
            intToRoman(num % 1000, stb);
        } else if (num >= 900) {
            stb.append("CM");
            intToRoman(num - 900, stb);
        } else if (num >= 500) {
            stb.append(numerals.get(500));
            intToRoman(num % 500, stb);
        } else if (num >= 400) {
            stb.append("CD");
            intToRoman(num - 400, stb);
        } else if (num >= 100) {
            appendTimes(stb, num / 100, numerals.get(100));
            intToRoman(num % 100, stb);
        } else if (num >= 90) {
            stb.append("XC");
            intToRoman(num - 90, stb);
        } else if (num >= 50) {
            stb.append(numerals.get(50));
            intToRoman(num - 50, stb);
        } else if (num >= 40) {
            stb.append("XL");
            intToRoman(num - 40, stb);
        } else if (num >= 10) {
            appendTimes(stb, num / 10, numerals.get(10));
            intToRoman(num % 10, stb);
        } else if (num > 8) {
            stb.append("IX");
            intToRoman(num - 9, stb);
        } else if (num >= 5) {
            stb.append(numerals.get(5));
            intToRoman(num - 5, stb);
        } else if (num > 3) {
            stb.append("IV");
        } else {
            appendTimes(stb, num, numerals.get(1));
        }
    }

    private void appendTimes(StringBuilder stb, int times, char c) {
        for (int i = 0; i < times; i++) {
            stb.append(c);
        }
    }
}
