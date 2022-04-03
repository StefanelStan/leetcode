package com.ss.leetcode.LC2022.april;

import java.util.Arrays;

public class NextPermutation {
    // https://leetcode.com/problems/next-permutation/
    /** Algorithm
     *  1. Sanity checks for length 1 and 2 and if last element is greater than last -1
     *  2. If not, then apply a logic:
     *  3. Iterate from n to 0 of string and identify the position where i > i -1. (3,6,5,4,3,2) 6 > 3 so this needs a hot swap.
     *  4. Once such position was identified, look on the tail of the string for the smallest value greater than i-1.
     *     In our example this would be 4.
     *  5. If such value does not exist (eg: 6,9,5,4,3,2 -> no number is grater than 6 on the right of 9). then 9 itself needs to be hot swapped
     *  6. Hotswap the i -1 with the next smallest value greater then i -1.
     *     [3,6,5,4,3,2] -> [4,6,5,3,3,2]
     *     [6,9,5,4,3,2] -> [9,6,5,4,3,2]
     *  7. Sort nums from position i to the end of it. As this view is ALMOST sorted DESC
     */
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int temp;
        if (nums.length == 2) {
            temp = nums[0];
            nums[0] = nums[1];
            nums[1] = temp;
            return;
        }
        if (nums[nums.length -1] > nums[nums.length -2]) {
            temp = nums[nums.length -2];
            nums[nums.length -2] = nums[nums.length -1];
            nums[nums.length -1] = temp;
            return;
        }
        for (int i = nums.length -1; i >= 1; i--) {
            if (nums[i] > nums[i-1]) {
                getNextPermutation(nums, i);
                return;
            }
        }
        swapElements(nums, 0, nums.length -1);
    }

    private void getNextPermutation(int[] nums, int index) {
        int nextSmallestButGreater = Integer.MAX_VALUE, indexOf = 0;
        int temp = 0;
        for (int i = index +1; i < nums.length; i++) {
            if (nums[i] > nums[index -1] && nums[i] < nextSmallestButGreater) {
                nextSmallestButGreater = nums[i];
                indexOf = i;
            }
        }
        if (indexOf == 0) { // not found an index. We will hotswap this one instead
            indexOf = index;
        }
        temp = nums[index -1];
        nums[index -1] = nums[indexOf];
        nums[indexOf] = temp;
        Arrays.sort(nums, index, nums.length);
    }

    private void swapElements(int[] nums, int left, int right) {
        int temp;
        while(left < right) {
            temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }
}
