package com.ss.leetcode.LC2022.february;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FindTheClosestPalindrome {
    // https://leetcode.com/problems/find-the-closest-palindrome/
    // TODO not yet complete!
    public String nearestPalindromic(String n) {
        if (n.length() < 2) {
            return String.valueOf((char)(n.charAt(0) - 1));
        }
        if (n.length() == 2 && (Integer.parseInt(n) == 10 || Integer.parseInt(n) == 11)) {
            return "9";
        }
        boolean isDefaultPalindrome = isPalindrome(n.toCharArray());
        if (isDefaultPalindrome) {
            return new String(transformIntoClosestPalindrome(n.toCharArray()));
        }
        if (n.length()  < 4) {
            return new String(getClosestPalindrome(n.toCharArray()));
        }
        char[] chars = n.toCharArray();
        int i = 0, j = chars.length -1;
        while (i < j && j - i > 2) {
            chars[j--] = chars[i++];

        }
        char[] palindrome = getClosestPalindrome(n.substring(i, j+1).toCharArray());
        for (char c : palindrome) {
            chars[i++] = c;
        }
        // check how to make 17 -> 22 and not 11 and 189 to 191 and not 181.
        return new String(chars);
    }

    private char[] transformIntoClosestPalindrome(char[] chrs) {
        int intVal = Integer.parseInt(new String(chrs));

        if(chrs.length == 2) {
            if (intVal == 99) {
                return new char[] { '1', '0', '1' };
            } else {
                return new char[] { (char) (chrs[0] - 1), (char) (chrs[0] - 1) };
            }
        }
//        if(chrs.length == 3) {
            List<PalindromePair> palindromes = new ArrayList<>();
            palindromes.add(getPalindromeByDuplicateDigit(intVal, chrs));
            palindromes.add(getPalindromeByDecreaseMiddle(intVal, chrs));
            palindromes.add(getPalindromeByIncreasingMiddle(intVal, chrs));

            palindromes.sort(Comparator.comparingInt(p -> p.diff));
            return palindromes.get(0).chars;
//        }

    }

    private char[] getClosestPalindrome(char[] chrs) {
        if(isPalindrome(chrs)) {
            return chrs;
        }

        if (chrs.length ==2) {
            return getPalindromeOfTwo(chrs);
        } else {
            return getPalindromeOfThee(chrs);
        }
    }

    private char[] getPalindromeOfThee(char[] chrs) {
        if (isPalindrome(chrs)) {
            return chrs;
        }
        int intVal = Integer.parseInt(String.valueOf(chrs));
        /**
            You have several options:
            189 =>
                1. Duplicate left digit; 189 => 181
                2. Decrease middle digit and smartly duplicate left - right - might need decrease hundreds: 171
                3. Increase middle digit and smartly duplicate left-right. - might need increase hundreds.: 191
        */
        List<PalindromePair> palindromes = new ArrayList<>();
        palindromes.add(getPalindromeByDuplicateDigit(intVal, chrs));
        palindromes.add(getPalindromeByDecreaseMiddle(intVal, chrs));
        palindromes.add(getPalindromeByIncreasingMiddle(intVal, chrs));

        palindromes.sort(Comparator.comparingInt(p -> p.diff));
        return palindromes.get(0).chars;
    }

    private PalindromePair getPalindromeByDuplicateDigit(int intVal, char[] chrs) {
        char[] palindrome = {chrs[0], chrs[1], chrs[0]};
        return new PalindromePair(Integer.parseInt(new String(palindrome))- intVal, palindrome);
    }

    private PalindromePair getPalindromeByDecreaseMiddle(int intVal, char[] chrs) {
        char[] palindrome;
        if(chrs[1] == '0') {
            palindrome = new char[] { (char) (chrs[0] - 1), '9', (char) (chrs[0] - 1) };
        } else {
            palindrome = new char[]{chrs[0], (char)(chrs[1] -1) , chrs[0]};
        }
        return new PalindromePair(Integer.parseInt(new String(palindrome))- intVal, palindrome);
    }

    private PalindromePair getPalindromeByIncreasingMiddle(int intVal, char[] chrs) {
        char[] palindrome;
        if(chrs[1] == '9') {
            palindrome = new char[] { (char) (chrs[0] + 1), '0', (char) (chrs[0] + 1) };
        } else {
            palindrome = new char[]{chrs[0], (char)(chrs[1] + 1) , chrs[0]};
        }
        return new PalindromePair(Integer.parseInt(new String(palindrome))- intVal, palindrome);
    }

    private boolean isPalindrome(char[] chrs) {
        for(int i = 0, j = chrs.length -1; i < j; i++, j--) {
            if (chrs[i] != chrs[j]) {
                return false;
            }
        }
        return true;
    }

    private char[] getPalindromeOfTwo(char[] chrs) {
        // 0X cases
        int intVal = Integer.parseInt(new String(chrs));
        char[] palindrome = null;
        int minVal = 0;
        char minChar = '0';
        while(palindrome == null) {
            if (intVal <= minVal+5) {
                palindrome = new char[2];
                palindrome[0] = minChar;
                palindrome[1] = minChar;
            } else {
                minVal+=11;
                minChar++;
            }
        }
        return palindrome;
    }

    private static class PalindromePair {
        int diff;
        char[] chars;

        public PalindromePair(int diff, char[] chars) {
            this.diff = diff;
            this.chars = chars;
        }
    }
}
