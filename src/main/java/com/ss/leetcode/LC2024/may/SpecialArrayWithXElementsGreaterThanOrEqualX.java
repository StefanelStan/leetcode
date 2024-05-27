package com.ss.leetcode.LC2024.may;

import java.util.Arrays;

public class SpecialArrayWithXElementsGreaterThanOrEqualX {
    // https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x
    public int specialArray(int[] nums) {
        int low = 0, high = 1000, pivot, count;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            count = getCountOf(nums, pivot);
            if (count == pivot) {
                return count;
            } else if (count < pivot) {
                high = pivot - 1;
            } else  {
                low = pivot + 1;
            }
        }
        return -1;
    }

    private int getCountOf(int[] nums, int target) {
        int count = 0;
        for (int num : nums) {
            count += num >= target ? 1 : 0;
        }
        return count;
    }


    public int specialArray2(int[] nums) {
        Arrays.sort(nums);
        int j = 0;
        for (int i = 1; i <= nums.length && i <= nums.length - j; i++) {
            while (j < nums.length && nums[j] < i) {
                j++;
            }
            if (i == nums.length - j) {
                return i;
            }
        }
        return -1;
    }

    public int specialArray3(int[] nums) {
        int[] count = new int[1001];
        for (int num : nums) {
            count[num]++;
        }
        int countSoFar =0;
        for (int i = 0; i < count.length; i++) {
            if (i == nums.length - countSoFar) {
                return i;
            }
            countSoFar += count[i];
        }
        return -1;
    }
}
