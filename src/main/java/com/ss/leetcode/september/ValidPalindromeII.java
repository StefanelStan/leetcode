package com.ss.leetcode.september;

public class ValidPalindromeII {
    // https://leetcode.com/problems/valid-palindrome-ii/
    public boolean validPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        int low = 0, high = s.length() -1;
        while (low <= high) {
            if (s.charAt(low) != s.charAt(high)) {
                return isPalindrome(s, low + 1, high) || isPalindrome(s, low, high -1);
            }
            low++;
            high--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low <= high) {
            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }
        return true;
    }
}
