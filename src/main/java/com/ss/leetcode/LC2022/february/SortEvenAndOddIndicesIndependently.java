package com.ss.leetcode.LC2022.february;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortEvenAndOddIndicesIndependently {
    // https://leetcode.com/contest/weekly-contest-279/problems/sort-even-and-odd-indices-independently/
    public int[] sortEvenOdd(int[] nums) {
        int[] sorted =  new int[nums.length];
        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evens.add(nums[i]);
            } else {
                odds.add(nums[i]);
            }
        }
        evens.sort(Comparator.naturalOrder());
        odds.sort(Comparator.reverseOrder());
        for (int i = 0, evenI = 0, oddI = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                sorted[i] = evens.get(evenI++);
            } else {
                sorted[i] = odds.get(oddI++);
            }
        }
        return sorted;
    }
}
