package com.ss.leetcode.february;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PairsOfSongsWithTotalDurations {
    // https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> timesMap = new HashMap<>();
        Set<Integer> usedKeys = new HashSet<>();
        for(int t : time) {
            timesMap.merge(t % 60, 1, Integer::sum);
        }

        int numberOfPairs = 0;
        int oppositeKey = 0;

        for (Map.Entry<Integer, Integer> entry: timesMap.entrySet()) {
            if ((entry.getKey() == 0 || entry.getKey() == 30) && !usedKeys.contains(entry.getKey())) {
                numberOfPairs += getCombinationsOfNBy2(entry.getValue());
                usedKeys.add(entry.getKey());
            } else if(!usedKeys.contains(entry.getKey())){
                oppositeKey = 60 - entry.getKey();
                if (timesMap.containsKey(oppositeKey)) {
                    numberOfPairs += (entry.getValue()) * timesMap.get(oppositeKey);
                    usedKeys.add(entry.getKey());
                    usedKeys.add(oppositeKey);
                }
            }
        }
        return numberOfPairs;

    }

    private int getCombinationsOfNBy2(int n) {
        if (n == 1) return 0;
        return ((n-1) * n) / 2;
    }
}
