package com.ss.leetcode.LC2024.september;

public class LongestSubarrayWithMaximumBitwiseAND {
    // https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and
    /** Algorithm
        1. Traverse nums and for each index keep track of currentAnd result and max length and maxAnd result.
        2. If currentAnd & nums[i] >= nums[i], then the chain can be continued (length++).
        3. Else, current num has a bitwise AND greater than prev result. So stop current chain and pick only current number (length = 1).
        4. If currentAnd > maxAnd, set the new maxLength.
     */
    public int longestSubarray(int[] nums) {
        int maxAnd = nums[0], currentAnd = nums[0];
        int maxLength = 1, currentLength = 1;
        for (int i = 1; i < nums.length; i++ ) {
            if ((currentAnd & nums[i]) >= nums[i]) {
                currentAnd = currentAnd & nums[i];
                currentLength++;
            } else {
                currentAnd = nums[i];
                currentLength = 1;
            }
            if (currentAnd == maxAnd) {
                maxLength = Math.max(currentLength, maxLength);
            } else if (currentAnd > maxAnd) {
                maxAnd = currentAnd;
                maxLength = currentLength;
            }
        }
        return maxLength;
    }
}
