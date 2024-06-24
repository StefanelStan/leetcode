package com.ss.leetcode.LC2024.june;

public class MinimumNumberOfKConsecutiveBitFlips {
    // https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips
    /** Algorithm
        1. Use an int[n] flipped to mark the flipped segments
        2. Traverse from 1st element and if current element is 0, then the segment [i -> i+k] needs to be flipped.
            - Mark this on flipped[]: flipped[i+k] += -1. If i+k > nums.length then you cannot flip this segment and return -1
        3. For each step, keep a prefix sum of flipped[]. If prefixSum % 2 == 0 then your current digit from nums is not
            flipped (and use the digit as it is), else it is flipped (and use the opposite digit).
        4. If your current processed  digit needs to be flipped, flip the segment (flipped[i+k] += -1), increment the no of flips and continue.
        5. If unable to flip (i+k) goes over the limit, then return -1.
     */
    public int minKBitFlips(int[] nums, int k) {
        int[] flipped =  new int[nums.length];
        int flipSum = 0, totalFlips = 0, flippedDigit;
        for (int i = 0; i < nums.length; i++) {
            flipSum += flipped[i];
            flippedDigit = (flipSum % 2 == 0 ? nums[i] : (nums[i] + 1) % 2);
            if (flippedDigit == 0) {
                if (i + k <= nums.length) {
                    flipSum++;
                    totalFlips++;
                    if (i + k < nums.length) {
                        flipped[i+k] += -1;
                    }
                } else {
                    return -1;
                }
            }
        }
        return totalFlips;
    }
}
