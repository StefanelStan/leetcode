package com.ss.leetcode.LC2023.july;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindEventualSafeStates {
    // https://leetcode.com/problems/find-eventual-safe-states
    /** Algorithm
        1. Apply Kahn topological sort but instead of looking for inDegree, look for outDegree
        2. Nodes with no outdegree are terminal nodes, so they can be added to terminalNodes list
        3. For each terminal node from list, disconnect the incoming nodes, decreasing their outDegree by 1.
        4. When a node gets fully disconnected (outDegree reaches 0), add it to list and disconnect its incoming connections
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] outDegree = new int[graph.length];
        List<Integer>[] incoming = new List[graph.length];
        connect(graph, outDegree, incoming);
        return getEventualSafeNodes(outDegree, incoming);
    }

    private List<Integer> getEventualSafeNodes(int[] outDegree, List<Integer>[] incoming) {
        List<Integer> order = getNoOutgoingNodes(outDegree);
        int from = 0, length = 0;
        while(order.size() < incoming.length && length != order.size()) {
            length = order.size();
            for(int i = from; i < order.size(); i++) {
                if (outDegree[order.get(i)] != -1) {
                    List<Integer> incomingNodes = incoming[order.get(i)];
                    if(incomingNodes != null) {
                        for (int incomingNode : incomingNodes) {
                            outDegree[incomingNode]--;
                            if (outDegree[incomingNode] == 0) {
                                order.add(incomingNode);
                            }
                        }
                    }
                    outDegree[order.get(i)] = -1;
                }
                from = Math.max(from, i);
            }
        }
        Collections.sort(order);
        return order;
    }

    private void connect(int[][] graph, int[] outDegree, List<Integer>[] incoming) {
        for (int i = 0; i < graph.length; i++) {
            outDegree[i] += graph[i].length;
            for (int destination : graph[i]) {
                if(incoming[destination] == null) {
                    incoming[destination] = new ArrayList<>();
                }
                incoming[destination].add(i);
            }
        }
    }

    private List<Integer> getNoOutgoingNodes(int[] outDegree) {
        List<Integer> noOutgoing = new ArrayList<>();
        for (int i = 0; i < outDegree.length; i++) {
            if (outDegree[i] == 0) {
                noOutgoing.add(i);
            }
        }
        return noOutgoing;
    }
}
