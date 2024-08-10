package com.ss.leetcode.LC2024.august;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfMaximumBitwiseORSubsets {
    // https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets
    /** Algorithm
        1. Traverse nums and get the OR of all numbers
        2. Use a DP[] cache (Map<Integer, Integer>) to cache the number of subsets the num[i] can build the maxOR given a certain rolling OR.
        3. For a current index (nums[i])
            - given a received OR value, if the computation has been done, return it (map.get(currentOr)), else build it by adding these 3:
            - value if skipping current index
            - 1 if currentOr | nums[i] == max1
            - value if adding current number to xor and fetching the subsets build when passed downstream
     */
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for (int num : nums) {
            maxOr = maxOr | num;
        }
        Map<Integer, Integer>[] orCache = new Map[nums.length];
        return findOr(nums, 0, 0, maxOr, orCache);
    }

    private int findOr(int[] nums, int index, int currentOr, int maxOr, Map<Integer, Integer>[] orCache) {
        if (index == nums.length) {
            return 0;
        }
        if (orCache[index] == null) {
            orCache[index] = new HashMap<>();
        }
        Integer count = orCache[index].get(currentOr);
        if (count == null) {
            // skip
            count = findOr(nums, index + 1, currentOr, maxOr, orCache);
            // pick
            count += (currentOr | nums[index]) == maxOr ? 1 : 0;
            count += findOr(nums, index + 1, currentOr | nums[index], maxOr, orCache);
            orCache[index].put(currentOr, count);
        }
        return count;
    }
}
