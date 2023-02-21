package com.ss.leetcode.LC2023.february;

import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfVerticesToReachAllNodes {
    // https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] incoming = new boolean[n];
        for (List<Integer> edge : edges) {
            incoming[edge.get(1)] = true;
        }
        List<Integer> vertices = new ArrayList<>();
        for (int i = 0; i < incoming.length; i++) {
            if (!incoming[i]) {
                vertices.add(i);
            }
        }
        return vertices;
    }
}
