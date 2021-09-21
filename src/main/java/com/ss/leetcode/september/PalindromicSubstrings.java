package com.ss.leetcode.september;

public class PalindromicSubstrings {
    // https://leetcode.com/problems/palindromic-substrings/
    public int countSubstrings(String s) {
        int totalPalindromes = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            totalPalindromes += countPalindromes(i, i + 1, s);
            totalPalindromes += countPalindromes(i - 1, i + 1, s);
        }
        // each single char is a palindrome so add that
        return totalPalindromes + s.length();
    }

    private int countPalindromes(int left, int right, String s) {
        int palindromes = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                palindromes++;
                left--;
                right++;
            } else {
                break;
            }
        }
        return palindromes;
    }
}
