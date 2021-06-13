package com.ss.leetcode.june;

public class ToLowerCase {
    // https://leetcode.com/problems/to-lower-case/
    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            if (chars[i] >= 65 && chars[i] <= 90) {
                chars[i] += 32;
            }
        }
        return new String(chars);
    }
}
