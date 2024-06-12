package com.ss.leetcode.LC2021.january;

import java.util.Map;
import java.util.TreeMap;

public class SortColors {
    // https://leetcode.com/problems/sort-colors/
    public void sortColors(int[] nums) {
        int start = sortColor(nums, 0, 0);
        sortColor(nums, start, 1);
    }

    private int sortColor(int[] nums, int from, int color) {
        for (int end = nums.length -1; from <= end;) {
            while (from <= end && nums[from] == color) {
                from++;
            }
            while (from <= end && nums[end] != color) {
                end--;
            }
            if (from < end) {
                nums[end] = nums[from];
                nums[from] = color;
                from++;
                end--;
            }
        }
        return from;
    }

    public void sortColors2(int[] nums) {
        int[] color = new int[3];
        for (int num : nums) {
            color[num]++;
        }
        int pos = 0;
        for (int i = 0; i < color.length; i++) {
            for (int j = pos; j < pos + color[i]; j++) {
                nums[j] = i;
            }
            pos += color[i];
        }
    }

    public void sortColors3(int[] nums) {
        Map<Integer, Integer> numberCount = new TreeMap<>();
        for(int num: nums) {
            numberCount.merge(num, 1, Integer::sum);
        }
        final int[] startingIndex = {0};
        numberCount.forEach((key, value) -> {
            for(int i = startingIndex[0]; i < startingIndex[0] + value; i++) {
                nums[i] = key;
            }
            startingIndex[0] += value;
        });
    }

}
