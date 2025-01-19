package com.ss.leetcode.LC2025.january;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumStarSumOfAGraph {
    // https://leetcode.com/problems/maximum-star-sum-of-a-graph
    /** Algorithm
        1. Get a list of neighbours for each node; only add connections if the target value is > 0. No point in connecting negative nodes.
        2. For each node i [0, n-1]
            - set maxSum = max(maxsum, vals[i])
            - if the node has neighbours/connections, get the max Star sum of best k neighbours
        3. Use a PQ to put the nodes, comparing their value
            - if queue has size > k, remove the head, subtracting its value from the node's star sum.
     */
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int maxSum = Integer.MIN_VALUE;
        List<Integer>[] connections = getConnections(vals, edges);
        for (int i = 0; i < vals.length; i++) {
            maxSum = Math.max(maxSum, vals[i]);
            if (connections[i] != null && k > 0) {
                maxSum = Math.max(maxSum, vals[i] + getMaxStarSum(connections[i], vals, k));
            }
        }
        return maxSum;
    }

    private int getMaxStarSum(List<Integer> nodes, int[] vals, int k) {
        int sum = 0;
        PriorityQueue<Integer> highest = new PriorityQueue<>(Comparator.comparingInt(a -> vals[a]));
        for (int node : nodes) {
            highest.add(node);
            sum += vals[node];
            if (highest.size() > k) {
                sum -= vals[highest.poll()];
            }
        }
        return sum;
    }

    private List<Integer>[] getConnections(int[] vals, int[][] edges) {
        List<Integer>[] connections = new List[vals.length];
        for (int[] edge : edges) {
            if (vals[edge[1]] > 0) {
                if (connections[edge[0]] == null) {
                    connections[edge[0]] = new ArrayList<>();
                }
                connections[edge[0]].add(edge[1]);
            }
            if (vals[edge[0]] > 0) {
                if (connections[edge[1]] == null) {
                    connections[edge[1]] = new ArrayList<>();
                }
                connections[edge[1]].add(edge[0]);
            }
        }
        return connections;
    }
}
