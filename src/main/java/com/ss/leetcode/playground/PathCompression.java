package com.ss.leetcode.playground;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PathCompression {
    private int[] root;

    public PathCompression(int size) {
        root = new int[size];
        for (int i = 1; i < size; i++) {
            root[i] = i;
        }
    }

    public PathCompression(int size, int[][] edges) {
        this(size);
        for(int[] edge : edges) {
            connect(edge[0], edge[1]);
        }
    }

    public void connect(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        if (root1 != root2) {
            root[root2] = root1;
        }
    }

    public int find(int node) {
        if (node == root[node]) {
            return node;
        }
        int found = find(root[node]);
        root[node] = found;
        return found;
    }

    public boolean areConnected(int node1, int node2) {
        return find(node1) == find(node2);
    }

}
