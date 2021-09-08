package com.ss.leetcode.september;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    // https://leetcode.com/problems/permutations/
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new LinkedList<>();
        generatePermutations(permutations, new ArrayList<>(), nums);
        return permutations;
    }

    private void generatePermutations(List<List<Integer>> permutations, List<Integer> integers, int[] nums) {
        if (integers.size() == nums.length) {
            permutations.add(new ArrayList<>(integers));
            return;
        }
        for (int num : nums) {
            if (!integers.contains(num)) {
                integers.add(num);
                generatePermutations(permutations, integers, nums);
                integers.remove(integers.size() - 1);
            }
        }
    }
}
