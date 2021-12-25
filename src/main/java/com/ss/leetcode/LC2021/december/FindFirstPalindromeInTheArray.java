package com.ss.leetcode.LC2021.december;

public class FindFirstPalindromeInTheArray {
    // https://leetcode.com/problems/find-first-palindromic-string-in-the-array/
    public String firstPalindrome(String[] words) {
        String firstPalindrome = "";
        for (String word : words) {
            if (isPalindrome(word)){
                firstPalindrome = word;
                break;
            }
        }
        return firstPalindrome;
    }

    private boolean isPalindrome (String word) {
        int low = 0, high = word.length() - 1;
        while (low < high){
            if (word.charAt(low++) != word.charAt(high--)) {
                return false;
            }
        }

        return true;
    }
}
