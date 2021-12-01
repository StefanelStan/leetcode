package com.ss.leetcode.LC2021.november;

public class ConsecutiveCharacters {
    // https://leetcode.com/problems/consecutive-characters/
    public int maxPower(String s) {
        int currentMax = 1, totalMax = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                currentMax++;
                totalMax = Math.max(totalMax, currentMax);
            } else {
                currentMax = 1;
            }
        }
        return totalMax;
    }
}
