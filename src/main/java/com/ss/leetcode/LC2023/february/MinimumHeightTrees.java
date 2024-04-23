package com.ss.leetcode.LC2023.february;

import java.util.ArrayList;
import java.util.List;

public class MinimumHeightTrees {
    // https://leetcode.com/problems/minimum-height-trees
    /** Algorithm
        1. Look at the nodes from a centric POV: the leafs are on thr edge ring, their parents on edge -1...
        2. The most "balanced"/centric root will be right at the middle
        3. Applying Topological sort will eliminate one layer of parents until you reach the core
        4. That core will be the root of the tree that will have the min height
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(0);
        } else if (n == 2) {
            return List.of(0, 1);
        }
        return findMinTrees(n, edges);
    }

    private List<Integer> findMinTrees(int n, int[][] edges) {
        List<Integer>[] neighbours = new List[n];
        int[] indegree = new int[n];
        List<Integer> currentNodes = new ArrayList<>();
        List<Integer> nextNodes;
        getNeighboursAndIndegree(neighbours, indegree, edges, currentNodes);
        boolean finished = false;
        while(!finished) {
            nextNodes = new ArrayList<>();
            for (int currentNode : currentNodes) {
                for (int nextNode : neighbours[currentNode]) {
                    indegree[nextNode]--;
                    if (indegree[nextNode] == 1) {
                        nextNodes.add(nextNode);
                    }
                }
            }
            if (nextNodes.isEmpty()) {
                finished = true;
            } else {
                currentNodes = nextNodes;
            }
        }
        return currentNodes;
    }

    private void getNeighboursAndIndegree(List<Integer>[] neighbours, int[] indegree, int[][] edges, List<Integer> leafs) {
        for (int[] edge : edges) {
            if (neighbours[edge[0]] == null) {
                neighbours[edge[0]] = new ArrayList<>();
            }
            if (neighbours[edge[1]] == null) {
                neighbours[edge[1]] = new ArrayList<>();
            }
            neighbours[edge[0]].add(edge[1]);
            neighbours[edge[1]].add(edge[0]);
        }
        for (int i = 0; i < neighbours.length; i++) {
            indegree[i] = neighbours[i].size();
            if (indegree[i] == 1) {
                leafs.add(i);
            }
        }
    }













    // NOT CORRECT!
    public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
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
