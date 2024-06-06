package com.ss.leetcode.LC2020.december;

import java.util.Arrays;

public class HandOfStraights {
    // https://leetcode.com/problems/hand-of-straights/
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        if (groupSize == 1) {
            return true;
        }
        int[][] groups = getGroups(hand, groupSize);
        return groups != null && canBeGrouped(groups, groupSize);
    }

    private boolean canBeGrouped(int[][] groups, int groupSize) {
        int groupHead = 0;
        while (groupHead != -1 && groupHead < groups.length) {
            groupHead = findGroups(groups, groupHead, groupSize);
        }
        return groupHead != -1;
    }

    private int findGroups(int[][] groups, int start, int groupSize) {
        if (start + groupSize - 1 >= groups.length || 1 + groups[start + groupSize - 1][0] - groups[start][0] != groupSize) {
            return -1;
        }
        int toDelete = groups[start][1], nextHead = -1;
        for (int i = start; i < start + groupSize; i++) {
            groups[i][1] -= toDelete;
            if (groups[i][1] > 0 && nextHead == -1) {
                nextHead = i;
            } else if (groups[i][1] < 0) {
                return -1;
            }
        }
        return nextHead == -1 ? start + groupSize : nextHead;
    }

    private int[][] getGroups(int[] hand, int groupSize) {
        Arrays.sort(hand);
        int[][] groups = new int[hand.length][2];
        groups[0] = new int[]{hand[0], 1};
        int index = 0;
        for (int i = 1; i < hand.length; i++) {
            if (hand[i] != hand[i-1]) {
                groups[++index][0] = hand[i];
            }
            groups[index][1]++;
        }
        if (index + 1 < groupSize) {
            return null;
        }
        return Arrays.copyOf(groups, index + 1);
    }



    public boolean isNStraightHand2(int[] hand, int W) {
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

    }
}
