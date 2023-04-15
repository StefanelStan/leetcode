package com.ss.leetcode.LC2023.april;

public class MaximumScoreFromRemovingStones {
    // https://leetcode.com/problems/maximum-score-from-removing-stones
    public int maximumScore(int a, int b, int c) {
        int[] nums = new int[]{a,b,c};
        int score = 0;
        sort(nums);
        while(nums[1] > 0) {
            score++;
            nums[1]--;
            nums[2]--;
            sort(nums);
        }
        return score;
    }

    private void sort(int[] nums) {
        int temp;
        if (nums[0] >= nums[1]) {
            temp = nums[1];
            nums[1] = nums[0];
            nums[0] = temp;
        }
        if (nums[1] >= nums[2]) {
            temp = nums[2];
            nums[2] = nums[1];
            nums[1] = temp;
        }
    }
}
