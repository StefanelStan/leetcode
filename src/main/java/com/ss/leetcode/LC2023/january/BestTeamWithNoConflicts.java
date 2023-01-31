package com.ss.leetcode.LC2023.january;

import java.util.Arrays;

public class BestTeamWithNoConflicts {
    // https://leetcode.com/problems/best-team-with-no-conflicts
    /** Algorithm
        1. Create an int[n][2] to store the score/age of each player.
        2. Sort this by age and then by score. The players will now be sorted by age and value in increasing order.
        3. Use an int[n] to calculate the best matches from youngest to oldest player
        4. Starting with i from 1 to n, loop with j from i-1 back to 0.
            If current player can be matched with player j (age, value), player's j bestValue can be added to bestValue of [i].
        5. The idea is that if you have the players like [2,2],[3,3],[4,4]
            bestValue = [0,0,0];
            i = 0: bestValue of [0] is initialized with first player's value [2,0,0]
            i = 1: as player1 can be matched with player0, their combined value/ bestValue[1] = 5 [2,5,0]
            i = 2: as player2 can be combined with player1, their combined value bestValue[2] = 8 [2,5,8].
        6. There might be edge cases where playeri cannot be combined with player i-3,
            but you have to check all the way to 0 for the best/max combined value.
     */
    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] scoresAndAges = getSortedScoresAndAges(scores, ages);
        return getBestScore(scoresAndAges);
    }

    private int[][] getSortedScoresAndAges(int[] scores, int[] ages) {
        int[][] scoresAndAges = new int[scores.length][2];
        for (int i = 0; i < scores.length; i++) {
            scoresAndAges[i][0] = scores[i];
            scoresAndAges[i][1] = ages[i];
        }
        Arrays.sort(scoresAndAges, (a,b) -> a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        return scoresAndAges;
    }

    private int getBestScore(int[][] scoresAndAges) {
        int[] bestScores = new int[scoresAndAges.length];
        bestScores[0] = scoresAndAges[0][0];
        int maxScore = bestScores[0];
        for (int i = 1; i < scoresAndAges.length; i++) {
            bestScores[i] = scoresAndAges[i][0];
            for (int j = i-1; j >= 0; j--) {
                if (scoresAndAges[i][1] == scoresAndAges[j][1]
                    || (scoresAndAges[i][1] > scoresAndAges[j][1] && scoresAndAges[i][0] >= scoresAndAges[j][0])) {
                    bestScores[i] = Math.max(bestScores[i], scoresAndAges[i][0] + bestScores[j]);
                }
                maxScore = Math.max(maxScore, bestScores[i]);
            }
        }
        return maxScore;
    }
}
