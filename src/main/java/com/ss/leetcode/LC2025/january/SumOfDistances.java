package com.ss.leetcode.LC2025.january;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumOfDistances {
    // https://leetcode.com/problems/sum-of-distances
    /** Algorithm
        1. Use a Map<Integer,List<Integer>> to map each number to its indices. This way, the indices are already sorted
        2. Loop over all entry - value (list) in the map
            - if the list size is 1, set 0 to the answer[] of that index.
            - else, you can determine the sum of from each index to the other indices by using a prefixSum and a totalSum
                deducting the i * indidex[i].
            - EG:  indices = [2,4,7,8,11,14]; totalSum = 46
            - for indices[2] - on the left side we have a prefixsum of 6 and so: 2 x 7 - 6 = 8
            - the the right we have a sum of 33 - 3 x 7 = 18.
     */
    public long[] distance(int[] nums) {
        Map<Integer, List<Integer>> grouped = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            grouped.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        long[] distances = new long[nums.length];
        for (List<Integer> indices : grouped.values()) {
            computeDistances(indices, distances);
        }
        return distances;
    }

    private void computeDistances(List<Integer> indices, long[] distances) {
        if (indices.size() == 1) {
            distances[indices.getFirst()] = 0;
        } else {
            long prefixSum = 0, totalSum = 0;
            long onLeft, onRight;
            for (int index : indices) {
                totalSum += index;
            }
            for (int i = 0; i < indices.size(); i++) {
                onLeft = i == 0 ? 0 : (long)i * indices.get(i) - prefixSum;
                prefixSum += indices.get(i);
                onRight = (i == indices.size() - 1 ? 0 : (totalSum - prefixSum) - (long)indices.get(i) * (indices.size() - (1 +i)));
                distances[indices.get(i)] = onLeft + onRight;
            }
        }
    }
}
