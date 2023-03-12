package com.ss.leetcode.LC2023.march;

import java.util.HashMap;
import java.util.Map;

public class LongestWellPerformingInterval {
    // https://leetcode.com/problems/longest-well-performing-interval
    /** Algorithm
        1. Mark a tiring day with 1 and a non-tiring day with 0.
        2. Iterate over days and keep track of T and NO (tiring - nonTiring count).
             If the day is tiring, increment T else increment NT- > prefix sum
            Look at the difference between T and NT. It T > NT, set the index as maximum interval
        3. For each hour, imagine there is an arrays[] of difference between T and NT (T - NT)
            EG: 5,   5,   9,   9
            T:  0    0    1    2
            NT: 1    2    2    2
            DIFF:-1   -2    -1   0
            (T-NT)
        4. For each step, see if a previous difference matching currentDiff -1 exists.
            EG:i = 0; diff = -1. Is there a previous diff that matches -1-1 (-2). No.
            i = 2 diff = -1. Is there a previous diff that matches -2? Yes. At index 1= > segment length.
                currentIndex - (diffIndex) => 2 - 1= 1.
            i = 3 diff = 0. Is there a previous diff matching 0 -1 ?(-1). Yes. at index 0.
                segment length = 3 - 0 = 3.
        5. Bases on #4, traverse each hour and calculate the diff between cumulative T and NT.
            Store the diff and its index in a hashmap ONLY IF IT DOES NOT EXIST already.
            If it exists, you must keep it because it gives you the longest available interval. (most left prefix sum - difference)
        6. Traverse each hour, calculate the diff, check the map for existing diff -1 and insert in map (it not existing).
     */
    public int longestWPI(int[] hours) {
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        int tiringDays = 0, nonTiringDays = 0;
        int longestInterval = 0;
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8) {
                tiringDays++;
            } else {
                nonTiringDays++;
            }
            if (tiringDays > nonTiringDays) {
                longestInterval = Math.max(longestInterval, i + 1);
            }
            int diff = (tiringDays - nonTiringDays);
            Integer existing = sumToIndex.get(diff -1);
            if (existing != null) {
                longestInterval = Math.max(longestInterval, i - existing);
            }
            sumToIndex.putIfAbsent(diff, i);
        }
        return longestInterval;
    }
}
