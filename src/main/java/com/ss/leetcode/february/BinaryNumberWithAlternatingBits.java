package com.ss.leetcode.february;

public class BinaryNumberWithAlternatingBits {
    // https://leetcode.com/problems/binary-number-with-alternating-bits/
    public boolean hasAlternatingBits(int n) {
        String value = Integer.toBinaryString(n);
        if (value.length() == 1) {
            return true;
        }
        for (int i = 1; i < value.length(); i++) {
            if (value.charAt(i) == value.charAt(i-1)) {
                return false;
            }
        }
        return true;
    }
}
