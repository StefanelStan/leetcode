package com.ss.leetcode.LC2021.july;

public class BreakAPalindrome {
    // https://leetcode.com/problems/break-a-palindrome/
    /** Algorithm
     1. FastFail: if length == 1, return ""
     2. You have two possibilities:
        a). Normal palindrome: "abba". In this case, traverse from 0 until half and try to change the first char that is > a into a. So abba => aaba.
        b). If a) did not work, it means you are in the edge case of "a...a" palindrome. This means you need to change the last a into b => "a...a" => "a....ab"
     */
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        }
        char[] chars = palindrome.toCharArray();
        if(!canBreak(chars)) {
            chars[chars.length -1] = 'b';
        }
        return new String(chars);
    }

    private boolean canBreak(char[] chars) {
        for (int i = 0; i < chars.length /2; i++) {
            if (chars[i] > 'a') {
                chars[i] = 'a';
                return true;
            }
        }
        return false;
    }


    public String breakPalindrome2(String palindrome) {
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
