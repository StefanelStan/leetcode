package com.ss.leetcode.LC2023.june;

import java.util.ArrayList;
import java.util.List;

public class PathWithMaximumProbability {
    // https://leetcode.com/problems/path-with-maximum-probability
    // Needs optimisation Dijkstra / SPFA
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        UnionFind uf = new UnionFind(n);
        double[] inProbability = new double[n];
        List<ProbabilityNode>[] connections = new List[n];
        populateProbabilities(edges, succProb, connections, uf);
        if (uf.areConnected(start, end)) {
            for (ProbabilityNode node : connections[start]) {
                travelTo(node, 1, end, inProbability, connections);
            }
        }
        return inProbability[end];
    }

    private void populateProbabilities(int[][] edges, double[] succProb, List<ProbabilityNode>[] connections, UnionFind uf) {
        int[] edge;
        for (int i = 0; i < edges.length; i++) {
            edge = edges[i];
            if (connections[edge[0]] == null) {
                connections[edge[0]] = new ArrayList<>();
            }
            connections[edge[0]].add(new ProbabilityNode(edge[1], succProb[i]));
            if (connections[edge[1]] == null) {
                connections[edge[1]] = new ArrayList<>();
            }
            connections[edge[1]].add(new ProbabilityNode(edge[0], succProb[i]));
            uf.connect(edge[0], edge[1]);
        }
    }

    private void travelTo(ProbabilityNode to, double costSoFar, int end,  double[] inProbability, List<ProbabilityNode>[] connections) {
        double nextCost = costSoFar * to.probability;
        if (to.to == end) {
            inProbability[end] = Math.max(inProbability[end], nextCost);
        } else if (inProbability[to.to] < nextCost && nextCost > inProbability[end]) {
            inProbability[to.to] = nextCost;
            List<ProbabilityNode> nextNodes = connections[to.to];
            if (nextNodes != null) {
                for (ProbabilityNode node : nextNodes) {
                    travelTo(node, nextCost, end, inProbability, connections);
                }
            }
        }
    }

    private static class ProbabilityNode {
        int to;
        double probability;
        public ProbabilityNode(int to, double probability) {
            this.to = to;
            this.probability = probability;
        }
    }

    private static class UnionFind {
        int[] root;
        public UnionFind(int n) {
            root = new int[n];
            for(int i = 1; i < n; i++) {
                root[i] = i;
            }
        }

        private boolean areConnected(int node1, int node2) {
            return find(node1) == find(node2);
        }

        private void connect(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 != root2) {
                root[root2] = root1;
            }
        }

        private int find(int node) {
            if(node != root[node]) {
                root[node] = find(root[node]);
            }
            return root[node];
        }
    }
}
