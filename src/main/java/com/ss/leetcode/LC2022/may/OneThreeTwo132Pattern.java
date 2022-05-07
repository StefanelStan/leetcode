package com.ss.leetcode.LC2022.may;

import java.util.PriorityQueue;

public class OneThreeTwo132Pattern {
    // https://leetcode.com/problems/132-pattern/
    public boolean find132pattern(int[] nums) {
        int[] minLeftToRight = getMinLeftToRight(nums);
        int temp;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = nums.length -1; i > 1; i--){
            if (nums[i] < nums[i-1]) {
                queue.add(nums[i]);
                while(!queue.isEmpty() && queue.peek() < nums[i-1]) {
                    temp = queue.poll();
                    if (temp > minLeftToRight[i-2] && temp < nums[i-1]) {
                        return true;
                    }
                }
            } else {
                queue.add(nums[i]);
            }
        }
        return false;
    }

    private int[] getMinLeftToRight(int[] nums) {
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            min[i] = Math.min(min[i-1], nums[i]);
        }
        return min;
    }
}
