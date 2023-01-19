package com.ss.leetcode.LC2023.january;

public class MaximumCountOfPositiveIntegerAndNegativeInteger {
    // https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer
    /** Algorithm
     *  1. Apply binary search to track the first negative number (aka number of negative ints) and first positive number.
     *  2. Return their max.
     */
    public int maximumCount(int[] nums) {
        if (nums[0] > 0 || nums[nums.length -1] < 0) {
            return nums.length;
        }
        if (nums[0] == nums[nums.length -1]) {
            return 0;
        }
        int negativeCount = getLastNegative(nums) + 1;
        int positiveCount = nums.length - getFirstPositive(nums);
        return Math.max(negativeCount, positiveCount);
    }

    private int getLastNegative(int[] nums) {
        int left = 0, right = nums.length -1;
        int mid;
        while(left < right) {
            if (left + 1 == right) {
                return nums[right] >= 0 ? nums[left] >= 0 ? left -1 : left : right;
            }
            mid = left + (right - left) / 2;
            if (nums[mid] >= 0) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left - 1;
    }

    private int getFirstPositive(int[] nums) {
        int left = 0, right = nums.length -1;
        int mid;
        while(left < right) {
            if (left + 1 == right) {
                return nums[left] <= 0 ? nums[right] <= 0 ? right + 1: right : left;
            }
            mid = left + (right - left) / 2;
            if (nums[mid] <= 0) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }

    /** Algorithm
        1. Quickly check if first number is > 0 or last is < 0, all of them are positive / negative.
        2. Start from first position and count the negative numbers.
        3. Stop when you first encounter the first positive number. Retain its position.
        4. Return the max between countOfNegative and countOfPositive (count of positive is nums.length - firstPosIndex).
     */
    public int maximumCount2(int[] nums) {
        if (nums[0] > 0 || nums[nums.length -1] < 0) {
            return nums.length;
        }
        int negativeCount = 0, firstPositiveIndex = nums.length;;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negativeCount++;
            } else if (nums[i] > 0) {
                firstPositiveIndex = i;
                break;
            }
        }
        return Math.max(negativeCount, nums.length - firstPositiveIndex);
    }
}
