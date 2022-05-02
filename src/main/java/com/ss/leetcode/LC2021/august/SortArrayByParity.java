package com.ss.leetcode.LC2021.august;

public class SortArrayByParity {
    // https://leetcode.com/problems/sort-array-by-parity/
    public int[] sortArrayByParity(int[] nums) {
        if (nums.length > 1) {
            int low = 0, high = nums.length - 1, temp;
            while (low < high) {
                while(low < high && nums[low] % 2 == 0) {
                    low++;
                }
                while(low < high && nums[high] % 2 == 1) {
                    high--;
                }
                if (low < high) {
                    temp = nums[low];
                    nums[low] = nums[high];
                    nums[high] = temp;
                }
                low++;
                high--;
            }
        }
        return nums;
    }

    public int[] sortArrayByParity2(int[] nums) {
        int[] sorted = new int[nums.length];
        int leftIndex = 0, rightIndex = nums.length -1;
        for (int num : nums) {
            if (num % 2 == 0) {
                sorted[leftIndex] = num;
                leftIndex++;
            } else {
                sorted[rightIndex] = num;
                rightIndex--;
            }
        }
        return sorted;
    }
}
