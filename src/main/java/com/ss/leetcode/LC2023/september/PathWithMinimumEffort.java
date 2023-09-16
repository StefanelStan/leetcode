package com.ss.leetcode.LC2023.september;

public class PathWithMinimumEffort {
    // https://leetcode.com/problems/path-with-minimum-effort
    public int minimumEffortPath(int[][] heights) {
        int low = 0, high = 1000000, pivot;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            if (canBeCrossed(heights, pivot)) {
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
        }
        return low;
    }

    private boolean canBeCrossed(int[][] heights, int threshold) {
        UnionFind uf = new UnionFind(heights.length * heights[0].length);
        int nodeIndex = 1;
        // check line [0] only on i and i+1
        for (int j = 1; j < heights[0].length; j++) {
            if (Math.abs(heights[0][j] - heights[0][j - 1]) <= threshold) {
                uf.connect(nodeIndex - 1, nodeIndex);
            }
            nodeIndex++;
        }
        for (int i = 1; i < heights.length; i++) {
            // element [i][0] only needs to check up but all elements [i][j] need up and left
            if (Math.abs(heights[i][0] - heights[i - 1][0]) <= threshold) {
                uf.connect(nodeIndex, nodeIndex - heights[0].length);
            }
            nodeIndex++;
            for (int j = 1; j < heights[0].length; j++) {
                // up
                if (Math.abs(heights[i][j] - heights[i - 1][j]) <= threshold) {
                    uf.connect(nodeIndex, nodeIndex - heights[0].length);
                }
                // left
                if (Math.abs(heights[i][j] - heights[i][j - 1]) <= threshold) {
                    uf.connect(nodeIndex - 1, nodeIndex);
                }
                nodeIndex++;
            }
        }
        return uf.find(0) == uf.find(heights.length * heights[0].length - 1);
    }


    private static class UnionFind {
        int[] root;

        public UnionFind(int size) {
            root = new int[size];
            for (int i = 1; i < size; i++) {
                root[i] = i;
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
            if (node != root[node]) {
                root[node] = find(root[node]);
            }
            return root[node];
        }
    }
}
