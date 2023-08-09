package com.ss.leetcode.LC2023.august;

import java.util.Arrays;

public class MinimizeTheMaximumDifferenceOfPairs {
    // https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs
    /** Algorithm
        1. Knowing you need to make p pairs, you have to pick them as best as possible, lowering their difference
        2. Sort the nums as this would help be to quickly find the minimum diff between two adjacent elements
        3. Using binary search, check if you can find p pairs for a given difference (0, max(nums)).
            - If you can, then try with a lower differce
            - If not, then try with a higher difference.
        4. Finding if you can make p pairs for a given difference
            - Iterate over the sorted nums and check if nums[i] - nums[i-1] <= givenDifference.
            - If yes, then increment i twice, as you cannot use the same index when doing the next check
            EG: 1,3,4,5,6, p = 2, givenDiff = 2.
                - i = 1:  3-1 <= 2. It's a good match, so we need to increment i twice, as we can't use 3 anymore
                - i = 3: 5-4 <= 2. Good match. We have two pairs, so we can break and return true.
        5. Given diff = 1
            - i = 1: 3-1 > 1 so we cannot match these. move to next index
            - i =2 : 4-3 <= 1, we can select these two, increment i twice
            - i =4: 6-5 <= 1, we can select thse two. We have 2 pairs so we can stop
     */
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int low = 0, high = nums[nums.length - 1], pivot;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            if (canMakePairsWithDiff(nums, pivot, p)) {
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
        }
        return low;
    }

    private boolean canMakePairsWithDiff(int[] nums, int diff, int reqPairs) {
        int foundPairs = 0;
        for (int i = 1; i < nums.length && foundPairs < reqPairs; i++) {
            if (nums[i] - nums[i-1] <= diff) {
                foundPairs++;
                i++;
            }
        }
        return foundPairs >= reqPairs;
    }
}
