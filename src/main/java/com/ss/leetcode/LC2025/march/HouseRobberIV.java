package com.ss.leetcode.LC2025.march;

public class HouseRobberIV {
    // https://leetcode.com/problems/house-robber-iv
    /** Algorithm
        1. Traverse nums and find the min and max. If k is 1 or k == n, then the answer is minimum value;
        2. The answer lies between the min and max.
        3. USe binary search to find the min answer: use a mid value to see if you can rob k houses selecting those houses with a
            value up to selected midValue.
        4. Return the mininum value compatibility.
     */
    public int minCapability(int[] nums, int k) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if (k == 1 || k == nums.length) {
            return min;
        }
        int pivot;
        while (min <= max) {
            pivot = min + (max - min) / 2;
            if (canRobHouses(nums, k, pivot)) {
                max = pivot - 1;
            } else {
                min = pivot + 1;
            }
        }
        return max + 1;
    }

    private boolean canRobHouses(int[] houses, int minToRob, int threshold) {
        int lastRobbedIndex = -1;
        for (int i = 0; i < houses.length && minToRob > 0; i++) {
            if (houses[i] <= threshold && (lastRobbedIndex == -1 || i - lastRobbedIndex > 1)) {
                lastRobbedIndex = i;
                minToRob--;
            }
        }
        return minToRob == 0;
    }
}
