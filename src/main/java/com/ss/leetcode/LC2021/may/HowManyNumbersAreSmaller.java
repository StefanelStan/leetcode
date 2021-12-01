package com.ss.leetcode.LC2021.may;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class HowManyNumbersAreSmaller {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];

        Map<Integer, Pair> numbers = countOccurrences(nums);
        for (int i = 0; i < nums.length; i++) {
            result[i] = numbers.get(nums[i]).smallerOccurrences;
        }

        return result;
    }

    private Map<Integer, Pair> countOccurrences(int[] nums) {
        Map<Integer, Pair> numbers = new TreeMap<>();
        for (int num : nums) {
            Pair p = numbers.get(num);
            if (p == null) {
                p = new Pair();
                p.occurrences++;
                numbers.put(num, p);
            } else {
                p.occurrences++;
            }
        }

        Iterator<Map.Entry<Integer, Pair>> it = numbers.entrySet().iterator();
        int totalOccurrences;
        Pair p = it.next().getValue();
        totalOccurrences = p.occurrences;
        p.smallerOccurrences = 0;

        while (it.hasNext()) {
            p = it.next().getValue();
            p.smallerOccurrences = totalOccurrences;
            totalOccurrences += p.occurrences;
        }

        return numbers;
    }

    private static class Pair {
        private int occurrences;
        private int smallerOccurrences;
    }
}
