package com.ss.leetcode.LC2021.january;

import java.util.Map;
import java.util.TreeMap;

public class SortColors {
    // https://leetcode.com/problems/sort-colors/
    public void sortColors(int[] nums) {
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
}
