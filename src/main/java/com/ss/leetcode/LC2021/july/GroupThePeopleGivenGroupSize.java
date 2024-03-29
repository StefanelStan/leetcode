package com.ss.leetcode.LC2021.july;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupThePeopleGivenGroupSize {
    // https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> groups = new LinkedList<>();
        List<Integer>[] sizes = new List[501];
        for (int i = 0; i < groupSizes.length; i++) {
            if (sizes[groupSizes[i]] == null) {
                sizes[groupSizes[i]] = new ArrayList<>(groupSizes[i]);
            }
            sizes[groupSizes[i]].add(i);
            if (sizes[groupSizes[i]].size() == groupSizes[i]) {
                groups.add(sizes[groupSizes[i]]);
                sizes[groupSizes[i]] = null;
            }
        }
        return groups;
    }

    public List<List<Integer>> groupThePeople2(int[] groupSizes) {
        List<List<Integer>> groups = new LinkedList<>();
        Map<Integer, List<Integer>> sizePreferences = new HashMap<>();
        for(int i = 0; i < groupSizes.length; i++) {
            List<Integer> bucket = sizePreferences.computeIfAbsent(groupSizes[i], k -> new ArrayList<>());
            bucket.add(i);
        }
        for (Map.Entry<Integer, List<Integer>> entry : sizePreferences.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i += entry.getKey()) {
                groups.add(entry.getValue().subList(i, i + entry.getKey()));
            }
        }
        return groups;
    }
}
