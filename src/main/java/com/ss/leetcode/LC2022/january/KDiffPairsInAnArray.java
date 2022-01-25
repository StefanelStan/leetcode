package com.ss.leetcode.LC2022.january;

import java.util.HashMap;
import java.util.Map;

public class KDiffPairsInAnArray {
    // https://leetcode.com/problems/k-diff-pairs-in-an-array/
    public int findPairs(int[] nums, int k) {
        Map<Integer,Integer> numbers = new HashMap<>();
        for (int num : nums) {
            numbers.merge(num, 1, Integer::sum);
        }
        int pairs = 0;
        Integer appearances;
        for (Map.Entry<Integer, Integer> entry : numbers.entrySet()) {
            appearances = numbers.get(entry.getKey() + k);
            if (k == 0 && appearances != null && appearances > 1) {
                pairs++;
                continue;
            }
            if (k != 0 && appearances != null) {
                pairs++;
            }
        }
        return pairs;
    }
}
