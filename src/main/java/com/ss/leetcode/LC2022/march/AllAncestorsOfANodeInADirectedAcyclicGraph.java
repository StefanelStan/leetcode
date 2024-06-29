package com.ss.leetcode.LC2022.march;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class AllAncestorsOfANodeInADirectedAcyclicGraph {
    // https://leetcode.com/contest/biweekly-contest-73/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/
    /** Algorithm
        1. Get a list<Integer>[]  inbound for each node: [3,4] -> [4] = {3}. Node 3 goes to node 4
        2. Use an List<Integer>[] ancestors to populate and cache the list of ancesters.
        3. For each i (0, n) if ancestors[i] is null, apply DFS to get the list of inbound nodes for each inbound node. Use a set to eliminate duplicates.
        4. If for a node x with 2 inbounds  (y and z), you already have ancestors[y], then just use that and do not calculate ancestors[y] again.
     */
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] inbound = getInboundNodes(n, edges);
        List<Integer>[] ancestors = new List[n];
        for (int i = 0; i < ancestors.length; i++) {
            if (ancestors[i] == null) {
                ancestors[i] = getAncestors(i, ancestors, inbound);
            }
        }
        return formatAncestors(ancestors);
    }

    private List<Integer> getAncestors(int node, List<Integer>[] ancestors, List<Integer>[] inbound) {
        if (ancestors[node] == null) {
            Set<Integer> foundAncestors = new HashSet<>();
            if (inbound[node] != null) {
                for (int ancestor : inbound[node]) {
                    foundAncestors.add(ancestor);
                    foundAncestors.addAll(getAncestors(ancestor, ancestors, inbound));
                }
            }
            ancestors[node] = new ArrayList<>(foundAncestors);
        }
        return ancestors[node];
    }

    private List<Integer>[] getInboundNodes(int n, int[][] edges) {
        List<Integer>[] inbound = new List[n];
        for (int[] edge : edges) {
            if (inbound[edge[1]] == null) {
                inbound[edge[1]] = new ArrayList<>();
            }
            inbound[edge[1]].add(edge[0]);
        }
        return inbound;
    }

    private List<List<Integer>> formatAncestors(List<Integer>[] ancestors) {
        List<List<Integer>> formatted = new ArrayList<>(ancestors.length);
        for (List<Integer> ancestor : ancestors) {
            Collections.sort(ancestor);
            formatted.add(ancestor);
        }
        return formatted;
    }


    // DP and DFS
    public List<List<Integer>> getAncestors2(int n, int[][] edges) {
        List<Integer>[] inDegree = getIndegree(n, edges);
        Set<Integer>[] ancestorsArray = new Set[n];
        populateAncestors(ancestorsArray, inDegree);
        List<List<Integer>> ancestors = new ArrayList<>(n);
        for (Set<Integer> ancestor : ancestorsArray) {
            ancestors.add(new ArrayList<>(ancestor));
        }
        return ancestors;
    }

    private void populateAncestors(Set<Integer>[] ancestorsArray, List<Integer>[] inDegree) {
        for (int i = 0; i < ancestorsArray.length; i++) {
            findAncestor(i, ancestorsArray, inDegree);
        }
    }

    private Set<Integer> findAncestor(int node, Set<Integer>[] ancestorsArray, List<Integer>[] inDegree) {
        if (ancestorsArray[node] == null) {
            if (inDegree[node] == null) {
                ancestorsArray[node] = new HashSet<>();
            } else {
                Set<Integer> upperNodes = new TreeSet<>();
                for (int parent : inDegree[node]) {
                    upperNodes.add(parent);
                    upperNodes.addAll(findAncestor(parent, ancestorsArray, inDegree));
                }
                ancestorsArray[node] = upperNodes;
            }
        }
        return ancestorsArray[node];
    }

    private List<Integer>[] getIndegree(int n, int[][] edges) {
        List<Integer>[] inDegree = new List[n];
        for (int[] edge : edges) {
            if (inDegree[edge[1]] == null) {
                inDegree[edge[1]] = new ArrayList<>();
            }
            inDegree[edge[1]].add(edge[0]);
        }
        return inDegree;
    }

    // TLE
    public List<List<Integer>> getAncestors3(final int n, int[][] edges) {
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
