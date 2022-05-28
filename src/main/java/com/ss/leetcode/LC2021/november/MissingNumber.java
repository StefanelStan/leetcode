package com.ss.leetcode.LC2021.november;

public class MissingNumber {
    // https://leetcode.com/problems/missing-number/
    /** Algorithm
         1. As numbers are unique [1,2,3,4...9] we can determine their expected sum (sum of first n natural numbers)
         2. Knowing their expectedSum, traverse the array and determine to sum of elements. (actualSum)
         3. The missing element is the difference between expectedSum and actualSum.
     */
    public int missingNumber(int[] nums) {
        int actualSum = 0;
        int expectedSum = getNaturalOrderSumOf(nums.length);
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    private int getNaturalOrderSumOf(int n) {
        int sum = (1 + n) * (n / 2);
        if (n % 2 == 1) {
            sum += (n + 1)/2;
        }
        return sum;
    }

    public int missingNumber2(int[] nums) {
        int zeroPos = -1;
        int index = 0;
        while(index < nums.length) {
            if (nums[index] == index +1) {
                index++;
            } else {
                if (nums[index] != 0) {
                    swap(nums, index, nums[index] -1);
                } else {
                    zeroPos = index;
                    index++;
                }
            }
        }
        return zeroPos +1;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
