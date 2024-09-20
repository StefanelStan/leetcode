package com.ss.leetcode.LC2023.march;

public class ShortestPalindrome {
    // https://leetcode.com/problems/shortest-palindrome
    public String shortestPalindrome(String s) {
        if (s.isEmpty()) {
            return s;
        }
        char[] chars = s.toCharArray();
        int right = chars.length - 1;
        while (!isPalindrome(chars, right)) {
            right--;
        }
        return right == chars.length - 1 ? s :  buildLongest(chars, s, right);
    }

    private String buildLongest(char[] chars, String s, int stop) {
        StringBuilder stb = new StringBuilder(chars.length + chars.length - stop);
        for (int right = chars.length -1; right > stop; right--) {
            stb.append(chars[right]);
        }
        stb.append(chars);
        return stb.toString();
    }

    private boolean isPalindrome(char[] chars, int right) {
        for (int left = 0; left < right; left++, right--) {
            if (chars[left] != chars[right]) {
                return false;
            }
        }
        return true;
    }


    /** Algorithm
        1. If the shortestPalindrome required 0 letters, then it would be the string itself
            This means left = length/2 and right = left + 0/1 (depending)
        2. If it's not zero, then try 1. The new left = (chars.length - 2 - i) / 2;
        3. As we can see, the shift the "pivot" or the possible palindrome one step left each time.
        4. Determine the closest middle pivot and build the string around that
     */
    public String shortestPalindrome2(String s) {
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
