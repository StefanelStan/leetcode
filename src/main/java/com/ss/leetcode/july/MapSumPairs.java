package com.ss.leetcode.july;

import java.util.HashMap;
import java.util.Map;

public class MapSumPairs {
    // https://leetcode.com/problems/map-sum-pairs/
    // interesting to check solution
    /**
     * Initialize your data structure here.
     */
    // public MapSum() {
    private final Map<String, Integer> pairs;

    public MapSumPairs() {
        pairs = new HashMap<>();
    }

    public void insert(String key, int val) {
        pairs.put(key, val);
    }

    public int sum(String prefix) {
        int sum = 0;
        for (Map.Entry<String, Integer> entry : pairs.entrySet()) {
            if (entry.getKey().startsWith(prefix)) {
                sum += entry.getValue();
            }
        }
        return sum;
    }
}
