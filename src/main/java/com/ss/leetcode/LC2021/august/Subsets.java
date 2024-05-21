package com.ss.leetcode.LC2021.august;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets {
    // https://leetcode.com/problems/subsets/
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sets = new ArrayList<>();
        addToList(nums, 0, new ArrayList<>(), sets);
        sets.add(Collections.emptyList());
        return sets;
    }

    private void addToList(int[] nums, int index, List<Integer> list, List<List<Integer>> sets) {
        if (index == nums.length) {
            return;
        }
        list.add(nums[index]);
        sets.add(new ArrayList<>(list));
        addToList(nums, index + 1, list, sets);
        list.removeLast();
        addToList(nums, index + 1, list, sets);
    }


    public List<List<Integer>> subsets2(int[] nums) {
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
