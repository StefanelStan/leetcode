package com.ss.leetcode.LC2021.december;

public class LongestPalindromicSubstring {
    // https://leetcode.com/problems/longest-palindromic-substring/
    public String longestPalindrome(String s) {
        int[] lp = {0,0};
        for (int i = 0; i < s.length() - (lp[1] - lp[0]); i++) {
            for (int j = s.length() -1; j >= i + ((lp[1] - lp[0])); j--) {
                if (j - i <= lp[1] - lp[0]) {
                    break;
                }
                if (isPalindrome(s, i, j)) {
                    if (j - i > lp[1] - lp[0]) {
                        lp[1] = j;
                        lp[0] = i;
                    }
                    break;
                }
            }
        }
        return s.substring(lp[0], lp[1] + 1);
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if(s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
