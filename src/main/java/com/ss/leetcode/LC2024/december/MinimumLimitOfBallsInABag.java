package com.ss.leetcode.LC2024.december;

public class MinimumLimitOfBallsInABag {
    // https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag
    /** Algorithm
        1. Apply binary search to look for the answer: can you make all bags on size [1..1_000_000_000] ?
            - If yes, then reduce high, as you can try with a smaller size, else increment low, as you need a bigger bag size
        2. Determining in how many steps you can make a bag to be of size pivot
            - The idea is to deduct pivot from bag until you reach a bag less than pivot
            - in math, this is bag / pivot.
            - if bag % pivot == 0, you need one less step, as last bag will be split in 2 equal halfs
            - eg: bag = 10 , pivot  = 2 => [8,2] -> [6,2,2], ->[4,2,2,2], [2,2,2,2,2]) => 4 steps (10/ 2 - 1)
            - eg: bag = 11, pivot = 2 => [9,2], -> [7,2,2] -> [5,2,2,2] -> [3,2,2,2,2] -> [1,2,2,2,2,2] => 5 steps (11/2)
     */
    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1, high = 1_000_000_000, pivot;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            if (canBeDoneWithBagSize(nums, pivot, maxOperations)) {
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
        }
        return low;
    }
    private boolean canBeDoneWithBagSize(int[] nums, int target, int maxOperations) {
        for (int i = 0; i < nums.length && maxOperations >= 0; i++) {
            if (nums[i] > target) {
                maxOperations -= (nums[i] / target);
                if (nums[i] % target == 0) {
                    maxOperations++;
                }
            }
        }
        return maxOperations >= 0;
    }
}
