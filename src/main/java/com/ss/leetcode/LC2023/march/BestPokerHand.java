package com.ss.leetcode.LC2023.march;

public class BestPokerHand {
    // https://leetcode.com/problems/best-poker-hand
    /** Algorithm
        1. Use an int[] presentSuits and presentRanks to count the ranks/suits.
        2. Traverse and count the ranks/suits. Also keep track of maxSameRank / maxSameSuite
        3. Return the answer based on maxSameSuite == 5 / maxSameRank >=3 / >= 2
     */
    public String bestHand(int[] ranks, char[] suits) {
        int[] presentSuits = new int[4];
        int[] presentRanks = new int[14];
        int sameSuit = 0, sameRank = 0;
        for (int i = 0; i < suits.length; i++) {
            sameRank = Math.max(sameRank, ++presentRanks[ranks[i]]);
            sameSuit = Math.max(sameSuit, ++presentSuits[suits[i] - 'a']);
        }
        String bestCard = "High Card";
        if (sameSuit == 5) {
            bestCard = "Flush";
        } else if (sameRank >= 3) {
            bestCard = "Three of a Kind";
        } else if (sameRank == 2) {
            bestCard = "Pair";
        }
        return bestCard;
    }
}
