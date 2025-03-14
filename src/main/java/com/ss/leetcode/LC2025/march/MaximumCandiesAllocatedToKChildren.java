package com.ss.leetcode.LC2025.march;

public class MaximumCandiesAllocatedToKChildren {
    // https://leetcode.com/problems/maximum-candies-allocated-to-k-children
    /** Algorithm
        1. Use binary search to see if a candidate answer between 1 and maxCandy will satisfy the condition.
        2. For a given candidate, traverse candies and deduct the k children by candy/candidate. Stop at last child or end of candies
        3. Return the max point where no more candididate answers can be found.
     */
    public int maximumCandies(int[] candies, long k) {
        int low = 1, high = 0, pivot = 1;
        for (int candy : candies) {
            high = Math.max(candy, high);
        }

        while (low <= high) {
            pivot = low + (high - low) / 2;
            if (pivot > 0 && canServeAllChildren(candies, k, pivot)) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }
        return low - 1;
    }

    private boolean canServeAllChildren(int[] candies, long children, int allowance) {
        for (int i = 0; i < candies.length && children > 0; i++) {
            children -= (candies[i] / allowance);
        }
        return children <= 0;
    }
}
