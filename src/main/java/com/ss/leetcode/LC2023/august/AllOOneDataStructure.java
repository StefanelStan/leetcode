package com.ss.leetcode.LC2023.august;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class AllOOneDataStructure {
    // https://leetcode.com/problems/all-oone-data-structure
    /** Algorithm
        1. Use two maps that will store:
            - stringCount<String, Integer> the count of each string
            - bucketMap<Integer, Set<String>> stores the string grouped by count
        2. Increment function
            - increment the count of that string inside stringCount
            - remove the string from the bucket of old count
            - add the string to the bucket of new count
        3. Decrement
            - decrement the count of that string from stringCount
            - remove the string from the bucket of old count
            - add the string to the bucket of new count
        4. Min/Max : return one value from the firstEntry/lastEntry set of bucketMap
     */
    private final Map<String, Integer> stringCount;
    private final TreeMap<Integer, Set<String>> bucketMap;
    public AllOOneDataStructure() {
        stringCount = new HashMap<>();
        bucketMap = new TreeMap<>();
    }

    public void inc(String key) {
        int newCount = stringCount.merge(key, 1, Integer::sum);
        removeFromOldBucket(key, newCount - 1);
        addToNewBucket(key, newCount);
    }

    public void dec(String key) {
        int newCount = stringCount.merge(key, -1, Integer::sum);
        if (newCount == 0) {
            stringCount.remove(key);
        }
        removeFromOldBucket(key, newCount + 1);
        addToNewBucket(key, newCount);
    }

    private void removeFromOldBucket(String key, int bucketKey) {
        if (bucketKey > 0) {
            Set<String> oldBucket = bucketMap.get(bucketKey);
            if (oldBucket.size() == 1) {
                oldBucket.clear();
                bucketMap.remove(bucketKey);
            } else {
                oldBucket.remove(key);
            }
        }
    }

    private void addToNewBucket(String key, int bucketKey) {
        if (bucketKey > 0) {
            bucketMap.computeIfAbsent(bucketKey, k -> new HashSet<>()).add(key);
        }
    }

    public String getMaxKey() {
        return bucketMap.isEmpty() ? "" : bucketMap.lastEntry().getValue().iterator().next();
    }

    public String getMinKey() {
        return bucketMap.isEmpty() ? "" : bucketMap.firstEntry().getValue().iterator().next();
    }
}
