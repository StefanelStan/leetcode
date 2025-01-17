package com.ss.leetcode.LC2025.january;

public class MinimumLevelsToGainMorePoints {
    // https://leetcode.com/problems/minimum-levels-to-gain-more-points
    /** Algorithm
        1. Get the totalPossiblePoints: if possible[i] == 0, add -1, else add 1
        2. Alice will stop playing once she has more points than the remaining points in the array
        3. Start traversing again and add the point to alice: (-1 is p[i]== 0, else 1)
            - at the same time, deduct it from the totalScore
        4. If alice > totalPoints and she has not reached the end (i != n -1), return the index. She needs those games.
        5. Else return -1 by default
     */
    public int minimumLevels(int[] possible) {
        int alicePoints = 0, totalPoints = 0;
        for (int p : possible) {
            totalPoints += (p == 0 ? -1 : 1);
        }
        for (int i = 0; i < possible.length; i++) {
            alicePoints += (possible[i] == 0 ? -1 : 1);
            totalPoints += (possible[i] == 0 ? 1 : -1);
            if (alicePoints > totalPoints && i != possible.length - 1) {
                return i + 1;
            }
        }
        return -1;
    }
}
