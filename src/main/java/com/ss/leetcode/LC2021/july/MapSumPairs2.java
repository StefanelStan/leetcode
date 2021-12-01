package com.ss.leetcode.LC2021.july;

import java.util.HashMap;
import java.util.Map;

public class MapSumPairs2 {
    // https://leetcode.com/problems/map-sum-pairs/
    // interesting to check solution
    /**
     * Initialize your data structure here.
     */
    // public MapSum() {
    private final Map<String, Integer> wholeStrings;
    private final Map<String, Integer> partialStrings;

    public MapSumPairs2() {
        wholeStrings = new HashMap<>();
        partialStrings = new HashMap<>();
    }

    public void insert(String key, int val) {
        // if value exists, get it and use it to append all other partial substring's value
        int score = val - wholeStrings.getOrDefault(key, 0);
        String partial = "";
        for(int i = 0; i < key.length(); i++) {
            partial += key.charAt(i);
            partialStrings.put(partial, partialStrings.getOrDefault(partial, 0) + score);
        }
        wholeStrings.put(key, val);
    }

    public int sum(String prefix) {
        return partialStrings.getOrDefault(prefix, 0);
    }
}
