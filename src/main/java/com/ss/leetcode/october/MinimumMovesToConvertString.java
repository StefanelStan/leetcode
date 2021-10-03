package com.ss.leetcode.october;

public class MinimumMovesToConvertString {
    // https://leetcode.com/contest/weekly-contest-261/problems/minimum-moves-to-convert-string/
    public int minimumMoves(String s) {
        int minMoves = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'X') {
                minMoves++;
                i+=2;
            }
        }
        return minMoves;
    }
}
