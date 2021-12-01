package com.ss.leetcode.LC2021.july;

public class BreakAPalindrome {
    // https://leetcode.com/problems/break-a-palindrome/
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        }
        char[] palindromeChars = palindrome.toCharArray();
        if(!breakPalindromeByDecreasing(palindromeChars)) {
            breakPalindromeByIncreasing(palindromeChars);
        }
        return new String(palindromeChars);
    }

    private boolean breakPalindromeByDecreasing(char[] palindromeChars) {
        char currentChar;
        for (int i = 0; i < palindromeChars.length; i++) {
            currentChar = palindromeChars[i];
                palindromeChars[i] = 'a';
                if (!isPalindrome(palindromeChars)) {
                    return true;
                } else {
                    palindromeChars[i] = currentChar;
                }
        }
        return false;
    }

    private void breakPalindromeByIncreasing(char[] palindromeChars) {
        char currentChar;
        for (int i = palindromeChars.length - 1; i >= 0; i--) {
            currentChar = palindromeChars[i];
            if (currentChar < 'z') {
                palindromeChars[i] = (char) (palindromeChars[i] + 1);
                if (!isPalindrome(palindromeChars)) {
                    break;
                } else {
                    palindromeChars[i] = currentChar;
                }
            }
        }
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
