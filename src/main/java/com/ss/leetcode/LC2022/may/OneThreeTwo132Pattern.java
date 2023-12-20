package com.ss.leetcode.LC2022.may;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class OneThreeTwo132Pattern {
    // https://leetcode.com/problems/132-pattern/
    // LEFT MIN + NEXT GREATER ELEMENT
    public boolean find132pattern(int[] nums) {
        int[] leftMin = getLeftMin(nums);
        int minFromLower;
        LinkedList<Integer> lower = new LinkedList<>();
        lower.addFirst(nums[nums.length -1]);
        for (int i = nums.length - 2; i > 0; i--) {
            if (nums[i] < nums[i + 1]) {
                lower.addFirst(nums[i]);
            } else if (nums[i] >= nums[i + 1]) {
                while (!lower.isEmpty() && nums[i] >= lower.peekFirst()) {
                    minFromLower = lower.removeFirst();
                    if (leftMin[i-1] < nums[i] && nums[i] > minFromLower && leftMin[i-1] < minFromLower) {
                        return true;
                    }
                }
                lower.addFirst(nums[i]);
            }
        }
        return false;
    }

    private int[] getLeftMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int[] leftMin = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            leftMin[i] = min;
        }
        return leftMin;
    }

    // INEFFICIENT
    public boolean find132pattern2(int[] nums) {
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
