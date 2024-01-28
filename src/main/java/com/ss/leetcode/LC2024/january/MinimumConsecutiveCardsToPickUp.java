package com.ss.leetcode.LC2024.january;

public class MinimumConsecutiveCardsToPickUp {
    // https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up
    /** Algorithm
        1. Declare an Integer[1_000_001] lastPos; this will hold the last position of the given card
            - You can also use a Map<Integer, Integer>
        2. For each card, if lastPos exists for current card, determine the diff between current index and last index of the card.
            - Use this to compare against overall minPickup
            - Set the lastPos to current index for current card
        3. If no minPickup has been detected (minPickup == Integer.MAX_VALUE), return -1, else minPickup.
     */
    public int minimumCardPickup(int[] cards) {
        Integer[] lastPos = new Integer[1_000_001]; // or hashmap
        int minPickup = Integer.MAX_VALUE;
        for (int i = 0; i < cards.length && minPickup > 2; i++) {
            if (lastPos[cards[i]] != null) {
                minPickup = Math.min(1 + i - lastPos[cards[i]], minPickup);
            }
            lastPos[cards[i]] = i;
        }
        return minPickup == Integer.MAX_VALUE ? -1 : minPickup;
    }
}
