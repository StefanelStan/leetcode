package com.ss.leetcode.LC2024.august;

import java.util.List;

public class MaximumDistanceInArrays {
    // https://leetcode.com/problems/maximum-distance-in-arrays
    /** Algorithm
        1. Traverse the array and keep track of minSoFar and maxSoFar.
        2. First, your minSoFar/maxSoFar will be first and last element for first array.
        3. Starting with second array, determine set maxDifference to be the maxbetween maxDifference and max(maxSoFar - firstElementCurrentArray, lastElement - minSoFar).
        4. Adjust minSoFar, maxSoFar to the current first and last element.
     */
    public int maxDistance(List<List<Integer>> arrays) {
        int maxDistance = 0;
        int min = arrays.getFirst().getFirst(), max = arrays.getFirst().getLast();
        int first, last;
        for (int i = 1; i < arrays.size(); i++) {
            first = arrays.get(i).getFirst();
            last = arrays.get(i).getLast();
            maxDistance = Math.max(maxDistance, Math.max(last - min, max - first));
            min = Math.min(min, first);
            max = Math.max(last, max);
        }
        return maxDistance;
    }
}
