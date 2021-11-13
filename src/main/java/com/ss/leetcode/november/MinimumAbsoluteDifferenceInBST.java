package com.ss.leetcode.november;

import com.ss.leetcode.shared.TreeNode;

public class MinimumAbsoluteDifferenceInBST {
    // https://leetcode.com/problems/minimum-absolute-difference-in-bst/
    public int getMinimumDifference(TreeNode root) {
        int[] minDiff = {Integer.MAX_VALUE};
        int[] lastNodes = new int[2];
        lastNodes[0] = 1_000_000;
        lastNodes[1] = 10_000_000;
        traverseTree(root, lastNodes, minDiff);
        return minDiff[0];
    }

    private void traverseTree(TreeNode node, int[] lastNodes, int[] minDiff) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            setValues(lastNodes, minDiff, node.val);
            return;
        }
        traverseTree(node.left, lastNodes, minDiff);
        setValues(lastNodes, minDiff, node.val);
        traverseTree(node.right, lastNodes, minDiff);
    }

    private void setValues(int[] lastNodes, int[] minDiff, int val) {
        lastNodes[0] = lastNodes[1];
        lastNodes[1] = val;
        int diff = Math.abs(lastNodes[0] - lastNodes[1]);
        if (diff < minDiff[0]) {
            minDiff[0] = diff;
        }
    }
}
