package com.ss.leetcode.LC2023.february;

public class ConstructQuadTree {
    // https://leetcode.com/problems/construct-quad-tree
    /** Algorithm
        1. Use a recursive method that will take the grid, int i, int j, range and will return a node
            The range will indicate how much to traverse (i,i+range lines and j, j+range columns)
        2. The initial call will be with grid, 0, 0, grid.length (eg: 8)
        3. If range == 1, you have just 1 element: 0 or 1. It is a leaf with value == that element
        4. Else, traverse the matrix segment and determine the combined value: 1, 0 or mixed (-1).
            If combined is 1 or 0, then you have a leaf node. Return it
            If combined is -1, return a build node by building the 4 children,
            new Node(false, false,
            recursive(i, j, halfRange) - top Left, recursive(i, j+half, j+half) - top Right
            recursive(i+half, j, half) - bottom Left, recursive(x+half, y+half, half) - bottom Right)
     */
    public Node construct(int[][] grid) {
        return buildQuadTree(grid, 0, 0, grid[0].length);
    }

    private Node buildQuadTree(int[][] grid, int x, int y, int range) {
        if (range == 1) {
            return new Node(grid[x][y] == 1, true);
        }
        int combinedValue = getCombinedValue(grid, x, y, range);
        if (combinedValue != -1) {
            return new Node(combinedValue == 1, true);
        } else {
            int half = range /2;
            return new Node(false, false,
                buildQuadTree(grid, x, y, half), buildQuadTree(grid, x, y + half, half),
                buildQuadTree(grid, x+half, y, half), buildQuadTree(grid, x+half, y+half, half));
        }
    }

    private int getCombinedValue(int[][] grid, int x, int y, int range) {
        int expected = grid[x][y];
        for(int i = x; i < x + range; i++) {
            for(int j = y; j < y + range; j++) {
                if (grid[i][j] != expected) {
                    return -1;
                }
            }
        }
        return expected;
    }

    public static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
