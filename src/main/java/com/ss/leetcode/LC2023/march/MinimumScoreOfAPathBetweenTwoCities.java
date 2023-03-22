package com.ss.leetcode.LC2023.march;

public class MinimumScoreOfAPathBetweenTwoCities {
    // https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities
    private UnionFind uf;
    public int minScore(int n, int[][] roads) {
        uf = new UnionFind(n);
        for (int[] road: roads) {
            uf.connect(road[0], road[1], road[2]);
        }
        while(n >= 1) {
            uf.find(n, 10001);
            n--;
        }
        return uf.getMin(1);
    }

    private static class UnionFind {
        int[] root;
        int[] rank;
        int[] cost;

        public UnionFind(int n) {
            root = new int[n+1];
            rank = new int[n+1];
            cost = new int[n+1];
            for (int i = 1; i <= n; i++) {
                root[i] = i;
                rank[i] = 1;
                cost[i] = 10001;
            }
        }

        private void connect(int node1, int node2, int roadCost) {
            int minFound = Math.min(Math.min(cost[node1], cost[node2]), roadCost);
            int root1 = find(node1, minFound);
            int root2 = find(node2, minFound);
            int minRoot = Math.min(cost[root1], cost[root2]);
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
            cost[root1] = minRoot;
            cost[root2] = minRoot;
        }


        private int find(int node, int min) {
            if (root[node] == node) {
                cost[node] = Math.min(cost[node], min);
                return node;
            }
            int found = find(root[node], min);
            root[node] = found;
            cost[node] = Math.min(min, cost[found]);
            return found;
        }

        public int getMin(int node) {
            return cost[node];
        }
    }
}
