package com.ss.leetcode.LC2022.january;

public class RemoveOneElementArrayStrictlyIncreasing {
    // https://leetcode.com/problems/remove-one-element-to-make-the-array-strictly-increasing/
    public boolean canBeIncreasing(int[] nums) {
        boolean alreadyRemoved = false;
        for (int i = 0; i < nums.length -1;i++)  {
            if (nums[i] >= nums[i+1]) {
                if (alreadyRemoved) {
                    return false;
                }
                if (i == 0) {
                    alreadyRemoved = true;
                } else {
                    int temp = nums[i];
                    // attempt to eliminate this index;
                    nums[i] = nums[i-1];
                    if (!canBeIncreasing(nums, i)) {
                        nums[i+1] = temp;
                        return canBeIncreasing(nums, i +1);
                    } else {
                        return true;
                    }
                }
            }

        }
        return true;
    }

    private boolean canBeIncreasing(int[] nums, int index) {
        for (int i = index; i < nums.length -1; i++) {
            if (nums[i] >= nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
