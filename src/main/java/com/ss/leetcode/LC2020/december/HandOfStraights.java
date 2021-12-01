package com.ss.leetcode.LC2020.december;

import java.util.Arrays;

public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) {
            return false;
        }
        Arrays.sort(hand);
        boolean[] usedCards = new boolean[hand.length];
        int groupSize = 1;
        for (int i = 0; i <= hand.length - W; i++) {

            if (!usedCards[i]) {
                for (int j = i + 1; j < hand.length; j++) {
                    if(!usedCards[j] && hand[i] + groupSize == hand[j]) {
                        usedCards[j] = true;
                        groupSize++;
                    }
                    if(groupSize >= W) {
                        usedCards[i] = true;
                        break;
                    }
                }
                if(groupSize < W) {
                    return false;
                }
                groupSize = 1;
            }
        }
        return true;
        // https://leetcode.com/problems/hand-of-straights/
    }
}
