package com.ss.leetcode.november;

public class LongerContiguousSegmentsOf1Than0 {
    // https://leetcode.com/problems/longer-contiguous-segments-of-ones-than-zeros/
    public boolean checkZeroOnes(String s) {
        int longestZero = 0, longestOne = 0, tempZero=0, tempOne=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                tempZero++;
                longestZero = Math.max(tempZero, longestZero);
                tempOne = 0;
            } else {
                tempOne++;
                longestOne = Math.max(tempOne, longestOne);
                tempZero = 0;
            }
        }
        return longestOne > longestZero;
    }
}
