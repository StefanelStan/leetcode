package com.ss.leetcode.LC2025.july;

public class FindTheOriginalTypedStringI {
    // https://leetcode.com/problems/find-the-original-typed-string-i
    /** Algorithm
        1. A sequence of n equal characters would give n-1 possible strings: "aaa" => "a" and "aa" (Ignoring the original string aaa)
        2. Traverse word and if current char matches prev char, increment the count by 1.
     */
    public int possibleStringCount(String word) {
        int stringCount = 1;
        char lastChar = word.charAt(0), currentChar;
        for (int i = 1; i < word.length(); i++) {
            currentChar = word.charAt(i);
            stringCount += (lastChar == currentChar ? 1 : 0);
            lastChar = currentChar;
        }
        return stringCount;
    }
}
