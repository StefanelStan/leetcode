package com.ss.leetcode.LC2024.november;

import java.util.List;
import java.util.TreeSet;

public class MinimumAbsoluteDifferenceBetweenElementsWithConstraint {
    // https://leetcode.com/problems/minimum-absolute-difference-between-elements-with-constraint
    /** Algorithm
        1. Fail fast: if x == 0 the diff is 0; if x == nums.size() - 1 then diff is first - last
        2. Use two pointers i = size - (x+1), j = size-1 that are x distance apart.
        3. In a loop (while i>= 0), add nums[j] in a TreeSet and check the set for floor / ceiling of nums.get(i). Set min diff based on this.
     */
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        if (x == 0) {
            return 0;
        } else if (x == nums.size() - 1) {
            return Math.abs(nums.getFirst() - nums.getLast());
        }
        int minAbsDiff = Integer.MAX_VALUE;
        TreeSet<Integer> numsOnLeft = new TreeSet<>();
        Integer floor, ceiling;
        for (int i = nums.size() - (x + 1), j = nums.size() - 1; i >= 0 && minAbsDiff > 0; i--, j--) {
            numsOnLeft.add(nums.get(j));
            floor = numsOnLeft.floor(nums.get(i));
            ceiling = numsOnLeft.ceiling(nums.get(i));
            minAbsDiff = floor == null ? minAbsDiff : Math.min(minAbsDiff, Math.abs(floor - nums.get(i)));
            minAbsDiff = ceiling == null ? minAbsDiff : Math.min(minAbsDiff, Math.abs(ceiling - nums.get(i)));
        }
        return minAbsDiff;
    }
}
