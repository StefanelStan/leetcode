package com.ss.leetcode.LC2024.may;

import java.util.List;

public class FindTheSafestPathInAGrid {
    // https://leetcode.com/problems/find-the-safest-path-in-a-grid
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        if (grid.getFirst().getFirst() == 1 || grid.getLast().getLast() == 1) {
            return 0;
        }
        int[][] safenessScore = getSafenessScore(grid);
        return findMaxSafenessFactor(safenessScore, grid);
    }

    private int[][] getSafenessScore(List<List<Integer>> grid) {
        int[][] safenessScore = new int[grid.size()][grid.size()];
        int vertical, horizontal;
        for (int i = 0; i < safenessScore.length; i++) {
            for (int j = 0; j < safenessScore.length; j++) {
                if (grid.get(i).get(j) == 1) {
                    safenessScore[i][j] = 0;
                } else {
                    vertical = i - 1 >= 0 ? safenessScore[i - 1][j]: 500;
                    horizontal = j - 1 >= 0 ? safenessScore[i][j - 1]: 500;
                    safenessScore[i][j] = 1 + Math.min(vertical, horizontal);
                }
            }
        }
        for (int i = grid.size() - 1; i >= 0; i--) {
            for (int j = grid.size() - 1; j >= 0; j--) {
                if (grid.get(i).get(j) == 0) {
                    vertical = i + 1 < safenessScore.length ? safenessScore[i+1][j] : 500;
                    horizontal = j + 1 < safenessScore.length ? safenessScore[i][j+1] : 500;
                    safenessScore[i][j] = Math.min(safenessScore[i][j], 1 + Math.min(vertical, horizontal));
                }
            }
        }
        return safenessScore;
    }

    private int findMaxSafenessFactor(int[][] safenessScore, List<List<Integer>> grid) {
        int low = 0, high = 1000, pivot;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            if (canBeTraversed(safenessScore, grid, pivot)) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }
        return high == -1 ? 0 : high;
    }

    private boolean canBeTraversed(int[][] safenessScore, List<List<Integer>> grid, int maxValue) {
        if (safenessScore[0][0] < maxValue || safenessScore[safenessScore.length -1][safenessScore.length -1] < maxValue) {
            return false;
        }
        int nodeIndex = 0;
        UnionFind uf = new UnionFind(safenessScore.length * safenessScore.length);
        for (int i = 0; i < safenessScore.length; i++) {
            for (int j = 0; j < safenessScore.length; j++) {
                // connect right
                if (j + 1 < safenessScore.length && grid.get(i).get(j) == 0 && grid.get(i).get(j + 1) == 0 &&
                    safenessScore[i][j] >= maxValue && safenessScore[i][j + 1] >= maxValue) {
                    uf.connect(nodeIndex, nodeIndex + 1);
                }
                // connect down
                if (i + 1 < safenessScore.length && grid.get(i).get(j) == 0 && grid.get(i + 1).get(j) == 0 &&
                    safenessScore[i][j] >= maxValue && safenessScore[i + 1][j] >= maxValue) {
                    uf.connect(nodeIndex, nodeIndex + grid.size());
                }
                nodeIndex++;
            }
        }
        return uf.areConnected();
    }

    private static class UnionFind {
        int[] root;
        public UnionFind(int n) {
            root = new int[n];
            for (int i = 1; i < n; i++) {
                root[i] = i;
            }
        }

        private void connect(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 != root2) {
                root[root2] = root1;
            }
        }

        public boolean areConnected() {
            return find(0) == find(root.length - 1);
        }

        private int find(int node) {
            if (root[node] != node) {
                root[node] = find(root[node]);
            }
            return root[node];
        }
    }
}
