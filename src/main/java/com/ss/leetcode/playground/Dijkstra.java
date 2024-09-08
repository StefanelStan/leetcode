package com.ss.leetcode.playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    public int shortestPathCost(int nodes, int[][] edges, int source, int destination) {
        int[] lowestCost = new int[nodes];
        Arrays.fill(lowestCost, Integer.MAX_VALUE);
        int[] predecessors = new int[nodes];
        predecessors[source] = source;
        visitNodes(source, edges, lowestCost, predecessors);


        if (lowestCost[destination] != Integer.MAX_VALUE) {
            int destCopy = destination;
            List<Integer> chain = new ArrayList<>();
            chain.add(destCopy);
            while (source != destCopy) {
                chain.add(predecessors[destCopy]);
                destCopy = predecessors[destCopy];
            }
            System.out.println(chain.reversed());
        }
        return lowestCost[destination];
    }

    private void visitNodes(int source, int[][] edges, int[] lowestCost, int[] predecessors) {
        boolean[] visited = new boolean[lowestCost.length];
        List<NeighbourCost>[] outgoing = getOutgoing(lowestCost.length, edges);
        lowestCost[source] = 0;
        PriorityQueue<NeighbourCost> lowestCostNeighbour = new PriorityQueue<>(lowestCost.length * 2, Comparator.comparingInt(a -> a.cost()));
        lowestCostNeighbour.add(new NeighbourCost(0,0));
        NeighbourCost currentNode;
        while(!lowestCostNeighbour.isEmpty()) {
            currentNode = lowestCostNeighbour.poll();
            if(!visited[currentNode.neighbour] && outgoing[currentNode.neighbour] != null) {
                for (NeighbourCost next : outgoing[currentNode.neighbour]) {
                    if (lowestCost[currentNode.neighbour] != Integer.MAX_VALUE && lowestCost[currentNode.neighbour] + next.cost < lowestCost[next.neighbour]) {
                        lowestCost[next.neighbour] = lowestCost[currentNode.neighbour] + next.cost;
                        predecessors[next.neighbour] = currentNode.neighbour;
                        lowestCostNeighbour.add(new NeighbourCost(next.neighbour, lowestCost[next.neighbour]));
                    }
                }
                visited[currentNode.neighbour] = true;
            }
        }
    }

    private List<NeighbourCost>[] getOutgoing(int n, int[][] edges) {
        List<NeighbourCost>[] outgoing = new List[n];
        for (int[] edge : edges) {
            if (outgoing[edge[0]] == null) {
                outgoing[edge[0]] = new ArrayList<>();
            }
            outgoing[edge[0]].add(new NeighbourCost(edge[1], edge[2]));
        }
        return outgoing;
    }

    private record NeighbourCost(int neighbour, int cost) {}
}
