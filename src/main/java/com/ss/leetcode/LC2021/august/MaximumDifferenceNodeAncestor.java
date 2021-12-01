package com.ss.leetcode.LC2021.august;

import com.ss.leetcode.shared.TreeNode;

public class MaximumDifferenceNodeAncestor {
    // https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
    public int maxAncestorDiff(TreeNode root) {
        int[] maxDiff = new int[1];
        traverseAndCalculateMaxDiff(root, root.val, root.val, maxDiff);
        return maxDiff[0]; // max absolute diff
    }

    private void traverseAndCalculateMaxDiff(TreeNode node, int min, int max, int[] maxDiff) {
        if (node != null) {
            min = Math.min(node.val, min);
            max = Math.max(node.val, max);
            if (maxDiff[0] < max - min) {
                maxDiff[0] = max - min;
            }
            traverseAndCalculateMaxDiff(node.left, min, max, maxDiff);
            traverseAndCalculateMaxDiff(node.right, min, max, maxDiff);
        }
    }
}
