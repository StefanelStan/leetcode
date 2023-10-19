package com.ss.leetcode.LC2023.october;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ParallelCoursesIII {
    // https://leetcode.com/problems/parallel-courses-iii
    // Inaccurate description
    public int minimumTime(int n, int[][] relations, int[] time) {
        UnionFind unionFind = new UnionFind(n, relations, time);
        Map<Integer, Integer> componentTotalCost = new HashMap<>();
        List<Integer> zeroInDegree = getInitialZeroIndegree(unionFind);
        while (!zeroInDegree.isEmpty()) {
            zeroInDegree = calculateNextLevelNodes(zeroInDegree, unionFind, componentTotalCost);
        }
        return getMaxCost(componentTotalCost);
    }

    private List<Integer> calculateNextLevelNodes(List<Integer> zeroInDegree, UnionFind uf, Map<Integer, Integer> totalCost) {
        List<Integer> newZeroIndegree = new ArrayList<>();
        Map<Integer, Integer> levelComponentCost = new HashMap<>();
        for (int zeroNode : zeroInDegree) {
            List<Integer> destinations = uf.outgoing[zeroNode];
            if (destinations != null) {
                for (int destination : destinations) {
                    if (--uf.inDegree[destination] == 0) {
                        newZeroIndegree.add(destination);
                    }
                }
            }
            levelComponentCost.merge(uf.find(zeroNode), uf.time[zeroNode], Integer::max);
        }
        levelComponentCost.forEach((k, v) -> totalCost.merge(k, v, Integer::sum));
        return newZeroIndegree;
    }

    private LinkedList<Integer> getInitialZeroIndegree(UnionFind unionFind) {
        LinkedList<Integer> zeroInDegree = new LinkedList<>();
        for (int i = 0; i < unionFind.inDegree.length; i++) {
            if (unionFind.inDegree[i] == 0) {
                zeroInDegree.add(i);
            }
        }
        return zeroInDegree;
    }

    private int getMaxCost(Map<Integer, Integer> componentTotalCost) {
        int maxCost = 0;
        for (int cost : componentTotalCost.values()) {
            maxCost = Math.max(maxCost, cost);
        }
        return maxCost;
    }

    private static class UnionFind {
        private final int[] inDegree;
        private final int[] root;
        private final int[] rank;
        private final int[] time;
        private final List<Integer>[] outgoing;

        public UnionFind(int n, int[][] relations, int[] time) {
            root = new int[n];
            rank = new int[n];
            inDegree = new int[n];
            outgoing = new List[n];
            this.time = time;
            for (int i = 1; i < n; i++) {
                root[i] = i;
            }
            setRelationsAndCost(relations, time);
        }

        private void setRelationsAndCost(int[][] relations, int[] time) {
            for (int[] relation : relations) {
                connect(relation[0] - 1, relation[1] - 1);
                inDegree[relation[1] - 1]++;
                if (outgoing[relation[0] - 1] == null) {
                    outgoing[relation[0] - 1] = new ArrayList<>();
                }
                outgoing[relation[0] - 1].add(relation[1] - 1);
            }
        }

        private int find(int node) {
            if(root[node] != node) {
                root[node] = find(root[node]);
            }
            return root[node];
        }

        private void connect(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 != root2) {
                if(rank[root1] > rank[root2]) {
                    root[root2] = root1;
                } else if (rank[root2] == rank[root1]) {
                    root[root2] = root1;
                    rank[root1]++;
                } else {
                    root[root1] = root2;
                }
            }
        }
    }
}
