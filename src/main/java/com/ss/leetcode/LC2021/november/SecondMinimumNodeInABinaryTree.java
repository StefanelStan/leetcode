package com.ss.leetcode.LC2021.november;

import com.ss.leetcode.shared.TreeNode;

public class SecondMinimumNodeInABinaryTree {
    // https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
    public int findSecondMinimumValue(TreeNode root) {
        int[] mins = {Integer.MAX_VALUE, Integer.MAX_VALUE, 0};
        traverseTree(root, mins);
        return getSecondMin(mins);
    }

    private void traverseTree(TreeNode node, int[] mins) {
        if (node == null) {
            return;
        }
        if (node.left == null) {
            setNewMins(mins, node.val, node.val);
        } else {
            setNewMins(mins, Math.min(node.left.val, node.right.val), Math.max(node.left.val, node.right.val));
        }
        traverseTree(node.left, mins);
        traverseTree(node.right, mins);
    }

    private int getSecondMin(int[] mins) {
        if (mins[0] == mins[1] || (mins[1] == Integer.MAX_VALUE && mins[2] == 0)) {
            return -1;
        }
        return mins[1];
    }

    private void setNewMins(int[] mins, int lower, int higher) {
        if (higher == Integer.MAX_VALUE) {
            mins[2] = 1;
        }
        if (lower < mins[0]) {
            mins[1] = mins[0];
            mins[0] = lower;
        }
        if (mins[1] > higher && higher != lower) {
            mins[1] = higher;
        }
    }
}
