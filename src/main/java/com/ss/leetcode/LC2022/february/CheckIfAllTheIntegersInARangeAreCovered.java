package com.ss.leetcode.LC2022.february;

public class CheckIfAllTheIntegersInARangeAreCovered {
    // https://leetcode.com/problems/check-if-all-the-integers-in-a-range-are-covered/
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] markings = new int[51];
        boolean[] touched = new boolean[51];
        int score = 0;
        for (int[] range : ranges) {
            markings[range[0]] += 1;
            markings[range[1] + 1] -= 1;
            touched[range[0]] = true;
            touched[range[1]] = true;
        }

        for (int i = 1; i < markings.length; i++) {
            score += markings[i];
            if (score <= 0 && !touched[i] && (i >= left && i <= right)) {
                return false;
            }
        }
        return true;
    }
}
