package com.ss.leetcode.LC2023.february;

import java.util.ArrayList;
import java.util.List;

public class MinimumHeightTrees {
    // https://leetcode.com/problems/minimum-height-trees
    // NOT CORRECT!
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        PathCompressionUnionByRank pcubr = new PathCompressionUnionByRank(n);
        for(int[] edge : edges) {
            pcubr.connect(edge[0], edge[1]);
        }
        return pcubr.getMinHeightTrees();
    }

    private static class PathCompressionUnionByRank {
        int[] root;
        int[] rank;
        int maxHeight = 1;

        public PathCompressionUnionByRank(int n) {
            root = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        private void connect(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 != root2) {
                if (rank[root1] < rank[root2]) {
                    root[root1] = root2;
                } else if (rank[root1] > rank[root2]) {
                    root[root2] = root1;
                } else {
                    rank[root2] = root1;
                    rank[root1]++;
                }
                maxHeight = Math.max(maxHeight, Math.max(rank[root1], rank[root2]));
            }
        }

        private int find(int node) {
            if (root[node] == node) {
                return node;
            }
            int found = find(root[node]);
            root[node] = found;
            return found;
        }

        public List<Integer> getMinHeightTrees() {
            List<Integer> answer = new ArrayList<>();
            int sHeight = 1;
            List<Integer> second = new ArrayList<>();
            for(int i = 0; i < rank.length; i++) {
                if (rank[i] == maxHeight) {
                    answer.add(i);
                } else if (rank[i] > sHeight) {
                    sHeight = rank[i];
                    second.clear();
                    second.add(i);
                } else if (rank[i] == sHeight) {
                    second.add(i);
                }
            }
            answer.addAll(second);
            return answer;
        }
    }
}
