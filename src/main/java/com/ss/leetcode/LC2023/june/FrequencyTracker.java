package com.ss.leetcode.LC2023.june;

import java.util.HashMap;
import java.util.Map;

public class FrequencyTracker {
    // https://leetcode.com/problems/frequency-tracker
    /** Algorithm
        1. Use 2 maps to store the count of each num. The second map will keep track of how many count groups you have.
        2. When adding a number, increase the count from countMap.
            Also, the group count has to increase.
            EG: supposing you have 3 of 7s. countMap: 7 -> 3. Frequency Map : 3 -> 1.
            Adding another 7: 4 of 7s: countMap 7 -> 4. Frequncy Map: 4 -> 1.
            Also, you need to decrement the old frequency of 7. as you no longer 3 7s but 4 7s
        3. Same principle for deleting. Check if num exisists in countMap. If yes, decrease its count, decrease its old
            count frequencyMap  and increase the frequency map of the new count.
            EG: 4 of 7s: countMap: 7 -> 4. Freq Map: 4 ->1
            Deleting 1 seven: countMap -> 7 -> 3. Freq map: 3 -> 1, 4 -> 0.
     */
    private final Map<Integer, Integer> numCount;
    private final Map<Integer, Integer> frequencies;
    public FrequencyTracker() {
        numCount = new HashMap<>();
        frequencies = new HashMap<>();
    }

    public void add(int number) {
        int newCount = numCount.merge(number, 1, Integer::sum);
        frequencies.merge(newCount, 1, Integer::sum);
        if (newCount > 1) {
            frequencies.merge(newCount - 1, -1, Integer::sum);
        }
    }

    public void deleteOne(int number) {
        Integer currentVal = numCount.get(number);
        if (currentVal != null && currentVal > 0) {
            int newCount = numCount.merge(number, -1, Integer::sum);
            frequencies.merge(newCount, 1, Integer::sum);
            frequencies.merge(newCount + 1, -1, Integer::sum);
        }
    }

    public boolean hasFrequency(int frequency) {
        Integer existing = frequencies.get(frequency);
        return existing != null && existing > 0;
    }
}
