package com.ss.leetcode.LC2024.february;

import java.util.Arrays;

public class MaximumConsecutiveFloorsWithoutSpecialFloors {
    // https://leetcode.com/problems/maximum-consecutive-floors-without-special-floors/solutions
    /** Algorithm
        1. Sort the special floor.
        2. Loop with i from 1 to n-1 and keep track of the MAX gap between each special floor
        3. Return the max between the gaps of low & special[0]] and special[n-1] & high.
     */
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int maxConsec = 0;
        for (int i = 1; i < special.length; i++) {
            maxConsec = Math.max(maxConsec, special[i] - special[i - 1] - 1);
        }
        return Math.max(maxConsec, Math.max(special[0] - bottom, top - special[special.length - 1]));
    }
}
