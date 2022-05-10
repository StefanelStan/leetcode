package com.ss.leetcode.LC2022.may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CombinationSumIII {
    // https://leetcode.com/problems/combination-sum-iii/
    public List<List<Integer>> combinationSum3(int k, int n) {
        Set<boolean[]> combinations = parseCombinations(k, n, new boolean[10]);
        return toList(combinations);
    }

    private Set<boolean[]> parseCombinations(int k, int n, boolean[] path) {
        Set<boolean[]> combinations = new TreeSet<>((a, b) -> (Arrays.compare(a, b)));
        if (n > k * 9 || k <= 0 || n <= 0) {
            return Collections.emptySet();
        }
        if (k == 1) {
            if (!path[n]) {
                path[n] = true;
                return Set.of(path);
            }
        }
        for (int i = 1; i <= 9 && n - i >= 0; i++) {
            if (!path[i]) {
                boolean[] copy = Arrays.copyOf(path, 10);
                copy[i] = true;
                if (k > 1) {
                    combinations.addAll(parseCombinations(k-1, n-i, copy));
                }
            }
        }
        return combinations;
    }

    private List<List<Integer>> toList(Set<boolean[]> set) {
        List<List<Integer>> answer = new ArrayList<>(set.size());
        for (boolean[] b : set) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i < b.length; i++) {
                if(b[i]) {
                    list.add(i);
                }
            }
            answer.add(list);
        }
        return answer;
    }
}
