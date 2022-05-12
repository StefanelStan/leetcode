package com.ss.leetcode.LC2022.may;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> permutations = new HashSet<>();
        generatePermutations(permutations, new LinkedHashSet<>(),  nums);
        return mapToList(permutations, nums);
    }

    private List<List<Integer>> mapToList(Set<List<Integer>> permutations, int[] nums) {
        List<List<Integer>> mapped = new ArrayList<>(permutations.size());
        permutations.forEach(permutation -> mapped.add(new ArrayList<>(permutation)));
        return mapped;
    }

    private void generatePermutations(Set<List<Integer>> permutations, Set<Integer> integers, int[] nums) {
        if (integers.size() == nums.length) {
            List<Integer> newSet = extractNums(integers, nums);
            permutations.add(newSet);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!integers.contains(i)) {
                integers.add(i);
                generatePermutations(permutations, integers, nums);
                integers.remove(i);
            }
        }
    }

    private List<Integer> extractNums(Set<Integer> integers, int[] nums) {
        List<Integer> ints = new ArrayList<>(integers.size());
        integers.forEach(i -> ints.add(nums[i]));
        return ints;
    }
}
