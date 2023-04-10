package com.ss.leetcode.playground;

import java.util.ArrayList;
import java.util.List;

public class KahnTopologicalSort {
    private List[] outgoing;
    private int[] indegree;
    public KahnTopologicalSort(int n, int[][] edges) {
        outgoing = new List[n];
        indegree = new int[n];
        for(int[] edge : edges) {
            connect(edge[0], edge[1]);
        }
    }

    private void connect(int from, int to) {
        if (outgoing[from] == null) {
            outgoing[from] = new ArrayList<Integer>();
        }
        outgoing[from].add(to);
        indegree[to]++;
    }

    public List<Integer> getTopologicalSort() {
        List<Integer> order = getNoIncoming();
        int from = 0;
        while(order.size() < outgoing.length) {
            int length = order.size();
            for (int i = from; i < length; i++) {
                if (indegree[order.get(i)] != -1) {
                    List<Integer> outgoingNodes = outgoing[order.get(i)];
                    if (outgoingNodes != null)
                        for (int outgoingNode : outgoingNodes) {
                            indegree[outgoingNode]--;
                            if (indegree[outgoingNode] == 0) {
                                order.add(outgoingNode);
                            }
                    }
                    indegree[order.get(i)] = -1;
                    from = Math.max(from, i);
                } else {
                    from = Math.max(from, i);
                }
            }
            if (length == order.size()) { // cycle. None has 0 inDegree.
                break;
            }
        }
        return order;
    }

    private List<Integer> getNoIncoming() {
        List<Integer> order = new ArrayList<>(outgoing.length);
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                order.add(i);
            }
        }
        return order;
    }
}
