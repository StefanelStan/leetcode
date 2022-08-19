package com.ss.leetcode.LC2022.august;

import java.util.ArrayList;
import java.util.List;

public class MergeSimilarItems {
    // https://leetcode.com/problems/merge-similar-items/
    /** Algorithm
         1. Use an int[1001] valueWeight to sum of the values of each item
             item[2,1] will cause valueWeight[2] = 1;
             item[2,4] will cause valueWeight[2] += 4 (5).
         2. Traverse the valueWeight and if valueWeight[i] > 0, add the pair (i, valueWeight[i]) to answer list
     */
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> answer = new ArrayList<>();
        int[] valueWeight = new int[1001];
        addValueWeight(valueWeight, items1);
        addValueWeight(valueWeight, items2);
        for (int i = 0; i < valueWeight.length; i++) {
            if (valueWeight[i] > 0) {
                answer.add(List.of(i, valueWeight[i]));
            }
        }
        return answer;
    }

    private void addValueWeight(int[] valueWeight, int[][] items) {
        for(int[] item : items) {
            valueWeight[item[0]] += item[1];
        }
    }
}
