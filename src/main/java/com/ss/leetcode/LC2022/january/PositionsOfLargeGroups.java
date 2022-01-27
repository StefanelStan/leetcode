package com.ss.leetcode.LC2022.january;

import java.util.ArrayList;
import java.util.List;

public class PositionsOfLargeGroups {
    // https://leetcode.com/problems/positions-of-large-groups/
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> largeGroups = new ArrayList<>();
        int size = 1, index = -1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                if (size == 1) {
                    index = i;
                }
                size++;
            } else {
                if (size > 2) {
                    largeGroups.add(List.of(index, i));
                }
                size = 1;
                index = i;
            }
        }
        if (size > 2) {
            largeGroups.add(List.of(index, s.length() -1));
        }
        return largeGroups;
    }
}
