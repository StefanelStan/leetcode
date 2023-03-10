package com.ss.leetcode.LC2022.march;

public class FindTheDuplicateNumber {
    // https://leetcode.com/problems/find-the-duplicate-number
    // Floyd Cycle Detection
    public int findDuplicate(int[] nums) {
        if (nums.length == 2) {
            return nums[1];
        }
        int slow = nums[0];
        int fast = nums[0];
        boolean met = false;
        while(!met) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            met = slow == fast;
        }
        fast = nums[0];
        while(fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }

    public int findDuplicate2(int[] nums) {
        boolean[] seen = new boolean[nums.length + 1];
        for (int num : nums) {
            if(seen[num]) {
                return num;
            }
            seen[num] = true;
        }
        return -1;
    }
}
