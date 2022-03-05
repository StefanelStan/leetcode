package com.ss.leetcode.LC2022.march;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class AllAncestorsOfANodeInADirectedAcyclicGraph {
    // https://leetcode.com/contest/biweekly-contest-73/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Map<Integer, List<Integer>> leadingTo = new TreeMap<>();
        Set<Integer> nodes = new TreeSet<>();
        for (int[] edge : edges) {
            leadingTo.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
            nodes.add(edge[0]);
            nodes.add(edge[1]);
        }

        final List<List<Integer>> answer = new ArrayList<>();
        nodes.forEach(node -> answer.add(getListOfAncestors(node, leadingTo, answer)));
        return answer;
    }

    private List<Integer> getListOfAncestors(Integer node, Map<Integer, List<Integer>> leadingTo, List<List<Integer>> answer) {
        Set<Integer> ancestors = new TreeSet<>();
        if (!leadingTo.containsKey(node)) {
            return new ArrayList<>();
        }

        // now just play with maps to finish it :)

        return new ArrayList<>(ancestors);
    }

}
