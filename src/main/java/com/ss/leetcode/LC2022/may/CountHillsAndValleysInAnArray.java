package com.ss.leetcode.LC2022.may;

public class CountHillsAndValleysInAnArray {
    // https://leetcode.com/problems/count-hills-and-valleys-in-an-array/
    /** Algorithm
         1. For each index 1 .. n-2 try to expand a search window with 2 indexes: left and right.
         2. while (i >= 0 and nums[left] == nums[i]) left--;
            while (right < nums.length and nums[right] == nums[i]) right++;
             EG: [3,1,1,1,1,17];
             #1 step 1 will start from index 1
             #2 a. first while will stop at 3 since it's the first index != nums[1]
             b. second while will stop at 17 since it's the first index != nums[i];
         3. If right >= nums.length break immediately as all the numbers are equal and no hill/valley can exist
         4. If left >= 0, check if you have a valley or hill between nums[left], nums[i], nums[right].
            If yes, increment the count
         5. Our index will be updated with the right index, as this is the first non equal i index.
            Everything between i and right will be part of the same hill or valley.
     */
    public int countHillValley(int[] nums) {
        int hillsAndValleys = 0;
        int i = 0;
        int left, right;
        while (i < nums.length -1) {
            left = i -1;
            right = i +1;
            while(left >= 0 && nums[left] == nums[i]) {
                left--;
            }
            while(right < nums.length && nums[right] == nums[i]) {
                right++;
            }
            if (right == nums.length) {
                break;
            }
            if (left >= 0) {
                if ((nums[left] < nums[i] && nums[i] > nums[right]) ||
                    (nums[left] > nums[i] && nums[i] < nums[right])) {
                    hillsAndValleys++;
                }
            }
            i = right;
        }
        return hillsAndValleys;
    }
}
