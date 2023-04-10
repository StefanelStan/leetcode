package com.ss.leetcode.playground;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DFSTopologicalSort {
    private List[] connections;
    public DFSTopologicalSort(int n, int[][] edges) {
        connections = new List[n];
        for (int[] edge : edges) {
            connect(edge[0], edge[1]);
        }
    }

    public List<Integer> getTopologicalSort() {
        List<Integer> postOrder = new ArrayList<>(connections.length);
        traversePostOder(0, new boolean[connections.length], postOrder);
        Collections.reverse(postOrder);
        return postOrder;
    }

    private void traversePostOder(int node, boolean[] visited, List<Integer> postOrder) {
        if (!visited[node]) {
            visited[node] = true;
            if (connections[node] != null) {
                List<Integer> outgoing = connections[node];
                for (int out : outgoing) {
                    traversePostOder(out, visited, postOrder);
                }
            }
            postOrder.add(node);
        }
    }


    private void connect(int from, int to) {
        if (connections[from] == null) {
            connections[from] = new ArrayList<Integer>();
        }
        connections[from].add(to);
    }
}
