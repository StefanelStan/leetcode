package com.ss.leetcode.LC2022.june;

public class MinMaxGame {
    // https://leetcode.com/problems/min-max-game/
    /** Algorithm
     1. Use nums to store the min & max values of each pairs
         EG: [1,3,5,2,4,8,2,2]
         [0] will be replaced by Min of (1,3)
         [1] will be replaced by max of (5,2)
         [2] will be replaced by min of (4,8)
         [3] will be replaced by max of (2,2)
     2. While applying this mechanism, you also need to know when to stop at position 1
         Use a stop variable that will mark the stopping point. With each pass/while loop, divide it by 2
         EG: [1,3,5,2,4,8,2,2]
         - stop is 8, so i will go from [0] to [7]
         - stop will be 4, so i will go from [0] to [3]
         - stop will be 2, so i will go from [0] to [1]
         - stop will be 1. This will mark the stopping point of algorithm/while loop.
     */
    public int minMaxGame(int[] nums) {
        int stop = nums.length;
        boolean minMode;
        while(stop != 1) {
            minMode = true;
            for (int i = 0, insIndex = 0; i <= stop -2; i += 2, insIndex++) {
                if (minMode) {
                    nums[insIndex] = Math.min(nums[i], nums[i+1]);
                } else {
                    nums[insIndex] = Math.max(nums[i], nums[i+1]);
                }
                minMode = !minMode;
            }
            stop = stop / 2;
        }
        return nums[0];
    }
}
