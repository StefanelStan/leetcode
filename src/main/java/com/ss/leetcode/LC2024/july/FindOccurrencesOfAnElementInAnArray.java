package com.ss.leetcode.LC2024.july;

import java.util.ArrayList;
import java.util.List;

public class FindOccurrencesOfAnElementInAnArray {
    // https://leetcode.com/problems/find-occurrences-of-an-element-in-an-array
    /** Algorithm
        1. Use an ArrayList to hold the positions of each x from nums
        2. Traverse nums and store the position of each X you encounter. The list will contain positions in increasing order: 3,5,8 etc
        3. For each query, if q > list.size(), put -1, else list.get(q-1)
     */
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int[] answers = new int[queries.length];
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                positions.add(i);
            }
        }
        for (int i = 0; i < queries.length; i++) {
            answers[i] = queries[i] > positions.size() ? -1 : positions.get(queries[i] - 1);
        }
        return answers;
    }
}
