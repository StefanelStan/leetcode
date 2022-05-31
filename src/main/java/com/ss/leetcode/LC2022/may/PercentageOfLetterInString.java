package com.ss.leetcode.LC2022.may;

import java.util.stream.Stream;

public class PercentageOfLetterInString {
    // https://leetcode.com/problems/percentage-of-letter-in-string/
    /** Algorithm
        1. Traverse the string and count how many chars equal with the given letter
        2. Obtain the percentage by multiplying the count with 100 and dividing by length of s
     */
    public int percentageLetter(String s, char letter) {
        int count = 0;
        for(char c : s.toCharArray()) {
            if (c == letter) {
                count++;
            }
        }
        return (count * 100) / s.length();
    }
}
