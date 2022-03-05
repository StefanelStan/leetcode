package com.ss.leetcode.LC2022.march;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class SortTheJumbledNumbers {
    // https://leetcode.com/contest/biweekly-contest-73/problems/sort-the-jumbled-numbers/
    public int[] sortJumbled(int[] mapping, int[] nums) {
        boolean inOrder = true;
        for (int i = 1; i < mapping.length && inOrder; i++) {
            if (mapping[i] < mapping[i-1]) {
                inOrder = false;
            }
        }
        if (inOrder) {
            Arrays.sort(nums);
            return (nums);
        }

        // not in order
        TreeMap<Integer, List<Integer>> mappedNums = new TreeMap<>();
        int mappedVal;
        for (int num : nums) {
            mappedVal = getMappedVal(num, mapping);
            mappedNums.computeIfAbsent(mappedVal, v -> new ArrayList<>()).add(num);
        }
        int[] sortedJumbled = new int[nums.length];
        constructInOrder(sortedJumbled, mappedNums);
        return sortedJumbled;
    }

    private int getMappedVal(int num, int[] mapping) {
        int val = 0;
        String stringNum = String.valueOf(num);
        for (int i = 0; i < stringNum.length(); i++) {
            val = val * 10 + mapping[stringNum.charAt(i) - '0'];
        }
        return val;
    }

    private void constructInOrder(int[] sortedJumbled, TreeMap<Integer, List<Integer>> mappedNums) {
        int[] index = {0};
        mappedNums.forEach((k, v) -> {
            v.forEach(num -> {
                sortedJumbled[index[0]] = num;
                index[0]++;
            });
        });
    }
}
