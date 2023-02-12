package com.ss.leetcode.LC2023.february;

import java.util.ArrayList;
import java.util.List;

public class MinimumFuelCostToReportToTheCapital {
    // https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital
    /** Algorithm
        1. Construct the tree of nodes and roads that leads out of that node using a List[] nodes
            (0,3) => List[0] = {3} and List[3] = {0};
        2. Apply DFS starting with node 0.
            - From node0 (List[0]), get the list of nodes and determine the number of people that will be coming from that nodes.
            - For each call, also pass the parent to avoid calling back the parent from child.
            Node3 will try to traverse back to parent (Node0), unless that is the caller
        3. With each DFS step, get the number of people that will be coming from that subtree,
            divide/module the number of seats and increase the cost. Return the sum of ppl coming from ALL subtrees of that city.
     */
    public long minimumFuelCost(int[][] roads, int seats) {
        if (roads.length == 0) {
            return 0;
        }
        long[] cost = {0};
        List[] nodes = constructTree(roads);
        traverseTree(nodes, 0, 0, cost, seats);
        return cost[0];
    }

    private List[] constructTree(int[][] roads) {
        List[] nodes = new List[roads.length + 1];
        for (int[] road : roads) {
            if (nodes[road[0]] == null) {
                nodes[road[0]] = new ArrayList<Integer>();
            }
            if (nodes[road[1]] == null) {
                nodes[road[1]] = new ArrayList<Integer>();
            }
            nodes[road[0]].add(road[1]);
            nodes[road[1]].add(road[0]);
        }
        return nodes;
    }

    private long traverseTree(List[] nodes, int parent, int target, long[] cost, int seats) {
        long representatives = 0;
        List<Integer> cities = nodes[target];
        for (int city : cities) {
            if (city != parent) {
                long onSubtree = traverseTree(nodes, target, city, cost, seats);
                representatives += onSubtree;
                cost[0] += onSubtree / seats;
                if (onSubtree % seats  != 0) {
                    cost[0]++;
                }
            }
        }
        return ++representatives;
    }
}
