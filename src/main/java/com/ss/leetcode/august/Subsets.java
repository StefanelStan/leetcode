package com.ss.leetcode.august;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    //  https://leetcode.com/problems/subsets/
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        genSubsets(0, nums, new ArrayList<>(), subsets);
        return subsets;
    }

    private void genSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            genSubsets(i + 1, nums, current, subsets);
            current.remove(current.size() - 1);
        }
    }
}
