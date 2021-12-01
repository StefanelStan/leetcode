package com.ss.leetcode.LC2021.october;

import com.ss.leetcode.shared.TreeNode;

public class CountCompleteTreeNodes {
    // https://leetcode.com/problems/count-complete-tree-nodes/
    public int countNodes(TreeNode root) {
        int[] total = {0};
        if (root != null) {
            parseTree(root, total);
        }
        return total[0];
    }

    private void parseTree(TreeNode node, int[] total) {
        if (node != null) {
            total[0]++;
            parseTree(node.left, total);
            parseTree(node.right, total);
        }
    }
}
