package com.ss.leetcode.LC2024.december;

import java.util.List;
import java.util.ArrayList;

public class MaximumNumberOfKDivisibleComponents {
    // https://leetcode.com/problems/maximum-number-of-k-divisible-components
    /** Algorithm
        1. Fail fast: if n == 1, return values[0] % k.
        2. Else, build a List<Integer>[] of connections, from node 1 to each neighbour.
        3. Find a possible root. A root can be a node that is a leaf (connections[node].size() == 1). That node has only 1 connection
        4. Traverse the n-ary tree in POST order using DFS function. the function will return the sum of the subtree.
            - from current node check all the unvisited connections and sum up their subtree sum
            - if subtreesum is divisible by 0, then increment components and return 0, as this subtree will be disconnected.
            - else return the subtree sum, as it might be used upstream to be added with others to come up with a sum divisible by k.
     */
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        if (n == 1) {
            return values[0] % k == 0 ? 1 : 0;
        }
        List<Integer>[] connections = getConnections(n, edges);
        int root = getRoot(connections);
        int[] maxComponents = {0};
        traverseTree(root, connections, new boolean[n], values, k, maxComponents);
        return maxComponents[0];
    }

    private long traverseTree(int node, List<Integer>[] connections, boolean[] visited, int[] values, int k, int[] maxComponents) {
        if (node == -1) {
            return 0;
        }
        long subtreeSum = values[node];
        visited[node] = true;
        for (int next : connections[node]) {
            if (!visited[next]) {
                subtreeSum += traverseTree(next, connections, visited, values, k, maxComponents);
            }
        }
        if (subtreeSum % k == 0) {
            maxComponents[0]++;
            subtreeSum = 0;
        }
        return subtreeSum;
    }

    private List<Integer>[] getConnections(int n, int[][] edges) {
        List<Integer>[] connections = new List[n];
        for (int[] edge : edges) {
            if (connections[edge[0]] == null) {
                connections[edge[0]] = new ArrayList<>();
            }
            if (connections[edge[1]] == null) {
                connections[edge[1]] = new ArrayList<>();
            }
            connections[edge[0]].add(edge[1]);
            connections[edge[1]].add(edge[0]);
        }
        return connections;
    }

    private int getRoot(List<Integer>[] connections) {
        for (int i = 0 ; i < connections.length; i++) {
            if (connections[i].size() == 1) {
                return i;
            }
        }
        return -1;
    }
}
