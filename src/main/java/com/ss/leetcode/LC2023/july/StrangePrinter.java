package com.ss.leetcode.LC2023.july;

public class StrangePrinter {
    // https://leetcode.com/problems/strange-printer
    // NEEDS FURTHER REFINEMENT
    public int strangePrinter(String s) {
        if (s.length() == 1) {
            return 1;
        }
        if (s.length() == 2) {
            return s.charAt(0) == s.charAt(1) ? 1 : 2;
        }
        char[] chrs = s.toCharArray();
        int[] leftRight= {0, s.length() -1};
        int turns = 0;
        while(leftRight[0] <= leftRight[1]) {
            turns += printLeft(chrs, leftRight);
            turns += leftRight[0] <= leftRight[1] ? printRight(chrs, leftRight) : 0;
        }
        return turns;
    }

    private int printLeft(char[] chrs, int[] leftRight) {
        int turns = 1;
        if (leftRight[0] == 0) {
            turns = 1;
        } else if ((leftRight[0] == leftRight[1])
            && (chrs[leftRight[0]] == chrs[leftRight[0] - 1] || chrs[leftRight[0]] == chrs[leftRight[1] - 1])) {
            turns = 0;
        } else if (chrs[leftRight[0]] == chrs[leftRight[1] + 1] || chrs[leftRight[0] -1] == chrs[leftRight[0]]) {
            turns = 0;
        }
        char ch = chrs[leftRight[0]];
        while(leftRight[0] < chrs.length && ch == chrs[leftRight[0]]) {
            leftRight[0]++;
        }
        return turns;
    }

    private int printRight(char[] chrs, int[] leftRight) {
        int turns = 1;
        if ((leftRight[0] == leftRight[1])
            && (chrs[leftRight[0]] == chrs[leftRight[0] - 1] || chrs[leftRight[0]] == chrs[leftRight[1] - 1])) {
            turns = 0;
        } else if(chrs[leftRight[1]] == chrs[leftRight[0] - 1] || (leftRight[1] +1 < chrs.length && chrs[leftRight[1]] == chrs[leftRight[1] + 1])) {
            turns = 0;
        }
        char ch = chrs[leftRight[1]];
        while(leftRight[1] >= 0 && chrs[leftRight[1]] == ch) {
            leftRight[1]--;
        }
        return turns;
    }
}
