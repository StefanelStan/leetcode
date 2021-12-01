package com.ss.leetcode.LC2021.august;

public class RemovePalindromicSubseq {
    // https://leetcode.com/problems/remove-palindromic-subsequences/
    public int removePalindromeSub(String s) {
        if(isPalindrome(s)) {
            return 1;
        } else {
            return 2;
        }
    }

    private boolean isPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            if(s.charAt(low++) != s.charAt(high--)){
                return false;
            }
        }
        return true;
    }
}
