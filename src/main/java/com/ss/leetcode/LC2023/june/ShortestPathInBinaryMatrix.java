package com.ss.leetcode.LC2023.june;

import java.util.LinkedList;

public class ShortestPathInBinaryMatrix {
    // https://leetcode.com/problems/shortest-path-in-binary-matrix
    /** Algorithm
        1. Use a direction[][] to check the 8 directions
         2. Use a LinkedList to addLast, removeFirst
        3. Initially, add [0,0,0] in LL. [x,y,cost].
        4. While queue.isEmpty()
            - poll head. If head has x=n,y=n, it means you reached the end. return [2] + 1
            - for each direction, if direction + current within limits and == 0, add it to queue
            [x+dx, y+dy, [2] + 1]. Current node's cost + 1
            - mark x+dx, y+dy with 1 so it will not get to be visited again
        5. Return -1 if the loop does not end at 4.a
     */
    private static final int[][] directions = {{-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        }
        LinkedList<int[]> toVisit = new LinkedList<>();
        toVisit.addLast(new int[]{0,0,0});
        int x, y;
        while (!toVisit.isEmpty()) {
            int[] current = toVisit.removeFirst();
            if (current[0] == n-1 && current[1] == n-1) {
                return current[2] + 1;
            }
            for(int[] direction : directions) {
                x = direction[0] + current[0];
                y = direction[1] + current[1];
                if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0) {
                    toVisit.addLast(new int[]{x, y, current[2] + 1});
                    grid[x][y] = 1;
                }
            }
        }
        return -1;
    }
}
