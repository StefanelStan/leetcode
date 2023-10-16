package com.ss.leetcode.LC2023.october;

import java.util.HashMap;
import java.util.Map;

public class NumberOfWaysToStayInTheSamePlaceAfterSomeSteps {
    // https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps
    // OPTIMIZED
    public int numWays(int steps, int arrLen) {
        Integer[][] ways = new Integer[Math.min(steps + 1, arrLen)][steps+1];
        return calculateWays(0, steps, arrLen, ways);
    }

    private int calculateWays(int index, int remainingSteps, int arrLen, Integer[][] ways) {
        if (index < 0 || index >= arrLen || index > remainingSteps) {
            return 0;
        }
        if (remainingSteps == 0) {
            return index == 0 ? 1 : 0;
        }
        if (ways[index][remainingSteps] == null) {
            int sum = calculateWays(index - 1, remainingSteps - 1, arrLen, ways) + calculateWays(index + 1, remainingSteps - 1, arrLen, ways);
            sum = (sum % 1_000_000_007 + calculateWays(index, remainingSteps-1, arrLen, ways)) % 1_000_000_007;
            ways[index][remainingSteps] = sum;
        }
        return ways[index][remainingSteps];
    }

    /** Algorithm
        1. Use a Map<Integer, Integer>[] to cache the number of ways you can hit 0 WHEN your index is 0 AND steps are 0.
        2. Use a recursive function that
            - returns 0 IF your index is outside bounds
            - returns 0 if  remaining steps are 0 but your current index is not 0
            - returns 1 if your remaining steps are 0 AND your index is 0
        3. The recursive function will take your current index and remainingSteps and will try to check cache for precumputed result
            - If not there, add the number of steps you can get from checking left (index -1, steps -1), currentPosition (index, steps-1) and right (index +1, steps -1).
            - Modulo the sum and cache it.
        4. Return cache[0].get(steps).
     */
    public int numWays2(int steps, int arrLen) {
        Map<Integer, Integer>[] ways = new Map[Math.min(steps, arrLen)];
        return calculateWays(0, steps, arrLen, ways);
    }

    private int calculateWays(int index, int remainingSteps, int arrLen, Map<Integer, Integer>[] ways) {
        if (index < 0 || index >= arrLen || index > remainingSteps) {
            return 0;
        }
        if (remainingSteps == 0) {
            return index == 0 ? 1 : 0;
        }
        if (ways[index] == null) {
            ways[index] = new HashMap<>();
        }
        Integer sum = ways[index].get(remainingSteps);
        if (sum == null) {
            sum = calculateWays(index - 1, remainingSteps - 1, arrLen, ways) + calculateWays(index + 1, remainingSteps - 1, arrLen, ways);
            sum = (sum % 1_000_000_007 + calculateWays(index, remainingSteps-1, arrLen, ways)) % 1_000_000_007;
            ways[index].put(remainingSteps, sum);
        }
        return sum;
    }
}
