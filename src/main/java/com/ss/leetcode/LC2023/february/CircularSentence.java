package com.ss.leetcode.LC2023.february;

public class CircularSentence {
    // https://leetcode.com/problems/circular-sentence
    /** Algorithm
        1. Fail fast: check if char(0) == char(length-1)
        2. If yes, iterate from i = [1,n-2] and If current chat is " ", check if char i-1 == char i+1.
            Break if they do not match.
        3. Return the result;
     */
    public boolean isCircularSentence(String sentence) {
        boolean isCircular = sentence.charAt(0) == sentence.charAt(sentence.length() - 1);
        for (int i = 1; i < sentence.length() -1 && isCircular; i++) {
            if (sentence.charAt(i) == ' ' && sentence.charAt(i-1) != sentence.charAt(i+1)) {
                isCircular = false;
            }
        }
        return isCircular;
    }
}
