package com.ss.leetcode.LC2021.september;

import java.util.Arrays;

public class FindTheDistanceBetweenTwoArrays {
    // https://leetcode.com/problems/find-the-distance-value-between-two-arrays/
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        boolean[] arr2Shift = new boolean[2001];
        for (int num : arr2) {
            arr2Shift[num + 1000] = true;
        }
        int distance = 0;
        for (int num : arr1) {
            int upperLimit = Math.min(num + d + 1000, 2000);
            int lowerLimit = Math.max(num - d + 1000, 0);
            boolean containsBadInterval = false;
            for (int i = lowerLimit; i <= upperLimit; i++) {
                if (arr2Shift[i]) {
                    containsBadInterval = true;
                    break;
                }
            }
            if (!containsBadInterval) {
                distance++;
            }
        }
        return distance;
    }

    // Binary Search Solution
    public int findTheDistanceValue2(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int intervalsFound = 0;
        for (int num : arr1) {
            intervalsFound += findTheDistance(num, d, arr2);
        }
        return arr1.length - intervalsFound;
    }

    private int findTheDistance(int num, int d, int[] nums) {
        int index = binarySearch(num, nums);
        if (num - d <= nums[index] && nums[index] <= num + d) {
            return 1;
        }
        if (index < nums.length -1 && nums[index + 1] <= num + d) {
            return 1;
        }
        return 0;
    }

    private int binarySearch(int num, int[] nums) {
        int low = 0, high = nums.length -1, pivot = 0;
        while (low < high) {
            if (high - low == 1) {
                break;
            }
            pivot = low + (high - low) / 2;
            if (nums[pivot] == num) {
                return pivot;
            } else if (nums[pivot] < num) {
                low = pivot;
            } else {
                high = pivot;
            }
        }
        return nums[high] <= num ? high : low;
    }
}
