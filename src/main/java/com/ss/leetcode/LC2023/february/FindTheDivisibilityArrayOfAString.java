package com.ss.leetcode.LC2023.february;

public class FindTheDivisibilityArrayOfAString {
    // https://leetcode.com/problems/find-the-divisibility-array-of-a-string
    /** Algorithm
        1. As the number can have 10^5 digits, we cannot use the whole value of the number, but just in segments of modulo m
        2. For each position of i, multiply a remainder by 10, add the digit to it and modulo m.
        3. If this remainder (the modulo) is 0, then the number at position i is divisible my m.
     */
    public int[] divisibilityArray(String word, int m) {
        long remainder = 0;
        int[] answer = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            remainder = (remainder * 10 + (word.charAt(i) - '0')) % m;
            if(remainder == 0) {
                answer[i] = 1;
            }
        }
        return answer;
    }
}
