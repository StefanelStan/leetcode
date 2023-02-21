package com.ss.leetcode.playground;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DfsTraversal {
    List[] nodes;
    public DfsTraversal(int n, int[][] edges) {
        nodes = new ArrayList[n];
        for (int[] edge : edges) {
            connect(edge[0], edge[1]);
        }
    }

    public List<Integer> traverse() {
        Random random = new Random();
        boolean[] visited = new boolean[nodes.length];
        List<Integer> traverse = new ArrayList<>();
        traverseAndAdd(random.nextInt(nodes.length), visited,  traverse);
        return traverse;
    }

    private void traverseAndAdd(int node, boolean[] visited, List<Integer> traverse) {
        if (!visited[node]) {
            visited[node] = true;
            traverse.add(node);
            List<Integer> connections = nodes[node];
            for (int connection : connections) {
                traverseAndAdd(connection, visited, traverse);
            }
        }
    }

    private void connect(int node1, int node2) {
        if (nodes[node1] == null) {
            nodes[node1] = new ArrayList<>();
        }
        nodes[node1].add(node2);
        if (nodes[node2] == null) {
            nodes[node2] = new ArrayList<>();
        }
        nodes[node2].add(node1);
    }
}
