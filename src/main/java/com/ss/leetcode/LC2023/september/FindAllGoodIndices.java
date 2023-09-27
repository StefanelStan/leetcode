package com.ss.leetcode.LC2023.september;

import java.util.ArrayList;
import java.util.List;

public class FindAllGoodIndices {
    // https://leetcode.com/problems/find-all-good-indices
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> indices = new ArrayList<>();
        if (2 * k >= nums.length) {
            return indices;
        } else  if (k == 1) {
            for (int i = k; i < nums.length - k; i++) {
                indices.add(i);
            }
            return indices;
        }
        SortedWindow leftWindow = getInitialWindow(nums, false, k, 0, k-1);
        SortedWindow rightWindow = getInitialWindow(nums, true, k, k+1, 2 * k);
        if (leftWindow.isSorted() && rightWindow.isSorted()) {
            indices.add(leftWindow.end + 1);
        }
        while (rightWindow.end < nums.length - 1) {
            leftWindow.advance();
            rightWindow.advance();
            if (leftWindow.isSorted() && rightWindow.isSorted()) {
                indices.add(leftWindow.end + 1);
            }
        }
        return indices;
    }

    public SortedWindow getInitialWindow(int[] nums, boolean isIncreasing, int size, int from, int end) {
        SortedWindow window = new SortedWindow(isIncreasing, nums, size, from);
        while (from < end) {
            window.advance();
            from++;
        }
        return window;
    }

    public static class SortedWindow {
        public boolean isIncreasing;
        public int[] nums;
        public int end;
        private int lastBadPosition = -2;
        private final int size;
        public SortedWindow(boolean isIncreasing, int[] nums, int size, int end) {
            this.isIncreasing = isIncreasing;
            this.nums = nums;
            this.size = size;
            this.end = end;
        }

        public void advance() {
            if (isIncreasing) {
                if (nums[end+1] < nums[end]) {
                    lastBadPosition = end;
                }
            } else {
                if (nums[end + 1] > nums[end]) {
                    lastBadPosition = end;
                }
            }
            end++;
        }

        public boolean isSorted() {
            return 1 + end - size > lastBadPosition;
        }
    }

    // Version that precomputes the bad indices rather than using a sliding window
    public List<Integer> goodIndices2(int[] nums, int k) {
        List<Integer> indices = new ArrayList<>();
        if (2 * k >= nums.length) {
            return indices;
        } else  if (k == 1) {
            for (int i = k; i < nums.length - k; i++) {
                indices.add(i);
            }
            return indices;
        }
        int[][] lastBadIndices = getLastBadIndices(nums);
        for (int i = k; i < nums.length - k; i++) {
            if (lastBadIndices[0][i-2] < i - k && lastBadIndices[1][i+k - 1] <= i) {
                indices.add(i);
            }
        }
        return indices;
    }


    private int[][] getLastBadIndices(int[] nums) {
        int[][] lastBadIndices = new int[2][nums.length];
        int lastLeftBadPosition = -1, lastRightBadPosition = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i+1]) {
                lastLeftBadPosition = i;
            } else if (nums[i] > nums[i+1]) {
                lastRightBadPosition = i;
            }
            lastBadIndices[0][i] = lastLeftBadPosition;
            lastBadIndices[1][i] = lastRightBadPosition;
        }
        return lastBadIndices;
    }
}
