package com.ss.leetcode.LC2024.december;

public class MinimumCostToMakeAllCharactersEqual {
    // https://leetcode.com/problems/minimum-cost-to-make-all-characters-equal
    /** Algorithm
        1. Use 2 pointers left/right and advance them (left + 1, right - 1) while current letters match previous letter
        2. Upon stopping, pick the minimum change (min cost), moving the picked left or right pointer ahead.
        3. Return the min cost of the operations.
     */
    public long minimumCost(String s) {
        char lastLeft = s.charAt(0), lastRight = s.charAt(s.length() - 1);
        long cost = 0L;
        for (int left = 0, right = s.length() - 1; left < right;) {
            while (left < right && s.charAt(left + 1) == lastLeft) {
                left++;
            }
            while (left < right && s.charAt(right - 1) == lastRight) {
                right--;
            }
            if (left < right) {
                if (left + 1 <= s.length() - right) {
                    lastLeft = left < s.length() - 1 ? s.charAt(left + 1) : 0;
                    cost += left + 1;
                    left++;
                } else {
                    cost += s.length() - right;
                    lastRight = s.charAt(right - 1);
                    right--;
                }
            }
        }

        return cost;
    }
}
