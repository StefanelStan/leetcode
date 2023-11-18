package com.ss.leetcode.LC2023.november;

import java.util.Arrays;

public class FreedomTrail {
    // https://leetcode.com/problems/freedom-trail
    /** Algorithm:
        1. Look at the problem as a cost of travelling from one letter/index to another.
            Ignore the cost of "pushing a button". The cost of pushing button is "key.length()" anyway. You add this at the end
        2. Looking where you sit, you have 2 options:
            A. If your current position is the one that you are on key, then your cost is 0 (you don't need to travel to find the key char)
            B. If your current position on ring is NOT what you look for on the  key, then you need to travel LEFT and RIGHT.
            You don't know  if travelling LEFT would lead you closer to the remaining letters OR should you travel right.
        3.  In case of B, find the closest left/right index/position on ring that matches the index on key, pay the PRICE and travel to next position.
            The best cost of your current position is min(leftCost + jumpOnLeftPosition, rightCost + jumpOnRightPosition)
        4. Use a cost[key.length()][ring.length()] to cache the cost.
     */
    public int findRotateSteps(String ring, String key) {
        int[][] minSteps = new int[key.length()][ring.length()];
        for (int[] step : minSteps) {
            Arrays.fill(step, 100_000);
        }
        return rotateDial(ring.toCharArray(), 0, key.toCharArray(), 0, minSteps) + key.length();
    }

    private int rotateDial(char[] ringChars, int ringIndex, char[] keyChars, int keyIndex, int[][] minSteps) {
        if (keyIndex == keyChars.length) {
            return 0;
        }
        if (minSteps[keyIndex][ringIndex] == 100_000) {
            if (ringChars[ringIndex] == keyChars[keyIndex]) {
                minSteps[keyIndex][ringIndex] = rotateDial(ringChars, ringIndex, keyChars, keyIndex + 1, minSteps);
            } else {
                int[] travelLeft = findInDirection(ringChars, ringIndex, -1, keyChars[keyIndex]);
                int[] travelRight = findInDirection(ringChars, ringIndex, 1, keyChars[keyIndex]);
                int minCost = Math.min(travelLeft[1] + rotateDial(ringChars, travelLeft[0], keyChars, keyIndex + 1, minSteps),
                    travelRight[1] + rotateDial(ringChars, travelRight[0], keyChars, keyIndex + 1, minSteps));
                minSteps[keyIndex][ringIndex] = minCost;
            }
        }
        return minSteps[keyIndex][ringIndex];
    }

    private int[] findInDirection(char[] ringChars, int index, int direction, char target) {
        int cost = 0;
        while(ringChars[index] != target) {
            cost++;
            index = index + direction < 0
                ? ringChars.length - 1
                : index + direction == ringChars.length ? 0 : index + direction;
        }
        return new int[]{index, cost};
    }
}
