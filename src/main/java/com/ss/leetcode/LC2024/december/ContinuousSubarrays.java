package com.ss.leetcode.LC2024.december;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ContinuousSubarrays {
    // https://leetcode.com/problems/continuous-subarrays
    public long continuousSubarrays(int[] nums) {
        PriorityQueue<Integer> lowestNums = new PriorityQueue<>(Comparator.comparingInt(a -> nums[a]));
        PriorityQueue<Integer> highestNums = new PriorityQueue<>((a,b) -> Integer.compare(nums[b], nums[a]));
        long count = 0L;
        for (int left = 0, right = 0; right < nums.length; right++) {
            lowestNums.add(right);
            highestNums.add(right);
            while (!lowestNums.isEmpty() && !highestNums.isEmpty() && nums[highestNums.peek()] - nums[lowestNums.peek()] > 2) {
                left++;
                drain(lowestNums, left);
                drain(highestNums, left);
            }
            count += (1 + right - left);
        }
        return count;
    }

    private void drain(PriorityQueue<Integer> nums, int lesserIndex) {
        while (!nums.isEmpty() && nums.peek() < lesserIndex) {
            nums.poll();
        }
    }

}
