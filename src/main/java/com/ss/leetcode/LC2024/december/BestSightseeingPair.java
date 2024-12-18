package com.ss.leetcode.LC2024.december;

public class BestSightseeingPair {
    // https://leetcode.com/problems/best-sightseeing-pair
    /** Algorithm
        1. The formula val[i] + val[j] + i - j equals to val[i] + i + (val[j] - j)
        2. So you need to keep track of a maxOnLeft that is max(val[i] + i)
        3. Traverse val and set the maxScore to be max(maxScore, maxOnLEft + vals[j] - j). Update maxOnLeft
     */
    public int maxScoreSightseeingPair(int[] values) {
        int maxScore = 0, maxOnLeft = values[0];
        for (int i = 1; i < values.length;i++) {
            maxScore = Math.max(maxScore, maxOnLeft + values[i] - i);
            maxOnLeft = Math.max(maxOnLeft, values[i] + i);
        }
        return maxScore;
    }

    // precompute the best distance from RIGHT for j vals and try iteratively with i
    public int maxScoreSightseeingPair2(int[] values) {
        int[] distanceBonus = new int[values.length];
        distanceBonus[values.length - 1] = (values[values.length - 1] - values.length) + 1;
        for (int i = values.length - 2; i >= 0; i--) {
            distanceBonus[i] = Math.max(distanceBonus[i + 1], values[i] - i);
        }
        int maxScore = 0;
        for (int i = 0; i < values.length - 1; i++) {
            maxScore = Math.max(maxScore, values[i] + i + distanceBonus[i+1]);
        }
        return maxScore;
    }
}
