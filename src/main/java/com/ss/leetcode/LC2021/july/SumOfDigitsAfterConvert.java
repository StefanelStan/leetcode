package com.ss.leetcode.LC2021.july;

public class SumOfDigitsAfterConvert {
    // https://leetcode.com/contest/weekly-contest-251/problems/sum-of-digits-of-string-after-convert/
    public int getLucky(String s, int k) {
        StringBuilder stb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            stb.append(s.charAt(i) - 'a' + 1);
        }
        String digitSum = addDigits(stb.toString());
        if (k == 1) {
            return Integer.parseInt(digitSum);
        } else {
            for (int j = 2; j <=k; j++) {
                digitSum = addDigits(digitSum);
            }
            return Integer.parseInt(digitSum);
        }
    }

    private String addDigits(String toString) {
        int sum = 0;
        for(int i= 0; i < toString.length(); i++) {
            sum += Integer.parseInt(String.valueOf(toString.charAt(i)));
        }
        return String.valueOf(sum);
    }
}
