package com.ss.leetcode.july;

public class BreakAPalindrome {
    // https://leetcode.com/problems/break-a-palindrome/
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        }
        char[] palindromeChars = palindrome.toCharArray();
        char[] brokenPalindrome = getBrokenPalindromeByDecreasing(palindromeChars);
        if (brokenPalindrome.length == 0) {
            brokenPalindrome = getBrokenPalindromeByIncreasing(palindromeChars);
        }
        return new String(brokenPalindrome);
    }

    private char[] getBrokenPalindromeByDecreasing(char[] palindromeChars) {
        char currentChar;
        for (int i = 0; i < palindromeChars.length; i++) {
            currentChar = palindromeChars[i];
                palindromeChars[i] = 'a';
                if (!isPalindrome(palindromeChars)) {
                    return palindromeChars;
                } else {
                    palindromeChars[i] = currentChar;
                }

        }
        return new char[0];
    }

    private char[] getBrokenPalindromeByIncreasing(char[] palindromeChars) {
        char currentChar;
        for (int i = palindromeChars.length - 1; i >= 0; i--) {
            currentChar = palindromeChars[i];
            if (currentChar < 'z') {
                palindromeChars[i] = (char) (palindromeChars[i] + 1);
                if (!isPalindrome(palindromeChars)) {
                    return palindromeChars;
                } else {
                    palindromeChars[i] = currentChar;
                }
            }
        }
        return new char[0];
    }

    private boolean isPalindrome(char[] chars) {
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
