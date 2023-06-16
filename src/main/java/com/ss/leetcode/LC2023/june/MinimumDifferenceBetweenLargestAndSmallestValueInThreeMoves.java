package com.ss.leetcode.LC2023.june;

import java.util.Arrays;

public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
    // https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves
    /** Algorithm
        1. If the nums length < 5, return 0 as all numbers can be made equal, thus diff = 0;
        2. You are interested in the lowest 4 nums and high 4 nums.
            You can either sort them or traverse with a 2 x priority queue of size 4 to
            store lowest and highest.
        3. You have the view [lowest-highest] L1L2L3L4H1H2H3H4 (L1 lowest H4 highest)
            You have 4 options of which to "change" aka eliminate or make irelevant
            - eliminate 0 nrs from right and 3 from left, diff = H4 - L4
            - eliminate 1 nrs from right and 2 from left: diff = H3 - L3
            - eliminate 2 nrs from right and 1 from left: diff = H2 - L2
            - eliminate 3 nrs from right and 0 from left: diff = H1 - L1
        4. Return the smallest diff from #3.
     */
    public int minDifference(int[] nums) {
        if (nums.length < 5) {
            return 0;
        }
        Arrays.sort(nums);
        int l = nums.length;
        int pairOne = Math.min(nums[l-4] - nums[0], nums[l-3] - nums[1]);
        int pairTwo = Math.min(nums[l-2] - nums[2], nums[l-1] - nums[3]);
        return Math.min(pairOne, pairTwo);
    }
}
