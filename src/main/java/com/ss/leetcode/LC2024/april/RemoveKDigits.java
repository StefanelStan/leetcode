package com.ss.leetcode.LC2024.april;

public class RemoveKDigits {
    // https://leetcode.com/problems/remove-k-digits
    public String removeKdigits(String num, int k) {
        StringBuilder stb = new StringBuilder();
        int newLength = num.length() - k, rightLength;
        char current;
        for (int i = 0; i < num.length(); i++) {
            current = num.charAt(i);
            rightLength = num.length() - i;
            while (!stb.isEmpty() && stb.charAt(stb.length() - 1) > current && stb.length() + rightLength > newLength) {
                stb.setLength(stb.length() - 1);
            }
            if (stb.length() < newLength) {
                stb.append(current);
            }
        }
        return toString(stb);
    }

    private String toString(StringBuilder digits) {
        if (digits.isEmpty()) {
            return "0";
        }
        if (digits.charAt(0) != '0') {
            return digits.toString();
        }
        StringBuilder stb = new StringBuilder();
        boolean zeroHead = true;
        char digit;
        for (int i = 0; i < digits.length(); i++) {
            digit = digits.charAt(i);
            if (!(digit == '0' && zeroHead)) { // skip any leading zero
                zeroHead = false;
                stb.append(digit);
            }
        }
        return stb.isEmpty() ? "0" : stb.toString();
    }
}
