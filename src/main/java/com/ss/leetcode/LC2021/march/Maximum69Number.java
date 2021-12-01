package com.ss.leetcode.LC2021.march;

public class Maximum69Number {
    // https://leetcode.com/problems/maximum-69-number/
    public int maximum69Number (int num) {
        char[] chars = String.valueOf(num).toCharArray();
        for(int i = 0; i < chars.length; i++) {
            if (chars[i] == '6') {
                chars[i] = '9';
                return Integer.parseInt(new String(chars));
            }
        }
        return num;
    }
}
