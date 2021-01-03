package com.ss.leetcode.december;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sums = new LinkedList<>();
        if (nums.length <= 2) return sums;
        int numberOfZeroes = 0;
        for (int num : nums) {
            if (num == 0) {
                numberOfZeroes++;
            }
            if (numberOfZeroes >= 3) {
                break;
            }
        }
        if (numberOfZeroes >= 3) {
            sums.add(Arrays.asList(0, 0, 0));
        }
        int partialSum;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                partialSum = nums[i] + nums[j];
                int difference = -partialSum;
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] == difference) {
                        addToList(sums, Arrays.asList(nums[i], nums[j], nums[k]));
                        break;
                    }
                }
            }
        }

        return sums;
    }

    private void addToList(List<List<Integer>> sums, List<Integer> numbers) {
        for (List<Integer> currentList : sums) {
            if (currentList.containsAll(numbers)) {
                return;
            }
        }
        sums.add(numbers);
    }
}
