package com.ss.leetcode.LC2024.october;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MaximumWidthRamp {
    // https://leetcode.com/problems/maximum-width-ramp

    /** Algorithm
     *  1. Create a monotonic stack from left, adding to the tail only if the tail is greater than curr number. (6,1,9,0).
     *      - No point in adding 9 because 1 is lower than it and it can give a bigger width
     *      - We have to add 0 because there might be another 0 to the right that can be paired with this
     *  2. Starting from n-1, if current n[i] >= last from queue, remove it and set new Max.
     *      - These lower numbers can be eliminated because you start from the back, which gived mad width
     *
     */
    public int maxWidthRamp(int[] nums) {
        int maxWidth = 0;
        LinkedList<Integer> decreasingNumbers = getDecreasingNumbers(nums);
        for (int i = nums.length - 1; i > 0;  i--) {
            while (!decreasingNumbers.isEmpty() && nums[i] >= nums[decreasingNumbers.peekLast()]) {
                maxWidth = Math.max(maxWidth, i - decreasingNumbers.removeLast());
            }
        }
        return maxWidth;
    }

    private LinkedList<Integer> getDecreasingNumbers(int[] nums) {
        LinkedList<Integer> decreasingNumbers = new LinkedList<>();
        decreasingNumbers.add(0);
        for (int i = 1; i < nums.length; i++) {
            if (nums[decreasingNumbers.peekLast()] > nums[i]) {
                decreasingNumbers.add(i);
            }
        }
        return decreasingNumbers;
    }

    // Decreasing monotonic stack from left and binary search each index in stack
    public int maxWidthRamp2(int[] nums) {
        int maxWidth = 0;
        List<Integer> decreasingNumbers = getDecreasingNumbersArrayList(nums);
        for (int i = 1; i < nums.length; i++) {
            int mostLeft = findMostLeftLowerIndex(i, decreasingNumbers, nums);
            maxWidth = Math.max(maxWidth, i - mostLeft);
        }
        return maxWidth;
    }

    private int findMostLeftLowerIndex(int i, List<Integer> decreasingNumbers, int[] nums) {
        int low = 0, high = decreasingNumbers.size() - 1, pivot;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            if (nums[decreasingNumbers.get(pivot)] > nums[i]) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }
        return decreasingNumbers.get(low);
    }

    private List<Integer> getDecreasingNumbersArrayList(int[] nums) {
        List<Integer> decreasingNumbers = new ArrayList<>();
        decreasingNumbers.add(0);
        for (int i = 1; i < nums.length; i++) {
            if (nums[decreasingNumbers.getLast()] > nums[i]) {
                decreasingNumbers.add(i);
            }
        }
        return decreasingNumbers;
    }

        // TLE
    public int maxWidthRamp3(int[] nums) {
        int maxWidth = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for(int j = nums.length - 1; j > i; j--) {
                if (nums[j] >= nums[i]) {
                    maxWidth = Math.max(maxWidth, j - i);
                    break;
                }
            }
        }
        return maxWidth;
    }
}
