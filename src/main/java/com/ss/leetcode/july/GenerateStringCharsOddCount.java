package com.ss.leetcode.july;

import java.util.Arrays;

public class GenerateStringCharsOddCount {
    // https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/
    public String generateTheString(int n) {
        char[] answer = new char[n];
        if ( n % 2 == 1) {
            Arrays.fill(answer, 'a');
        } else {
            answer[0] = 'a';
            Arrays.fill(answer, 1, answer.length, 'b');
        }
        return new String(answer);
    }
}
