package com.ss.leetcode.november;

public class LongestPalindrome {
    // https://leetcode.com/problems/longest-palindrome/
    public int longestPalindrome(String s) {
        int[] letterCount = new int['z' - 'A' + 1];
        int total = 0;
        boolean hasAnOdd = false;
        for (int i = 0; i < s.length(); i++) {
            letterCount[s.charAt(i) - 'A']++;
        }
        for (int count : letterCount) {
            if (count % 2 == 0) {
                total += count;
            } else {
                hasAnOdd = true;
                total += (count -1);
            }
        }
        return hasAnOdd ? total +1 : total;
    }
}
