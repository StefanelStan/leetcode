package com.ss.leetcode.LC2023.june;

public class LexicographicallySmallestPalindrome {
    // https://leetcode.com/problems/lexicographically-smallest-palindrome
    /** Algorithm
        1. Use 2 pointers i, j = 0, n-1.
        2. Traverse with these two pointers and set chars[i] and chars[j] to be min(chars[i], chars[j]);
            EG2: dbca -> i = 0, j = 3. Min(d, a) = a => stirng becomes adca
            i = 1, j = 2. Min(b, c) = b => string becomes abba
        3. Return the string.
     */
    public String makeSmallestPalindrome(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            chars[j] = chars[i] = (char)Math.min(chars[i], chars[j]);
        }
        return new String(chars);
    }
}
