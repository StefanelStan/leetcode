package com.ss.leetcode.LC2022.december;

public class MaximumEnemyFortsThatCanBeCaptured {
    // https://leetcode.com/problems/maximum-enemy-forts-that-can-be-captured
    /** Algorithm
        1. Traverse the forts and keep track of lastNoFort and lastUnderCommandFort.
        2. If current index
            - is == 1 and you know the lastNoFort, set the maxCaptured as Max(maxCaptured, index - lastNoFort).
                Also set lastNoFort to -1 (unknown). This is to simulate than you can calculate the distance
                between -1 .. 1 and not -1 .. 1 1  and mistakenly use the 2nd 1 to calculate distance.
                Set lastUnderCommand to current index
            - is == -1 and you know the lastUnderCommand, set the maxCaptured as Max(maxCaptured, index - lastUnderCommand).
                Also set lastUnderCommand to -1 (unknown).
                 Set lastNoFort to current index.
        3. Return maxCaptured.
     */
    public int captureForts(int[] forts) {
        int lastNoFort = -1, lastUnderCommand = -1, maxCaptured = 0;
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] == 1) {
                if (lastNoFort != -1) {
                    maxCaptured = Math.max(maxCaptured, i - lastNoFort - 1);
                    lastNoFort = -1;
                }
                lastUnderCommand = i;
            } else if (forts[i] == -1) {
                if (lastUnderCommand != -1) {
                    maxCaptured = Math.max(maxCaptured, i - lastUnderCommand - 1);
                    lastUnderCommand = -1;
                }
                lastNoFort = i;
            }
        }
        return maxCaptured;
    }
}
