package com.ss.leetcode.LC2024.january;

public class FurthestPointFromOrigin {
    // https://leetcode.com/problems/furthest-point-from-origin
    /** Algorithm
        1. You want to move in the direction which has the most R or L.
        2. Count number of L/R and underscore.
        3. Return the Math.abs(lCount-rCount) + underscore.
     */
    public int furthestDistanceFromOrigin(String moves) {
        int lCount = 0, rCount = 0, underscore = 0;
        char move;
        for (int i = 0; i < moves.length(); i++) {
            move = moves.charAt(i);
            if (move == 'L') {
                lCount++;
            } else if (move == 'R') {
                rCount++;
            } else {
                underscore++;
            }
        }
        return Math.abs(lCount - rCount) + underscore;
    }
}
