package com.ss.leetcode.LC2024.december;

import java.util.Arrays;

public class FindScoreOfAnArrayAfterMarkingAllElements {
    // https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements
    /** Algorithm
        1. Use an Integer[] order to store the nums from 0 to n-1. This will reflect the order or the nums by their value.
        2. Sort order by value of nums[a], nums[b] and by their order (a,b)
        3. Loop with i from 0 to n-1
            - if nums[order[i]] > 0, add nums[order[i]] to score and mark nums[order[i]], nums[order[i] +/-1] with 0.
        4. Return score.
     */
    public long findScore(int[] nums) {
        long score = 0;
        Integer[] orderedElements = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            orderedElements[i] = i;
        }
        Arrays.sort(orderedElements, (a,b) -> nums[a] == nums[b] ? Integer.compare(a, b) : Integer.compare(nums[a], nums[b]));
        for (int i = 0; i < nums.length; i++) {
            if (nums[orderedElements[i]] != 0) {
                score += nums[orderedElements[i]];
                nums[orderedElements[i]] = 0;
                if (orderedElements[i] > 0) {
                    nums[orderedElements[i] - 1] = 0;
                }
                if (orderedElements[i] < nums.length - 1) {
                    nums[orderedElements[i] + 1] = 0;
                }
            }
        }
        return score;
    }
}
