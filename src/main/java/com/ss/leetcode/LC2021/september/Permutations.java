package com.ss.leetcode.LC2021.september;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    // https://leetcode.com/problems/permutations/
    // much faster to decide which are used and which not
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        generatePermutations(permutations, new ArrayList<>(nums.length), nums, new boolean[nums.length]);
        return permutations;
    }

    private void generatePermutations(List<List<Integer>> permutations, List<Integer> collected, int[] nums, boolean[] usedIndices) {
        if (collected.size() == usedIndices.length) {
            permutations.add(new ArrayList<>(collected));
            return;
        }
        for (int i = 0; i <usedIndices.length; i++) {
            if (!usedIndices[i]) {
                usedIndices[i] = true;
                collected.add(nums[i]);
                generatePermutations(permutations, collected, nums, usedIndices);
                collected.remove(collected.size() -1);
                usedIndices[i] = false;
            }
        }
    }


    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> permutations = new LinkedList<>();
        generatePermutations2(permutations, new ArrayList<>(), nums);
        return permutations;
    }

    private void generatePermutations2(List<List<Integer>> permutations, List<Integer> integers, int[] nums) {
        if (integers.size() == nums.length) {
            permutations.add(new ArrayList<>(integers));
            return;
        }
        for (int num : nums) {
            if (!integers.contains(num)) {
                integers.add(num);
                generatePermutations2(permutations, integers, nums);
                integers.remove(integers.size() - 1);
            }
        }
    }
}
