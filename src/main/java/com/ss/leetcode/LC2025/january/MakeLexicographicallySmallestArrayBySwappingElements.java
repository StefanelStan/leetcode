package com.ss.leetcode.LC2025.january;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MakeLexicographicallySmallestArrayBySwappingElements {
    // https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements
    /** Algorithm
        1. If nums.length == 1 return nums
        2. You can only swap the numbers that are within the same difference range:
            - EG: [16, 6,2,13,1,5,10,4], limit =3
                => the numbers 1,2,4,5,6 are in the same group as the diff between 2 consecutive ones is <= 3
                => the numbers 16,13, 10 are in the same group as the diff between 2 consecutive ones is <= 3.
        3. Use a list sortedByValues to store the indices 0,n-1. Sort this list by value of nums
            - eg: nums = [16, 6,2,13,1,5,10,4]
                => sortedByValue = [4,2,7,5,1,6,3,0]
                => the nums 1,2,4,5,6 are at indices [4,2,7,5,1]
                => the nums 10,13,16 are at indices [6,3,0]
        4. Sliding window:
             - traverse sorted by value with 2 pointers: left and right;
             - if nums[sortedByValue[right]] - previous, then you need to close the window.
             - Copy the indices between left and right and sort them ascending.
             - the value of sortedByValue[left] will be put at the lowest indces of the copied/sorted window indices.
     */
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        if (nums.length == 1) {
            return nums;
        }
        int[] smallestArray = new int[nums.length];
        List<Integer> sortedByValue = getSortedByValue(nums);
        int left = 0, right = 1;
        while (right < nums.length) {
            while (right < nums.length && nums[sortedByValue.get(right)] - nums[sortedByValue.get(Math.max(left, right - 1))] <= limit) {
                right++;
            }
            right--;
            if (left == right) {
                smallestArray[sortedByValue.get(right)] = nums[sortedByValue.get(right)];
            } else {
                putIndicesInOrder(left, right, sortedByValue, nums, smallestArray);
            }
            right++;
            left = right;
        }
        return smallestArray;
    }

    private void putIndicesInOrder(int left, int right, List<Integer> sortedByValue, int[] nums, int[] smallestArray) {
        List<Integer> sortedByIndex = new ArrayList<>(1 + right - left);
        for (int i = left; i <= right; i++) {
            sortedByIndex.add(sortedByValue.get(i));
        }
        Collections.sort(sortedByIndex);
        for (int i = 0; i < sortedByIndex.size(); i++) {
            smallestArray[sortedByIndex.get(i)] = nums[sortedByValue.get(left + i)];
        }
    }

    private List<Integer> getSortedByValue(int[] nums) {
        List<Integer> sortedByValue = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            sortedByValue.add(i);
        }
        Collections.sort(sortedByValue, Comparator.comparingInt(a -> nums[a]));
        return sortedByValue;
    }
}
