package com.ss.leetcode.LC2020.december;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurances {
    // https://leetcode.com/problems/unique-number-of-occurrences/
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> bucket = new HashMap<>();
        for(int value : arr) {
            bucket.merge(value, 1, Integer::sum);
        }

        Set<Integer> occurances = new HashSet<>();
        for(Integer occurance : bucket.values()) {
            if(!occurances.add(occurance)) {
                return false;
            }
        }
        return true;
    }
}
