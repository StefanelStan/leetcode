package com.ss.leetcode.LC2022.september;

public class StrictlyPalindromicNumber {
    // https://leetcode.com/problems/strictly-palindromic-number
    public boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i <= n-2; i++) {
            if (!isPalindrome(Integer.toString(n, i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isPalindrome(String s) {
        int low = 0, high = s.length() -1;
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }
        return true;
    }
}
