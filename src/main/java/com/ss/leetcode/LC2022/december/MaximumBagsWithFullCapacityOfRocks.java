package com.ss.leetcode.LC2022.december;

import java.util.Arrays;

public class MaximumBagsWithFullCapacityOfRocks {
    // https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks
    /** Algorithm
         1. Looking at the two arrays capacity[2,3,4,7] and rocks[1,2,4,4] we can see that, taking one by one,
            we would need [2-1, 3-2, 4-4, 7-4] additional rocks to make fill every bag.
         2. Thus, [1,1,0,3] is the list of required additional rocks, but we only have 2 additional rocks.
         3. In order to fill the bags in the most efficient way, we need to start with the almost full bags:
            those that need 0,1,2 more rocks.
         4. Sort this resulting array: -> [0,1,1,3].
         5. From index 0, start deducting the number of required Additional rocks from the given additional rocks.
             index 0: 2 - 0 = 2. We filled this bad and we have 2 additional rocks
             index 1: 2-1 = 1. We filled the 2nd bag and we remain with 1 additional rock
             index 2: 1-1 = 0. We fill this 3rd bag and we remain with 0 additional rock
             index 3: 0 - 3 = -3. We cannot fill this bag.
             So we can only fill 3 bags.
         6. Stop when you run out of additional rocks.
     */
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] requiredRocks = new int[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            requiredRocks[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(requiredRocks);
        int bags = 0;
        while(bags < capacity.length && additionalRocks >= requiredRocks[bags]) {
            additionalRocks -= requiredRocks[bags];
            bags++;
        }
        return bags;
    }
}
