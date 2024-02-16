package com.ss.leetcode.LC2024.february;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {
    // https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<NeighbourNode>[] outgoing = getOutgoing(n, edges);
        int min = n + 1, greatestCity = 0;
        for (int i = 0; i < n; i++) {
            ReachableNode rn = findReachableNodes(i, outgoing, n, distanceThreshold);
            if (rn.size < min) {
                min = rn.size;
                greatestCity = i;
            } else if (rn.size == min) {
                greatestCity = i;
            }
        }
        return greatestCity;
    }

    private ReachableNode findReachableNodes(int nodeIndex, List<NeighbourNode>[] outgoing, int n, int threshold) {
        ReachableNode node = new ReachableNode(n, nodeIndex);
        if (outgoing[nodeIndex] != null) {
            for (NeighbourNode next : outgoing[nodeIndex]) {
                visitNextNode(node, next, outgoing, threshold - next.cost);
            }
        }
        return node;
    }

    private void visitNextNode(ReachableNode source, NeighbourNode current, List<NeighbourNode>[] outgoing, int remaining) {
        if (source.visitedCost(current.index) >= remaining) {
            return;
        }
        source.visitNode(current.index, remaining);
        if (outgoing[current.index] != null) {
            for (NeighbourNode next : outgoing[current.index]) {
                visitNextNode(source, next, outgoing, remaining - next.cost);
            }
        }
    }

    private List<NeighbourNode>[] getOutgoing(int n, int[][] edges) {
        List<NeighbourNode>[] outgoing = new List[n];
        for (int[] edge : edges) {
            if (outgoing[edge[0]] == null) {
                outgoing[edge[0]] = new ArrayList<>();
            }
            if (outgoing[edge[1]] == null) {
                outgoing[edge[1]] = new ArrayList<>();
            }
            outgoing[edge[0]].add(new NeighbourNode(edge[1], edge[2]));
            outgoing[edge[1]].add(new NeighbourNode(edge[0], edge[2]));
        }
        return outgoing;
    }

    private static class ReachableNode {
        int[] visitedWithCost;
        int size;
        public ReachableNode(int n, int source) {
            visitedWithCost = new int[n];
            Arrays.fill(visitedWithCost, -1);
            visitedWithCost[source] = 50000;
            size = 1;
        }

        public void visitNode(int node, int cost) {
            if(visitedWithCost[node] == -1) {
                size++;
            }
            visitedWithCost[node] = cost;
        }

        public int visitedCost(int node) {
            return visitedWithCost[node];
        }
    }

    private static class NeighbourNode {
        int index;
        int cost;
        public NeighbourNode(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
}
