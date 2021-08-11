package com.ss.leetcode.august;

import java.util.Map;
import java.util.TreeMap;

public class ArrayOfDoubledPairs {
    // https://leetcode.com/problems/array-of-doubled-pairs/
    public boolean canReorderDoubled(int[] arr) {
        final TreeMap<Integer, Integer> nums = new TreeMap<>();
        // add the numbers and their cardinal into a tree map
        for (int num : arr) {
            nums.merge(num, 1, Integer::sum);
        }

        // return instantly if odd number of zerors
        if (nums.get(0) != null && nums.get(0) % 2 != 0) {
            return false;
        }

        // for each subview of map (positives, negatives, navigate in order and check for doubles
        Map<Integer, Integer> positives = nums.tailMap(0, false);
        if (verifyDoubles(positives)) {
            // negatives need to be reversed (-2, -4 etc to apply the same function as for positives 2 4)
            Map<Integer, Integer> negatives = nums.headMap(0, false).descendingMap();
            return verifyDoubles(negatives);
        } else {
            return false;
        }
    }

    private boolean verifyDoubles(Map<Integer, Integer> numbers) {
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
                        return false;
                    } else {
                        numbers.merge(currentKey, -currentValue, Integer::sum);
                        numbers.merge(doubleKey, -currentValue, Integer::sum);
                        stillHasNumbers = true;
                        // as we break, the loop starts from beginning; this way we avoid the situation of reaching
                        // the end and not rechecking for cases of 2 4 4 8. checking 8 will fail as there is no 16
                        break;
                    }
                }
            }
        }
        return true;
    }
}
