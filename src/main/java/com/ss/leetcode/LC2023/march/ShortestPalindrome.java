package com.ss.leetcode.LC2023.march;

public class ShortestPalindrome {
    // https://leetcode.com/problems/shortest-palindrome
    /** Algorithm
        1. If the shortestPalindrome required 0 letters, then it would be the string itself
            This means left = length/2 and right = left + 0/1 (depending)
        2. If it's not zero, then try 1. The new left = (chars.length - 2 - i) / 2;
        3. As we can see, the shift the "pivot" or the possible palindrome one step left each time.
        4. Determine the closest middle pivot and build the string around that
     */
    public String shortestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (isPotentialPalindrome(i, chars)) {
                return buildPalindrome(i, chars);
            }
        }
        return buildPalindrome(s.length() - 1, chars);
    }

    private String buildPalindrome(int extra, char[] chars) {
        StringBuilder stb = new StringBuilder(extra + chars.length);
        int i = 1;
        while(i <= extra) {
            stb.append(chars[chars.length - i]);
            i++;
        }
        stb.append(chars);
        return stb.toString();
    }

    private boolean isPotentialPalindrome(int i, char[] chars) {
        int left = (chars.length - 2 - i) / 2;
        int right = (chars.length + i) % 2 == 0 ? left + 1 : left + 2;
        while(left >= 0) {
            if (chars[left--] != chars[right++])  {
                return false;
            }
        }
        return true;
    }
}
