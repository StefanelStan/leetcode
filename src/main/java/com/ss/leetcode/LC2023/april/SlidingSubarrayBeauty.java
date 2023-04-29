package com.ss.leetcode.LC2023.april;

public class SlidingSubarrayBeauty {
    // https://leetcode.com/problems/sliding-subarray-beauty
    /** Algorithm
        1. Use an int[101] window to mark & count the nums[-50..50]. Just add 50 to the num (-50 + 50) -> 0, (4 +50) -> 54
        2. Create the initial window with the nums[0..k-1].
        3. While adding them, keep track of the negative count. If num < 0, increase negative count.
            When querying a given interval, if negativeCount < x, then return 0 immediately.
        4. Finding the xth negative.
            - As mentioned on #3, if negativeCount < x, return 0
            - Else loop from 0 to < 50 (representing the nums -50, -1) and do a prefix sum.
            Stop when prefixSum >= x. Return index - 50 (an index 4 will represent the number -46 because -46+50 = 4;
        5. When moving to next element, just remove the left number of the window (nums[i - k]).
            Also, adjust the negative count. (decrease if the eliminated number is negative).
     */
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] negativeCount = {0};
        int[] window = createWindow(nums, k, negativeCount);
        int[] beauty = new int[nums.length - k + 1];
        for (int i = k; i < nums.length; i++) {
            beauty[i - k] = findXthSmallestInteger(window, x, negativeCount);
            removePreviousElement(window, nums, i - k, negativeCount);
            addNextElement(window, nums, i, negativeCount);
        }
        beauty[nums.length - k] = findXthSmallestInteger(window, x, negativeCount);
        return beauty;
    }

    private void removePreviousElement(int[] window, int[] nums, int index, int[] negativeCount) {
        if (nums[index] < 0) {
            negativeCount[0]--;
        }
        window[nums[index] + 50]--;
    }

    private void addNextElement(int[] window, int[] nums, int index, int[] negativeCount) {
        if (nums[index] < 0) {
            negativeCount[0]++;
        }
        window[nums[index] + 50]++;
    }

    private int findXthSmallestInteger(int[] window, int x, int[] negativeCount) {
        if (negativeCount[0] < x) {
            return 0;
        }
        int count = 0;
        int index = 0;
        for (int i = 0; i < 50; i++) {
            if (window[i] > 0) {
                count += window[i];
                if (count >= x) {
                    index = i;
                    break;
                }
            }
        }
        return index - 50;
    }

    private int[] createWindow(int[] nums, int size, int[] negativeCount) {
        int[] window = new int[101];
        while(--size >= 0) {
            window[nums[size] + 50]++;
            if (nums[size] < 0) {
                negativeCount[0]++;
            }
        }
        return window;
    }
}
