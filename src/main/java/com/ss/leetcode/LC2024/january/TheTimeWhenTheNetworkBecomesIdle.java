package com.ss.leetcode.LC2024.january;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TheTimeWhenTheNetworkBecomesIdle {
    // https://leetcode.com/problems/the-time-when-the-network-becomes-idle
    /** Algorithm
        1. Build your adjacency list for each node
        2. Using BFS create, mark and save the distance from 0 to all other node: distances[i]
        3. For each node (distance[i], patience[i]) determine when the node will "finish" messaging
        4. The max finishingtime + 1 will mark the moment the network is quiet
        5. Knowing distance or twoWayDistance and patience, apply math to determine
            - if twoWay <= patience, then the node will finish before sending another message
            - if twoWay % patience == 0 (mod), then your node has sent more messages and is "about" to send a new nth message
                when your 1st message arrives back. So it will finish in twoWay + twoWay -  patience.
            - else return 2 * twoWay - mod; EG: distance = 6, (twoWay = 12) and patience = 5.
            - When the first message arrives back, the last message has travelled 2 steps, so it finishes in twoWay (1st message) + twoWay - mod (the last message that has already travelled 2 steps).
     */
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        List<Integer>[] outgoing = getOutgoing(patience.length, edges);
        int[] distances = getDistances(outgoing);
        return getEarliestTime(distances, patience);
    }

    private int getEarliestTime(int[] distances, int[] patience) {
        int finishingTime = -1;
        for (int i = 1; i < distances.length; i++) {
            finishingTime = Math.max(finishingTime, getFinishingTime(distances[i], patience[i]));
        }
        return finishingTime + 1;
    }

    private int getFinishingTime(int distance, int patience) {
        if (distance * 2 <= patience) {
            return distance * 2;
        }
        int twoWay = distance * 2;
        int mod = twoWay % patience;
        if (mod == 0) {
            return 2 * twoWay - patience;
        } else {
            return 2 * twoWay - mod;
        }
    }

    private int[] getDistances(List<Integer>[] outgoing) {
        int[] distances = new int[outgoing.length];
        boolean[] visited = new boolean[distances.length];
        LinkedList<int[]> onQueue = new LinkedList<>();
        int[] head; // nodeId, timeId
        visited[0] = true;
        onQueue.addLast(new int[]{0, 0});
        while(!onQueue.isEmpty()) {
            head = onQueue.removeFirst();
            for (int neighbour : outgoing[head[0]]) {
                if (!visited[neighbour]) {
                    distances[neighbour] = head[1] + 1;
                    onQueue.addLast(new int[]{neighbour, head[1] + 1});
                    visited[neighbour] = true;
                }
            }
        }
        return distances;
    }

    private List<Integer>[] getOutgoing(int n, int[][] edges) {
        List<Integer>[] outgoing = new List[n];
        for (int[] edge : edges) {
            if(outgoing[edge[0]] == null) {
                outgoing[edge[0]] = new ArrayList<>();
            }
            if (outgoing[edge[1]] == null) {
                outgoing[edge[1]] = new ArrayList<>();
            }
            outgoing[edge[0]].add(edge[1]);
            outgoing[edge[1]].add(edge[0]);
        }
        return outgoing;
    }
}
