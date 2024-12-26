package com.ss.leetcode.LC2024.december;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindMinimumDiameterAfterMergingTwoTrees {
    // https://leetcode.com/problems/find-minimum-diameter-after-merging-two-trees
    /** Algorithm
        1. Build a List[] of connections for each edge/node and also determine the degree of each node.
        2. The nodes will indegree 1 will be leafs.
        3. Use BFS to "pluck" the leafs from the tree, peeling one layer at a time, similar to doing Kahn Topological Sort.
            - Keep count of layers
        4. When you reach the "center" of the tree, you might have 1 or 2 more nodes as "core".
            - if you have a core of 1, then your half diameter is layers - 1 and diameter is 2 * layers - 2.
            - for a core of 2+ nodes: half diameter = layers, diameter = 2 * layers - 1
        5. Your answer is either the max diameter of T1, T2 Or halfDiameterT1 + halfDiamT2 + 1;
     */
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int[] diameter1 = diameterOf(edges1);
        int[] diameter2 = diameterOf(edges2);

        return Math.max(diameter1[0] + diameter2[0] + 1, Math.max(diameter1[1], diameter2[1]));
    }

    private int[] diameterOf(int[][] edges) {
        if (edges.length <= 1) {
            return new int[]{edges.length, edges.length};
        }
        int[] degrees = new int[edges.length + 1];
        List<Integer>[] connections = new List[edges.length + 1];
        populateGraphData(edges, connections, degrees);
        boolean[] visited = new boolean[edges.length + 1];
        LinkedList<Integer> nodes = getLeafs(visited, degrees);
        int size, lastSize = 0, layers = 0, currentNode;
        while (!nodes.isEmpty()) {
            size = lastSize = nodes.size();
            layers++;
            while (size > 0) {
                currentNode = nodes.removeFirst();
                degrees[currentNode]--;
                if (connections[currentNode] != null) {
                    for (int nextNode : connections[currentNode]) {
                        degrees[nextNode]--;
                        if (degrees[nextNode] == 1 && !visited[nextNode]) {
                            visited[nextNode] = true;
                            nodes.addLast(nextNode);
                        }
                    }
                }
                size--;
            }
        }
        int halfDiameter = lastSize == 1 ? layers - 1 : layers;
        int totalDiameter = lastSize == 1 ? 2 * layers - 2 : 2 * layers - 1;
        return new int[]{halfDiameter, totalDiameter};

    }

    private LinkedList<Integer> getLeafs(boolean[] visited, int[] indegree) {
        LinkedList<Integer> nodes = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 1) {
                nodes.addLast(i);
                visited[i] = true;
            }
        }
        return nodes;
    }

    private void populateGraphData(int[][] edges, List<Integer>[] connections, int[] degrees) {
        for (int[] edge : edges) {
            if (connections[edge[0]] == null) {
                connections[edge[0]] = new ArrayList<>();
            }
            if (connections[edge[1]] == null) {
                connections[edge[1]] = new ArrayList<>();
            }
            connections[edge[0]].add(edge[1]);
            connections[edge[1]].add(edge[0]);
            degrees[edge[0]]++;
            degrees[edge[1]]++;
        }
    }
}
