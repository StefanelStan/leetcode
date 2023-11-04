package com.ss.leetcode.LC2023.november;

public class LastMomentBeforeAllAntsFallOutOfAPlank {
    // https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank
    public int getLastMoment(int n, int[] left, int[] right) {
        int lastMoment = 0;
        for (int antLocation : left) {
            lastMoment = Math.max(lastMoment, antLocation);
        }
        for (int antLocation : right) {
            lastMoment = Math.max(lastMoment, n - antLocation);
        }
        return lastMoment;
    }
}
