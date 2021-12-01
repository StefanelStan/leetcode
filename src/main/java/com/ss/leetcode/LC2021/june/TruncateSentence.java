package com.ss.leetcode.LC2021.june;

public class TruncateSentence {
    // https://leetcode.com/problems/truncate-sentence/
    public String truncateSentence(String s, int k) {
        int nrOfSpaces = 0;
        for (int  i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                nrOfSpaces++;
                if (nrOfSpaces == k) {
                    return s.substring(0, i);
                }
            }
        }
        return s;
    }
}
