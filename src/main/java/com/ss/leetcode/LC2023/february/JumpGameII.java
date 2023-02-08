package com.ss.leetcode.LC2023.february;

public class JumpGameII {
    // https://leetcode.com/problems/jump-game-ii
    /** Algorithm
        1. When doing a jump from index i, you have a certain momentum/inertia that decreases with each position jumped over.
            When inertia reaches 0, you have to decide which position jumped over can provide the best next momentum/inertia for next jump.
        2. While jumping over a position, check how much momentum that position can provide: nums[i] - remainingInertia.
            If it can provide more inertia than what you have, retain/remember that position.
        3. Do step 2 for each position, until reaching inertia 0. At that stage, get the maximum possible inertia
            from the best position you have jumped and compared against.
        4. When jumping from there, you have to deduct the i - that_position inertia from the momentum that nums[that_pos] is giving.
     */
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int jumps = 0;
        int inertia = nums[0];
        int nextBestMomentum = 0, nextBestMomentumIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            inertia--;
            // if this position can provide you more inertia that you currently have, it's worth memoizing this position. Your goal is to get the position of the most profitable next jump
            if (nums[i] > inertia && nums[i] - inertia >= nextBestMomentum) {
                nextBestMomentum = nums[i] - inertia;
                nextBestMomentumIndex = i;
            }
            // when reaching inertia 0, jump from the previous position that can give you best inertia.
            // don't jump if you already reached the end of nums
            if (inertia == 0 && i != nums.length - 1) {
                // jump from here
                inertia = nums[nextBestMomentumIndex] - (i - nextBestMomentumIndex);
                jumps++;
                nextBestMomentum = 0;
            }
        }
        return jumps + 1;
    }
}
