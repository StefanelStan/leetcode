package com.ss.leetcode.LC2021.december;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    // https://leetcode.com/problems/integer-to-roman/
    private static final int[] ints = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
    private static final String[] romans = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
    public String intToRoman(int num) {
        StringBuilder stb = new StringBuilder();
        int i = ints.length - 1;
        while(num > 0) {
            if (num >= ints[i]) {
                stb.append(romans[i]);
                num -= ints[i];
            } else {
                i--;
            }
        }
        return stb.toString();
    }

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

    public String intToRoman2(int num) {
        StringBuilder stb = new StringBuilder();

        for (int i = 0;  i < values.length; i++) {
            while (num >= values[i]) {
                stb.append(symbols[i]);
                num -= values[i];
            }
        }
        return stb.toString();
    }

    public String intToRoman3(int num) {
        StringBuilder stb = new StringBuilder();
        parseIntToRoman(num, stb);
        return stb.toString();
    }

    private void parseIntToRoman(int num, StringBuilder stb) {
        if (num == 0) {
            return;
        }
        if (num >= 1000) {
            appendTimes(stb, num / 1000, numerals.get(1000));
            parseIntToRoman(num % 1000, stb);
        } else if (num >= 900) {
            stb.append("CM");
            parseIntToRoman(num - 900, stb);
        } else if (num >= 500) {
            stb.append(numerals.get(500));
            parseIntToRoman(num % 500, stb);
        } else if (num >= 400) {
            stb.append("CD");
            parseIntToRoman(num - 400, stb);
        } else if (num >= 100) {
            appendTimes(stb, num / 100, numerals.get(100));
            parseIntToRoman(num % 100, stb);
        } else if (num >= 90) {
            stb.append("XC");
            parseIntToRoman(num - 90, stb);
        } else if (num >= 50) {
            stb.append(numerals.get(50));
            parseIntToRoman(num - 50, stb);
        } else if (num >= 40) {
            stb.append("XL");
            parseIntToRoman(num - 40, stb);
        } else if (num >= 10) {
            appendTimes(stb, num / 10, numerals.get(10));
            parseIntToRoman(num % 10, stb);
        } else if (num > 8) {
            stb.append("IX");
            parseIntToRoman(num - 9, stb);
        } else if (num >= 5) {
            stb.append(numerals.get(5));
            parseIntToRoman(num - 5, stb);
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
