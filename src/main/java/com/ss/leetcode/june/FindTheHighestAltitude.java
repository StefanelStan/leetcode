package com.ss.leetcode.june;

public class FindTheHighestAltitude {
    // https://leetcode.com/problems/find-the-highest-altitude/
    public int largestAltitude(int[] gain) {
        int sum = 0;
        int max = 0;
        for (int g: gain) {
            sum += g;
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
