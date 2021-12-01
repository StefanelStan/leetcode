package com.ss.leetcode.LC2021.september;

public class MinimumCostToMoveChips {
    // https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
    public int minCostToMoveChips(int[] position) {
        int oddPositions = 0, evenPositions = 0;
        for (int pos : position) {
            if (pos % 2 == 0) {
                evenPositions++;
            } else {
                oddPositions++;
            }
        }
        return Math.min(oddPositions, evenPositions);
    }
}
