package com.ss.leetcode.LC2021.november;

import java.util.ArrayList;
import java.util.List;

public class FindTargetIndicesAfterSortingArray {
    // https://leetcode.com/problems/find-target-indices-after-sorting-array/
    public List<Integer> targetIndices(int[] nums, int target) {
        int smaller = 0;
        int equal = 0;
        for (int num : nums) {
            if (num < target) {
                smaller++;
            } else if (num == target) {
                equal++;
            }
        }
        List<Integer> indices = new ArrayList<>(equal);
        for (int i = smaller; i < smaller + equal; i++) {
            indices.add(i);
        }
        return indices;
    }
}
