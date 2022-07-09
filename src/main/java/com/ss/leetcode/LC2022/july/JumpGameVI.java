package com.ss.leetcode.LC2022.july;

import java.util.PriorityQueue;

public class JumpGameVI {
    // https://leetcode.com/problems/jump-game-vi/
    public int maxResult(int[] nums, int k) {
        // int[] [position, sum]
        if (nums.length == 1) {
            return nums[0];
        }
        PriorityQueue<int[]> nextKJumps = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        int[] maxResults = new int[nums.length];
        nextKJumps.add(new int[]{nums.length -1, nums[nums.length -1]});
        for (int i = nums.length -2; i >= 0; i--) {
            while (!nextKJumps.isEmpty() && nextKJumps.peek()[0] >=  i + k + 1) {
                nextKJumps.poll();
            }
            maxResults[i] = nums[i] + nextKJumps.peek()[1];
            nextKJumps.add(new int[]{i, maxResults[i]});
        }
        return maxResults[0];
    }
}
