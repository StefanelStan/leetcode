package com.ss.leetcode.july;

public class FindCenterOfStarGraph {
    // https://leetcode.com/problems/find-center-of-star-graph/
    public int findCenter(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }
}
