package com.ss.leetcode.LC2022.march;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class AllAncestorsOfANodeInADirectedAcyclicGraph {
    // https://leetcode.com/contest/biweekly-contest-73/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/
    // TLE
    public List<List<Integer>> getAncestors(final int n, int[][] edges) {
        Map<Integer, List<Integer>> leadingTo = new TreeMap<>();
        boolean[] nodes = new boolean[n];
        for (int[] edge : edges) {
            leadingTo.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
            nodes[edge[0]] = true;
            nodes[edge[1]] = true;
        }

        final List<List<Integer>> answer = new ArrayList<>();
        int[] index = {0};
        while(index[0] < n) {
            if (!nodes[index[0]]) {
                answer.add(new ArrayList<>());
            } else {
                Set<Integer> ancestors = new TreeSet<>();
                getListOfAncestors(index[0], ancestors, leadingTo, index, answer);
                answer.add(new ArrayList<>(ancestors));
            }
            index[0]++;
        }
        return answer;
    }

    private void getListOfAncestors(Integer node, Set<Integer> ancestors, Map<Integer, List<Integer>> leadingTo, int[] index, List<List<Integer>> answer) {
        if (!leadingTo.containsKey(node)) {
            return;
        }
        if (index[0] < answer.size()) {
            ancestors.addAll(answer.get(index[0]));
            return;
        }
        leadingTo.get(node).forEach(ancestor -> {
            ancestors.add(ancestor);
            getListOfAncestors(ancestor, ancestors, leadingTo, index, answer);
        });
    }
}
