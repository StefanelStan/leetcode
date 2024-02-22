package com.ss.leetcode.LC2024.february;

import java.util.HashMap;
import java.util.Map;

public class MinimizeHammingDistanceAfterSwapOperations {
    // https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations
    /** Algorithm
        1. UnionFind / DisjointSet: if several swaps are part of the SAME set/union, then the positions can be swapped in any PERMUTATION.
        2. Apply union find the get the collections/set of each disjoint set:
            - eg: set1: [pos1, pos3, pos4], set2: [pos2, pos5, pos6]
        3. As you have these, count/check if you have the same numbers in source/target for each disjoint set
            - set1: target[pos1,pos3,pos4] vs source[pos1,pos3,pos4]
            - set2: target[pos2,pos5,pos6] vs source[pos2,pos5,pos6].
        4. Consider if you need to split the difference in two: eg: [2,1,3] and [1,2,4] have a hamming distance of 1!
    */
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        UnionFind uf = new UnionFind(source.length, allowedSwaps);
        Map<Integer, DisjointSetDifference> disjointDifference = getDisjointDifference(uf, source, target);
        int minDistance = 0;
        for (DisjointSetDifference dsd : disjointDifference.values()) {
            minDistance += computeDistance(dsd);
        }
        return minDistance;
    }

    private int computeDistance(DisjointSetDifference dsd) {
        int missingOut = 0;
        for (int diff : dsd.collection.values()) {
            missingOut += Math.abs(diff);
        }
        return missingOut / 2;
    }

    private Map<Integer, DisjointSetDifference> getDisjointDifference(UnionFind uf, int[] source, int[] target) {
        Map<Integer, DisjointSetDifference> disjointDifference = new HashMap<>();
        int rootOfNode;
        for (int i = 0; i < source.length; i++) {
            rootOfNode = uf.find(i);
            DisjointSetDifference dsd = disjointDifference.computeIfAbsent(rootOfNode, dj -> new DisjointSetDifference());
            dsd.addToCollection(source[i], target[i]);
        }
        return disjointDifference;
    }

    private static class DisjointSetDifference {
        Map<Integer, Integer> collection;

        public DisjointSetDifference() {
            collection = new HashMap<>();
        }

        public void addToCollection(int source, int target) {
            collection.merge(source, 1, Integer::sum);
            collection.merge(target, -1, Integer::sum);
        }
    }

    private static class UnionFind {
        int[] root;

        public UnionFind(int n, int[][] connections) {
            root = new int[n];
            for(int i = 1; i < n; i++) {
                root[i] = i;
            }
            for(int[] connection : connections) {
                connect(connection[0], connection[1]);
            }
        }

        private void connect(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 != root2) {
                root[root2] = root1;
            }
        }

        public int find(int node) {
            if (root[node] != node) {
                root[node] = find(root[node]);
            }
            return root[node];
        }
    }
}
