package com.ss.leetcode.LC2024.november;

import java.util.HashMap;
import java.util.Map;

public class MaximumEqualFrequency {
    // https://leetcode.com/problems/maximum-equal-frequency
    public int maxEqualFreq(int[] nums) {
        int maxPrefix = 1;
        Map<Integer, Integer> mapOfCount = new HashMap<>();
        int[] numCount = new int[100_001];
        for (int i = 0; i < nums.length; i++) {
            trackNumber(nums[i], numCount, mapOfCount);
            if (isValidPrefix(mapOfCount)) {
                maxPrefix = 1 + i;
            }
        }
        return maxPrefix;
    }

    private void trackNumber(int num, int[] numCount, Map<Integer, Integer> mapOfCount) {
        numCount[num]++;
        if (numCount[num] > 1) {
            Integer oldCount = mapOfCount.merge(numCount[num] -1, -1, Integer::sum);
            if (oldCount == 0) {
                mapOfCount.remove(numCount[num] -1);
            }
        }
        mapOfCount.merge(numCount[num], 1, Integer::sum);
    }

    private boolean isValidPrefix(Map<Integer, Integer> mapOfCount) {
        if (mapOfCount.size() > 2) {
            return false;
        } else if (mapOfCount.size() == 1) {
            Map.Entry<Integer, Integer> singleEntry = mapOfCount.entrySet().iterator().next();
            return singleEntry.getValue() == 1 || singleEntry.getKey() == 1;
        }
        Integer countOfOne = mapOfCount.get(1);
        if (countOfOne != null && countOfOne == 1) {
            return true;
        }
        Map.Entry<Integer, Integer> firstEntry = null;
        Map.Entry<Integer, Integer> secondEntry = null;
        for (Map.Entry<Integer, Integer> entry : mapOfCount.entrySet()) {
            if (firstEntry == null) {
                firstEntry = entry;
            } else {
                secondEntry = entry;
            }
        }
        boolean answer = false;
        if (firstEntry.getValue() == 1) {
            answer = matchByDecreasing(secondEntry, firstEntry);
        } if (!answer && secondEntry.getValue() == 1) {
            answer = matchByDecreasing(firstEntry, secondEntry);
        }
        return answer;
    }

    private boolean matchByDecreasing(Map.Entry<Integer, Integer> others, Map.Entry<Integer, Integer> oneEntry) {
        return others.getKey() == oneEntry.getKey() - 1;
    }
}
