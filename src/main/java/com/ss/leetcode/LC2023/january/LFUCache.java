package com.ss.leetcode.LC2023.january;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;

public class LFUCache {
    // https://leetcode.com/problems/lfu-cache
    /** Algorithm
        1. Define a class CachedObject that will retain key, value and counter.
        2. For fast access, define a CachedObject[100_001] keys that will tell in O(1) (faster than map!)
            if a key is in the set.
            This can be used in get(key) or put (if key exists, just update the value and counter).
            When removing an object/cached object, also remember to delete its mapped key from keys[].
            ! Pay attention to capacity 0 edge case.
        3. A good data structure (out of the box) to adopt "least recently used" mechanism is a
            LinkedHashSet<Integer>. It acts like a queue (add at the end, gives access to first element),
            preserves the ORDER of elements and can remove from any position (as it's a hashset).
            Thus, the old elements will be at the beginning and the new ones at the end.
            When removing the oldest (head), just use iterator.next.remove();
        4. Elements can have the same counter (put1, put2, get1, get2), so we can group them.
            counter2 : 1,2
            counter3: 4,5
            We can see a TreeMap<Integer, LinkedHashMap<Integer>> is a natural choice.
            Counter -> Elements_In_Age_Order (old to new).
            Thus, we have access to the whole group of elements by counter, and each group is sorted by age.
        5. The treemap gives access to the minElement (least counter) and its value (set) access to elements of ordered by age.
            Thus, when doing a get() or update(), we simply move that CAchedObject from the TreeMap bucket to bucket+1.
     */
    private final int maxCapacity;
    private int currentSize;
    private CachedObject[] keys;
    private TreeMap<Integer, LinkedHashSet<Integer>> countStacks;
    public LFUCache(int capacity) {
        this.maxCapacity = capacity;
        keys = new CachedObject[capacity == 0 ? 1 :100_001];
        countStacks = new TreeMap<>();
    }

    public int get(int key) {
        if (keys[key] == null) {
            return -1;
        } else {
            CachedObject obj = keys[key];
            incrementCounter(obj);
            return obj.value;
        }
    }

    private void incrementCounter(CachedObject obj) {
        LinkedHashSet<Integer> stack = countStacks.get(obj.counter);
        stack.remove(obj.key);
        if (stack.isEmpty()) {
            countStacks.remove(obj.counter);
        }
        obj.counter++;
        countStacks.computeIfAbsent(obj.counter, k -> new LinkedHashSet<>()).add(obj.key);
    }

    public void put(int key, int value) {
        if (maxCapacity == 0) {
            return;
        }
        if (keys[key] != null) {
            keys[key].value = value;
            incrementCounter(keys[key]);
        } else {
            // two cases: full or not full;
            if (currentSize == maxCapacity) {
                evict();
            }
            insert(key, value);
        }
    }

    private void evict() {
        // get the bucket with the min Counter
        // remove the first element (oldest)
        // also, delete it from keys[]
        Map.Entry<Integer, LinkedHashSet<Integer>> firstEntry = countStacks.firstEntry();
        Iterator<Integer> it = firstEntry.getValue().iterator();
        Integer leastUsed = it.next();
        it.remove();
        if(firstEntry.getValue().isEmpty()) {
            countStacks.remove(firstEntry.getKey());
        }
        keys[leastUsed] = null;
        currentSize--;
    }

    private void insert(int key, int value) {
        // put has assured we only enter here when the key does not exist and there is capacity
        CachedObject newObject = new CachedObject(key, value);
        keys[key] = newObject;
        countStacks.computeIfAbsent(newObject.counter, k -> new LinkedHashSet<>()).add(key);
        currentSize++;
    }

    private static class CachedObject {
        int key;
        int value;
        int counter;
        public CachedObject(int key, int value) {
            this.key = key;
            this.value = value;
            this.counter = 1;
        }
    }
}
