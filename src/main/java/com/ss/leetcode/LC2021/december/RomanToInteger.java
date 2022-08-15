package com.ss.leetcode.LC2021.december;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    // https://leetcode.com/problems/roman-to-integer/
    public int romanToInt(String s) {
        int value = 0;
        int i = 0;
        while(i < s.length()) {
            switch(s.charAt(i)) {
                case 'M':
                    value += 1000;
                    i++;
                    break;
                case 'D' :
                    value += 500;
                    i++;
                    break;
                case 'C':
                    if (i < s.length() -1) {
                        if (s.charAt(i+1) == 'D') {
                            value += 400;
                            i += 2;
                        } else if (s.charAt(i+1) == 'M') {
                            value += 900;
                            i += 2;
                        } else {
                            value += 100;
                            i++;
                        }
                    } else {
                        value += 100;
                        i++;
                    }
                    break;
                case 'L' :
                    value += 50;
                    i++;
                    break;
                case 'X':
                    if (i < s.length() - 1) {
                        if (s.charAt(i+1) == 'L') {
                            value += 40;
                            i+=2;
                        } else if (s.charAt(i+1) == 'C') {
                            value += 90;
                            i += 2;
                        } else {
                            value += 10;
                            i++;
                        }
                    } else {
                        value += 10;
                        i++;
                    }
                    break;
                case 'V':
                    value += 5;
                    i++;
                    break;
                default:
                    if (i < s.length() - 1) {
                        if (s.charAt(i+1) == 'V') {
                            value += 4;
                            i += 2;
                        } else if (s.charAt(i + 1) == 'X') {
                            value += 9;
                            i += 2;
                        } else {
                            value += 1;
                            i++;
                        }
                    } else {
                        value += 1;
                        i++;
                    }
                    break;
            }
        }

        return value;
    }

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

    public int romanToInt2(String s) {
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
