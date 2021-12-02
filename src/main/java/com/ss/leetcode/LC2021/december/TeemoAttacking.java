package com.ss.leetcode.LC2021.december;

public class TeemoAttacking {
    // https://leetcode.com/problems/teemo-attacking/
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int totalPoison = duration;
        int prevPoisonTime = timeSeries[0] + duration -1;
        for (int i = 1; i < timeSeries.length; i++) {
            if (prevPoisonTime >= timeSeries[i]) {
                totalPoison -= (prevPoisonTime - timeSeries[i] +1);
            }
            prevPoisonTime = timeSeries[i] + duration -1;
            totalPoison+= duration;
        }
        return totalPoison;
    }
}
