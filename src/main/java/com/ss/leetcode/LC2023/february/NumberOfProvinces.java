package com.ss.leetcode.LC2023.february;

public class NumberOfProvinces {
    // https://leetcode.com/problems/number-of-provinces
    // Quick Union - Path Compression Union By Rank
    /** Algorithm: Quick Union - Path Compression
        1. Apply Quick Union with Path Compression to mark the connections and their parent root;
        2. Traverse the root[] array and count how many unique/distinct roots you have (index == root[index])
        3. Return the result of #2.
     */
    public int findCircleNum(int[][] isConnected) {
        int[] root = new int[isConnected.length];
        int[] rank = new int[isConnected.length];
        buildDefaultRoot(root, rank);
        connectProvinces(root, rank, isConnected);
        return countProvinces(root);
    }

    private void connectProvinces(int[] root, int[] rank, int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                if (edges[i][j] == 1) {
                    connect(i, j, root, rank);
                }
            }
        }
    }

    private void connect(int node1, int node2, int[] root, int[] rank) {
        int root1 = find(node1, root);
        int root2 = find(node2, root);
        if (root1 != root2) {
            if (rank[root1] > rank[root2]) {
                root[root2] = root1;
            } else if (rank[root1] < rank[root2]) {
                root[root1] = root2;
            } else {
                root[root2] = root1;
                rank[root1]++;
            }
        }
    }

    private int find(int node, int[] root) {
        if (node == root[node]) {
            return node;
        }
        int found = find(root[node], root);
        root[node] = found;
        return found;
    }

    private void buildDefaultRoot(int[] root, int[] rank) {
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    private int countProvinces(int[] root) {
        int provinces = 0;
        for (int i = 0; i < root.length; i++) {
            if (root[i] == i) {
                provinces++;
            }
        }
        return provinces;
    }

    /**
    public int findCircleNum(int[][] isConnected) {
        int[] root = new int[isConnected.length];
        buildDefaultRoot(root);
        connectProvinces(root, isConnected);
        return countProvinces(root);
    }

    private void connectProvinces(int[] root, int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                if (edges[i][j] == 1) {
                    connect(i, j, root);
                }
            }
        }
    }

    private void connect(int node1, int node2, int[] root) {
        int root1 = find(node1, root);
        int root2 = find(node2, root);
        if (root1 != root2) {
            root[root2] = root1;
        }
    }

    private int find(int node, int[] root) {
        if (node == root[node]) {
            return node;
        }
        int found = find(root[node], root);
        root[node] = found;
        return found;
    }

    private void buildDefaultRoot(int[] root) {
        for (int i = 1; i < root.length; i++) {
            root[i] = i;
        }
    }

    private int countProvinces(int[] root) {
        int provinces = 0;
        for (int i = 0; i < root.length; i++) {
            if (root[i] == i) {
                provinces++;
            }
        }
        return provinces;
    }
     */
}
