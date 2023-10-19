package com.ss.leetcode.LC2023.october;

public class MinimumSwapsToGroupAll1sTogetherII {
    // https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii
    /** Algorithm
        1. Traverse the array and count how many 1s you have (or determine the sum)
        2. The sum/number of 1s will be your scoping window. (windowSize)
        3. Using a window of size windowSize that gets expanded from indices [0.k-1] .. [n-1,k-2] count how many 1s you have
        4. The number of swaps needed is the difference between your current window count and the total count of 1s you have in array
        5. Return the min swap.
     */
    public int minSwaps(int[] nums) {
        int windowSize = countOnes(nums);
        if (windowSize <= 1 || windowSize == nums.length) {
            return 0;
        }
        int numberOfOnes = expandWindow(nums, windowSize);
        int minSwaps = windowSize - numberOfOnes;
        for (int left = 1, right = windowSize; left < nums.length && minSwaps > 0; left++, right = (right + 1) % nums.length) {
            numberOfOnes += nums[right] - nums[left - 1];
            minSwaps = Math.min(minSwaps, windowSize - numberOfOnes);
        }
        return minSwaps;
    }

    private int countOnes(int[] nums) {
        int count = 0;
        for (int num : nums) {
            count += num;
        }
        return count;
    }

    private int expandWindow(int[] nums, int windowSize) {
        int count = 0;
        for (int i = 0; i < windowSize; i++) {
            count += nums[i];
        }
        return count;
    }
}
