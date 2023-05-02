package com.ss.leetcode.LC2023.may;

import java.util.TreeMap;

public class ContainsDuplicateIII {
    // https://leetcode.com/problems/contains-duplicate-iii
    /** Algorithm
        1. Apply a sliding window algorithm: Keep a window of size indexDiff. Use a TreeMap<Int, Int> (number, count)
        2. With each step (i), add a number and check the condition abs(i - j) <= indexDiff
            Look inside the window for k = ceilingKey(num[i] - diff) and k = floorKey(num[i] + diff).
            If such k number exists and Math.abs(num[i] - k) <= diff, return true.
        3. When moving left, remove the extreme left number from the window.
            EG: decrease its count in TreeMap (or remove it if count == 0).
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeMap<Integer, Integer> window = new TreeMap<>();
        for (int i = 0; i <= Math.min(nums.length -1, indexDiff); i++) {
            if (addNumberAndCheckForCondition(window, nums[i], valueDiff)) {
                return true;
            }
        }
        for (int i = 0, j = indexDiff + 1; j < nums.length; i++, j++) {
            removePrevElement(window, nums[i]);
            if (addNumberAndCheckForCondition(window, nums[j], valueDiff)) {
                return true;
            }
        }
        return false;
    }

    private void removePrevElement(TreeMap<Integer, Integer> window, int num) {
        int currentCount = window.merge(num, -1, Integer::sum);
        if (currentCount == 0) {
            window.remove(num);
        }
    }

    private boolean addNumberAndCheckForCondition(TreeMap<Integer, Integer> window, int num, int diff) {
        Integer lower = window.ceilingKey(num - diff);
        if (lower != null && Math.abs(lower - num) <= diff) {
            return true;
        }
        Integer higher = window.floorKey(num + diff);
        if (higher != null && Math.abs(higher - num) <= diff) {
            return true;
        }
        window.merge(num, 1, Integer::sum);
        return false;
    }
}
