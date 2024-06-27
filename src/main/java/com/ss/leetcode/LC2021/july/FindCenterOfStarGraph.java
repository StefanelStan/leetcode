package com.ss.leetcode.LC2021.july;

public class FindCenterOfStarGraph {
    // https://leetcode.com/problems/find-center-of-star-graph/
    /** Algorithm
        1. If edge1[0] == edge2[0] or edge[0] == edge1[1] then edge1[0] is the center, else edge1[1] is the center
     */
    public int findCenter(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }
}
