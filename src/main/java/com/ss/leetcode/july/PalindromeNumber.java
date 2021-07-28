package com.ss.leetcode.july;

public class PalindromeNumber {
    // https://leetcode.com/problems/palindrome-number/
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        int xCopy = x, remainderX = 0;
        while (xCopy > 0) {
            remainderX = remainderX * 10 + xCopy % 10;
            xCopy = xCopy / 10;
        }
        return remainderX == x;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        String xString = String.valueOf(x);
        int leftStart = xString.length() / 2 - 1;
        int rightStart = xString.length() % 2 == 0 ? xString.length() / 2 : xString.length() / 2 + 1;
        for (; leftStart >= 0; leftStart--, rightStart++) {
            if (xString.charAt(leftStart) != xString.charAt(rightStart)) {
                return false;
            }
        }
        return true;
    }
}
