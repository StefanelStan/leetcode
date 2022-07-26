package com.ss.leetcode.LC2022.july;

public class FirstLetterToAppearTwice {
    // https://leetcode.com/problems/first-letter-to-appear-twice/
    /** Algorithm
         1. Mark the presence of each char (a-z) of s in a boolean[26] repeated.
            lowercase char - 'a' wil return a number between 0 and 25, thus mapping onto the boolean[26].
         2. For each char c of s, if repeated[c - 'a'] is true, it means it was already put, so return c,
            else mark it as true (repeated[c- 'a'] = true);
     */
    public char repeatedCharacter(String s) {
        boolean[] repeated = new boolean[26];
        for (char c : s.toCharArray()) {
            if (repeated[c - 'a']) {
                return c;
            } else {
                repeated[c - 'a'] = true;
            }
        }
        return 'a';
    }
}
