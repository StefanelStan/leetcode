package com.ss.leetcode.LC2022.july;

public class GreatestEnglishLetterInUpperAndLowerCase {
    // https://leetcode.com/problems/greatest-english-letter-in-upper-and-lower-case/
    /** Algorithm
         1. Use two boolean[26] to mark the presence of each upperCase/lowerCase letter of String. (A-Z, a-z)
         2. Traverse the string and mark each letter in its correct array; upper or lower
         3. With an i from 25 to 0, return the first upperCase letter (as String) on which
            lowerCase[i] == true && upperCase[i] = true
         4. Return "" if #3 didn't return anything yet.
     */
    public String greatestLetter(String s) {
        boolean[] upperCase = new boolean[26];
        boolean[] lowerCase = new boolean[26];
        for(char c : s.toCharArray()) {
            if (c >= 'a') {
                lowerCase[c- 'a'] =  true;
            } else {
                upperCase[c - 'A'] = true;
            }
            // EXTRA: we could keep track of the max letter (0-25) if upperCase[i] && lowerCase[i],
            // however, we would do this check n times, and I believe it's better to traverse the upperCase[i] once,
            // at the end.  One 26 items traversal is faster than 1000 checks.
        }
        return getMaxLetter(upperCase, lowerCase);
    }

    private String getMaxLetter(boolean[] upperCase, boolean[] lowerCase) {
        for (int i = upperCase.length -1; i>= 0 ; i--) {
            if (upperCase[i] && lowerCase[i]) {
                return String.valueOf((char)(i + 'A'));
            }
        }
        return "";
    }
}
