package com.ss.leetcode.LC2024.january;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReachableNodesWithRestrictions {
    // https://leetcode.com/problems/reachable-nodes-with-restrictions
    /** Algorithm
        1. Mark the restricted nodes on a boolean[n] visited. Those nodes won't be visitable either
        2. Get the adjacency List<Integer>[n] for each node.
            - As an optimization, if any of the two nodes are visited (restricted) do not add the pair.
        3. Apply BFS from adjacency[0] and increment reachable nodes with each node you visit.
     */
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        boolean[] visited = getVisited(n, restricted);
        List<Integer>[] outgoing = getOutgoing(n, visited, edges);
        return countReachableNodes(outgoing, visited);
    }

    private int countReachableNodes(List<Integer>[] outgoing, boolean[] visited) {
        LinkedList<Integer> nodesToVisit = new LinkedList<>();
        nodesToVisit.addLast(0);
        visited[0] = true;
        List<Integer> nextNodes;
        int reachedNodes = 0;
        while(!nodesToVisit.isEmpty()) {
            reachedNodes++;
            nextNodes = outgoing[nodesToVisit.removeFirst()];
            if (nextNodes != null) {
                for (int nextNode : nextNodes) {
                    if (!visited[nextNode]) {
                        visited[nextNode] = true;
                        nodesToVisit.addLast(nextNode);
                    }
                }
            }
        }
        return reachedNodes;
    }

    private List<Integer>[] getOutgoing(int n, boolean[] visited, int[][] edges) {
        List<Integer>[] outgoing = new List[n];
        for (int[] edge : edges) {
            if (!visited[edge[0]] && !visited[edge[1]]) {
                if (outgoing[edge[0]] == null) {
                    outgoing[edge[0]] = new ArrayList<>();
                }
                if (outgoing[edge[1]] == null) {
                    outgoing[edge[1]] = new ArrayList<>();
                }
                outgoing[edge[0]].add(edge[1]);
                outgoing[edge[1]].add(edge[0]);
            }
        }
        return outgoing;
    }

    private boolean[] getVisited(int n, int[] restricted) {
        boolean[] visited = new boolean[n];
        Arrays.stream(restricted).forEach(r -> visited[r] = true);
        return visited;
    }
}
