package com.ss.leetcode.september;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FindOriginalArrayFromDoubledArray {

    public int[] findOriginalArray(int[] changed) {
        int[] counts = new int[100_001];
        List<Integer> original = new ArrayList<>(changed.length / 2);
        for (int nr : changed) {
            counts[nr]++;
        }
        if (counts[0] % 2 == 1) {
            return new int[0];
        }
        parseAndVerify(counts, original);
        return original.stream().mapToInt(Integer::intValue).toArray();
    }

    private void parseAndVerify(int[] counts, List<Integer> original) {
        if (counts[0] > 0) {
            for (int i = 0; i < counts[0] / 2; i++) {
                original.add(0);
            }
        }
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] != 0) {
                if (i * 2 >= counts.length || counts[i * 2] < counts[i]) {
                    original.clear();
                    return;
                } else {
                    for (int j = 0; j < counts[i]; j++) {
                        original.add(i);
                    }
                    counts[i * 2] -= counts[i];
                    counts[i] = 0;
                }
            }
        }
    }

    /**
     public int[] findOriginalArray(int[] changed) {
     List<Integer> original = new ArrayList<>(changed.length/2);

     final TreeMap<Integer, Integer> nums = new TreeMap<>();
     // add the numbers and their cardinal into a tree map
     for (int num : changed) {
     nums.merge(num, 1, Integer::sum);
     }

     // return instantly if odd number of zerors
     if (nums.get(0) != null && nums.get(0) % 2 != 0) {
     return new int[0];
     }

     parseAndVerify(nums, original);
     return original.stream().mapToInt(Integer::intValue).toArray();
     }

     private void parseAndVerify(Map<Integer, Integer> numbers, List<Integer> original) {
     boolean stillHasNumbers = true;
     // iterate over the map in order and deduct the cardinal of each number with its double
     while (stillHasNumbers) {
     stillHasNumbers = false;
     for (Map.Entry<Integer, Integer> entry : numbers.entrySet()) {
     // most of the pairs will have nr -> 0, double -> 0 after deducting their number of appearance
     if (entry.getValue() != 0) {
     int currentKey = entry.getKey();
     int currentValue = entry.getValue();
     int doubleKey = 2 * currentKey;
     // if there is no double or there are fewer doubles than the number
     if (numbers.get(doubleKey) == null || numbers.get(doubleKey) < currentValue) {
     original.clear();
     return;
     } else {
     if (currentKey == 0) {
     for (int i = 0; i < currentValue/2; i++) {
     original.add(currentKey);
     }
     numbers.merge(currentKey, -(currentValue/2), Integer::sum);
     numbers.merge(doubleKey, -(currentValue/2), Integer::sum);
     } else {
     for (int i = 0; i < currentValue; i++) {
     original.add(currentKey);
     }
     numbers.merge(currentKey, -currentValue, Integer::sum);
     numbers.merge(doubleKey, -currentValue, Integer::sum);
     }
     stillHasNumbers = true;
     // as we break, the loop starts from beginning; this way we avoid the situation of reaching
     // the end and not rechecking for cases of 2 4 4 8. checking 8 will fail as there is no 16
     break;
     }
     }
     }
     }
     }
     */
}
