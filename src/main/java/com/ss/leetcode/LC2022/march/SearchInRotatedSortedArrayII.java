package com.ss.leetcode.LC2022.march;

public class SearchInRotatedSortedArrayII {
    // https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
    // PRO MODE
    /** Algorithm
        1. Use the middle/pivot to determine if the left / right sequence is sorted
        2. If left sequence is STRICTLY sorted
            - If target is between left/right, search in on the left side
            - Else target is lesser or higher than the left interval, so check it on the right side
        3. Else
            - If right side is STRICTLY sorted and target is between the interval, search it only on the right side
            - Else we cannot determine if target is on the left or right
        4. We can have edge cases such as 23222222 or 2223222 or 22222232.
           Thus, if pivot == left can be misleading or pivot == right can be misleading.
     */
    public boolean search(int[] nums, int target) {
        return search(nums, 0, nums.length -1, target);
    }

    private boolean search(int[] nums, int low, int high, int target) {
        if (low > high) {
            return false;
        } else if (low == high || low + 1 == high) {
            return nums[low] == target || nums[high] == target;
        }
        int pivot = low + (high - low) / 2;
        boolean leftSorted = nums[low] < nums[pivot];
        boolean rightSorted = nums[high] > nums[pivot];
        if (leftSorted) {
            if (nums[low] <= target && nums[pivot] > target) {
                return search(nums, low, pivot, target);
            } else {
                return search(nums, pivot, high, target);
            }
        } else {
            if (rightSorted && nums[pivot] < target && nums[high] >= target) {
                return search(nums, pivot, high, target);
            } else {
                return search(nums, low, pivot, target) || search(nums, pivot, high, target);
            }
        }
    }


    // LOL Solution
    public boolean search2(int[] nums, int target) {
        if (nums.length < 4) {
            return contains(nums, 0, nums.length -1, target);
        } else {
            boolean[] answer = {false, false};
            binarySearchContains(nums, 0, nums.length -1, target, answer);
            return answer[1];
        }
    }

    private boolean contains(int[] nums, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (nums[i] == target) {
                return true;
            }
        }
        return false;
    }

    private void binarySearchContains(int[] nums, int low, int high, int target, boolean[] answer) {
        if (answer[0] || answer[1]) {
            return;
        }
        if (high == nums.length || low < 0) {
            return;
        }
        if (low == high) {
            answer[1] = nums[low] == target;
            return;
        }
        if (nums[low] == target || nums[high] == target) {
            answer[0] = true;
            answer[1] = true;
            return;
        }
        if (high - low < 10) {
            answer[0] = true;
            answer[1] = contains(nums, low, high, target);
            return;
        }
        int pivot = low + (high - low) / 2;
        // detect the halves : low to pivot
        if (nums[low] == nums[pivot]) {
            if (nums[low] == target) {
                answer[0] = true;
                answer[1] = true;
                return;
            } else {
                if (contains(nums, low, pivot, target)) {
                    answer[0] = true;
                    answer[1] = true;
                    return;
                } else {
                    answer[0] = true;
                    answer[1] = contains(nums, pivot, high, target);
                    return;
                }
            }
        }
        if (nums[low] < nums[pivot]) {
            if (target > nums[low] && target < nums[pivot]) {
                answer[0] = true;
                answer[1] = binarySearch(nums, low, pivot, target);
            }
            else { // it is in the second half
                if (high - pivot < 10) {
                    answer[0] = true;
                    answer[1] = contains(nums, pivot, high, target);
                } else {
                    binarySearchContains(nums, pivot +1, high, target, answer);
                }
            }
        } else { // it means this is NOT sorted but 2nd half IS sorted;
            // search LEFT
            if (binarySearch(nums, pivot, high, target)) {
                answer[0] = true;
                answer[1] = true;
                return;
            }
            binarySearchContains(nums, low, pivot - 1, target, answer);
        }

    }

    private boolean binarySearch(int[] nums, int low, int high, int target) {
        int pivot;
        while (low <= high) {
            pivot = low + (high - low) /2;
            if (nums[pivot] == target) {
                return true;
            } else if (nums[pivot] < target) {
                low = pivot + 1;
            } else {
                high = pivot -1;
            }
        }
        return false;
    }
}
