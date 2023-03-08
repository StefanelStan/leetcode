package com.ss.leetcode.LC2023.march;

public class KokoEatingBananas {
    // https://leetcode.com/problems/koko-eating-bananas
    /** Algorithm
        1. The optimum speed is somewhere between 1 and maxPile
        2. Apply binary search and see if koko can eat ALL piles with low + (high - low) /2 speed.
        3. If yes, decrease pivot, else increase pivot.
        4. Return low.
     */
    public int minEatingSpeed(int[] piles, int h) {
        int max = -1;
        for (int pile : piles) {
            max = Math.max(pile, max);
        }
        int pivot, min = 1;
        while (min <= max) {
            pivot = min + (max - min) / 2;
            if (canEatAllBananasInHours(piles, pivot, h)) {
                max = pivot - 1 ;
            } else {
                min = pivot + 1;
            }
        }
        return min;
    }

    private boolean canEatAllBananasInHours(int[] piles, int speed, int hours) {
        long hoursTaken = 0;
        for (int pile : piles) {
            hoursTaken += (pile / speed);
            if (pile % speed != 0) {
                hoursTaken++;
            }
        }
        return hoursTaken <= hours;
    }
}
