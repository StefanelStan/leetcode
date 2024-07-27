package com.ss.leetcode.LC2024.july;

import java.util.ArrayList;
import java.util.List;

public class MinimumCostToConvertStringI {
    // https://leetcode.com/problems/minimum-cost-to-convert-string-i
    // TODO: make it faster (2400 ms)
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        UnionFind uf = getUnion(original, changed, cost);
        return determineMinCost(uf, source, target);
    }

    private long determineMinCost(UnionFind uf, String source, String target) {
        int codePoint1, codePoint2;
        boolean[][] computedRealCost = new boolean[26][26];
        long minCost = 0, currentCost = 0;
        for (int i = 0; i < source.length(); i++) {
            codePoint1 = source.charAt(i) - 'a';
            codePoint2 = target.charAt(i) - 'a';
            if (codePoint1 != codePoint2) {
                if (!uf.areConnected(codePoint1, codePoint2)) {
                    return -1;
                } else {
                    currentCost = determineMinCost(codePoint1, codePoint2, uf, computedRealCost);
                    if (currentCost == 0) {
                        return -1;
                    } else {
                        minCost += currentCost;
                    }
                }
            }
        }
        return minCost;
    }

    private long determineMinCost(int node1, int node2, UnionFind uf, boolean[][] computedRealCost) {
        if (!computedRealCost[node1][node2]) {
            travelOnPath(node1, node1, node2, 0L, new boolean[26], uf.costMatrix, uf.outgoings);
            computedRealCost[node1][node2] = true;
        }
        return uf.costMatrix[node1][node2];
    }

    private void travelOnPath(int current, int source, int target, long sumSoFar, boolean[] visited, long[][] costMatrix, List<Integer>[] outgoings) {
        if (current == target) {
            costMatrix[source][target] = costMatrix[source][target] == 0 ? sumSoFar : Math.min(costMatrix[source][target], sumSoFar);
        } else if (outgoings[current] != null && !visited[current]) {
            visited[current] = true;
            for (int next : outgoings[current]) {
                if (costMatrix[source][target] == 0 || costMatrix[source][target] > (sumSoFar + costMatrix[current][next])) {
                    travelOnPath(next, source, target, sumSoFar + costMatrix[current][next], visited, costMatrix, outgoings);
                }
            }
            visited[current] = false;
        }
    }

    private UnionFind getUnion(char[] original, char[] changed, int[] cost) {
        UnionFind uf = new UnionFind(26);
        uf.connect(original, changed, cost);
        return uf;
    }

    private static class UnionFind {
        int[] root;
        long[][] costMatrix;
        List<Integer>[] outgoings;

        public UnionFind(int size) {
            root = new int[size];
            outgoings = new List[26];
            costMatrix = new long[size][size];
            for (int i = 1; i < size; i++) {
                root[i] = i;
            }
        }

        public void connect(char[] original, char[] changed, int[] cost) {
            determineMinCost(original, changed, cost);
            connectAllNodes();
        }

        private void determineMinCost(char[] original, char[] changed, int[] cost) {
            int code1, code2;
            for (int i = 0; i < original.length; i++) {
                code1 = original[i] - 'a';
                code2 = changed[i] - 'a';
                costMatrix[code1][code2] = costMatrix[code1][code2] == 0 ? cost[i] : Math.min(costMatrix[code1][code2], cost[i]);
            }
        }

        private void connectAllNodes() {
            for (int i = 0; i < root.length; i++) {
                for (int j = 0; j < root.length; j++) {
                    if (costMatrix[i][j] > 0) {
                        connectNode(i, j);
                    }
                }
            }
        }

        private void connectNode(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if (outgoings[node1] == null) {
                outgoings[node1] = new ArrayList<>();
            }
            outgoings[node1].add(node2);
            if (root1 != root2) {
                root[root2] = root1;
            }
        }

        private int find(int node1) {
            if (root[node1] != node1) {
                root[node1] = find(root[node1]);
            }
            return root[node1];
        }

        public boolean areConnected(int node1, int node2) {
            return find(node1) == find(node2);
        }
    }
}
