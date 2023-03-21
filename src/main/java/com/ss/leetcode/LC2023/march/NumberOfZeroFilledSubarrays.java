package com.ss.leetcode.LC2023.march;

public class NumberOfZeroFilledSubarrays {
    // https://leetcode.com/problems/number-of-zero-filled-subarrays
    public long zeroFilledSubarray(int[] nums) {
        long sum = 0;
        int i = 0, j = 0;
        while(i < nums.length) {
            if (nums[i] == 0) {
                j = i;
                // as j expands, add 1,2,3,4 rather than doing a multiplication at the end.
                while(j < nums.length && nums[j] == 0) {
                    sum += (j-i) + 1;
                    j++;
                }
                i = j;
            }
            i++;
        }
        return sum;
    }

    public long zeroFilledSubarray2(int[] nums) {
        long sum = 0, count = 0;
        for (int num : nums) {
            if (num == 0) {
                count++;
            } else if(count > 0) {
                sum += count * (count + 1) / 2;
                count = 0;
            }
        }
        return sum + count * (count + 1) / 2;
    }
}
