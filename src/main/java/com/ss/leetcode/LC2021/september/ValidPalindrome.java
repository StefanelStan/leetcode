package com.ss.leetcode.LC2021.september;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int low = 0, high = s.length() -1;
        while (low <= high) {
            while (low <= high) {
                if (isAlphanumeric(s.charAt(low))) {
                    break;
                }
                low++;
            }
            while (low <= high) {
                if (isAlphanumeric(s.charAt(high))) {
                    break;
                }
                high--;
            }
            if (low <= high) {
                if (areEqual(s.charAt(low), s.charAt(high))) {
                    low++;
                    high--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isAlphanumeric(char c) {
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    private boolean areEqual(char c1, char c2) {
        if (c1 >= 'a') {
            c1 -= 32;
        }
        if (c2 >= 'a') {
            c2 -= 32;
        }
        return c1 == c2;
    }
}
