package com.ss.leetcode.LC2021.february;

public class ReverseInteger {
    public int reverse(int x) {
        boolean isNegative = x < 0;
        String nr = String.valueOf(x);
        StringBuilder stb = new StringBuilder(isNegative ? nr.substring(1) : nr);
        long reversed = Long.parseLong(stb.reverse().toString());
        if (isNegative) {
            reversed = -reversed;
        }
        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) reversed;
    }
}
