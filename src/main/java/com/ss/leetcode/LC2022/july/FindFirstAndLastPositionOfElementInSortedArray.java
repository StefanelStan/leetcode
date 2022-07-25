package com.ss.leetcode.LC2022.july;

public class FindFirstAndLastPositionOfElementInSortedArray {
    // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    /** Algorithm
         1. Apply divide et impera: find one occurance of it. If none found, return -1,-1
         2. If one if found, then utilize 2 methods that will look on the left side (0, index) and one to look on the right side (index, length -1).
         3. Make each helper methods smart; of nums[0]/nums[length -1] == target, return 0/l-1
         4. Each helper method behaves differently:
         - findRight will try to increase the low to pivot in case nums[pivot] == target
         - findLeft will try to decrease high to pivot in case nums[pivot] == target.
     */
    public int[] searchRange(int[] nums, int target) {
        int[] range = {-1, -1};
        if (nums.length == 1) {
            if (nums[0] == target) {
                range = new int[]{0, 0};
            }
        } else if (nums.length > 1) {
            int oneOccurance = binarySearch(nums, target);
            if (oneOccurance != -1) {
                range[0] = findLeft(nums, oneOccurance, target);
                range[1] = findRight(nums, oneOccurance, target);
            }
        }
        return range;
    }

    private int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length -1, pivot;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            if (nums[pivot] == target) {
                return pivot;
            } else if (nums[pivot] > target) {
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
        }
        return -1;
    }

    private int findLeft(int[] nums, int startIndex, int target) {
        int low = 0, high = startIndex, pivot = -1;
        boolean found = false;
        if (nums[low] == target) {
            return low;
        }
        while (!found) {
            pivot = low + (high - low) / 2;
            if (nums[pivot] < target) {
                if (nums[pivot + 1] == target) {
                    found = true;
                    pivot = pivot + 1;
                } else {
                    low = pivot;
                }
            } else if (nums[pivot] == target) {
                if (nums[pivot - 1] != target) {
                    found = true;
                } else {
                    high = pivot;
                }
            }
        }
        return pivot;
    }

    private int findRight(int[] nums, int startIndex, int target) {
        int low = startIndex, high = nums.length -1, pivot = -1;
        boolean found = false;
        if (nums[high] == target) {
            return high;
        }
        while (!found) {
            pivot = low + (high - low) / 2;
            if (nums[pivot] > target) {
                if (nums[pivot - 1] == target) {
                    found = true;
                    pivot = pivot - 1;
                } else {
                    high = pivot;
                }
            } else if (nums[pivot] == target) {
                if (nums[pivot + 1] != target) {
                    found = true;
                } else {
                    low = pivot;
                }
            }
        }
        return pivot;
    }
}
