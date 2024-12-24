package com.ss.leetcode.LC2024.december;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindMinimumDiameterAfterMergingTwoTrees {
    // https://leetcode.com/problems/find-minimum-diameter-after-merging-two-trees
    // LC as wrong answers!
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        return diameterOf(edges1) + diameterOf(edges2) + 1;
    }

    private int diameterOf(int[][] edges) {
        if (edges.length <= 1) {
            return edges.length;
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
        return lastSize == 1 ? layers - 1 : layers;
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
