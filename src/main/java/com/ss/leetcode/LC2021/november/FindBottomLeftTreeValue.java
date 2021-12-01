package com.ss.leetcode.LC2021.november;

import com.ss.leetcode.shared.TreeNode;

public class FindBottomLeftTreeValue {
    // https://leetcode.com/problems/find-bottom-left-tree-value/submissions/
    public int findBottomLeftValue(TreeNode root) {
        int[] leftLevel = {-1,0};
        traverseTree(root, 0, leftLevel);
        return leftLevel[1];
    }

    private void traverseTree(TreeNode node, int level, int[] leftLevel) {
        if (node == null) {
            return;
        }
        if (level > leftLevel[0]) {
            leftLevel[0] = level;
            leftLevel[1] = node.val;
        }
        traverseTree(node.left, level +1, leftLevel);
        traverseTree(node.right, level +1, leftLevel);
    }
}
