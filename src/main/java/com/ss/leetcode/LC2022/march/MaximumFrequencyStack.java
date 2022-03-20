package com.ss.leetcode.LC2022.march;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MaximumFrequencyStack {
    // https://leetcode.com/problems/maximum-frequency-stack/
    Map<Integer, Integer> freqCount;
    Map<Integer, Deque<Integer>> freqMap;
    int highestRank = 0;
    public MaximumFrequencyStack() {
        freqCount = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public void push(int val) {
        int rank = freqCount.merge(val, 1, Integer::sum);
        freqMap.computeIfAbsent(rank, k -> new LinkedList<>()).addLast(val);
        highestRank = Math.max(rank, highestRank);
    }

    public int pop() {
        Deque<Integer> items = freqMap.get(highestRank);
        int lastValue = items.removeLast();
        freqCount.merge(lastValue, -1, Integer::sum);
        if (items.isEmpty()) {
            freqMap.remove(highestRank);
            highestRank--;
        }
        return lastValue;
    }
}
