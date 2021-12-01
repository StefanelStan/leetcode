package com.ss.leetcode.LC2021.september;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
    // https://leetcode.com/problems/combinations/
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new LinkedList<>();
        generateCombinations(combinations, new ArrayList<>(), 1, n, k);
        return combinations;
    }

    private void generateCombinations(List<List<Integer>> combinations, ArrayList<Integer> integers, int i, int n, int k) {
        if (integers.size() == k) {
            combinations.add(new ArrayList<>(integers));
            return;
        }
        for (int j = i; j <= n; j++) {
            integers.add(j);
            generateCombinations(combinations, integers, j + 1, n, k);
            integers.remove(integers.size() - 1);
        }
    }
}
