package com.ss.leetcode.LC2023.february;

import java.util.Collections;

public class MaxConsecutiveOnesIII {
    // https://leetcode.com/problems/max-consecutive-ones-iii
    public int longestOnes(int[] nums, int k) {
        int maxSize = 0;
        FlexibleWindow fw = new FlexibleWindow(k, nums);
        while(fw.canMove()) {
            fw.moveRight();
            fw.trimToSize();
            maxSize = Math.max(maxSize, fw.currentSize);
        }
        return maxSize;
    }

    private static class FlexibleWindow {
        int left = 0, right = -1;
        int currentSize = 0;
        int remainingFlips;
        int[] nums;

        public FlexibleWindow(int k, int[] nums) {
            this.remainingFlips = k;
            this.nums = nums;
        }

        public boolean canMove() {
            return right < nums.length -1;
        }

        public void moveRight() {
            if (right < nums.length - 1) {
                right++;
                currentSize++;
                remainingFlips += nums[right] == 0 ? -1 : 0;
            }
        }

        public void trimToSize() {
            while(remainingFlips < 0 && left <= right) {
                if (nums[left] == 0) {
                    remainingFlips++;
                }
                left++;
                currentSize--;
            }
        }
    }
}
