package com.ss.leetcode.LC2025.january;

public class WaterBottlesII {
    // https://leetcode.com/problems/water-bottles-ii
    /** Algorithm
        1. Inside a while loop, while full + empty bottles >= numExchange
            - drink all the full bottles, incrementing emptyBottles and resetting full bottles.
            - if you have more empty bottles > numExchange, exchange numBottles empty bottles for 1 full bottle.
        2. Stop when you don't have enough bottles.
     */
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int drankBottles = 0, fullBottles = numBottles, emptyBottles = 0;
        while (fullBottles + emptyBottles >= numExchange) {
            drankBottles += fullBottles;
            emptyBottles += fullBottles;
            fullBottles = 0;
            if (emptyBottles >= numExchange) {
                fullBottles++;
                emptyBottles -= numExchange;
                numExchange++;
            }
        }
        return drankBottles + fullBottles;
    }
}
