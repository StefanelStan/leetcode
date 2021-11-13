package com.ss.leetcode.november;

import com.ss.leetcode.shared.TreeNode;

public class SubtreeOfAnotherTree {
    // https://leetcode.com/problems/subtree-of-another-tree/
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root.left == null && root.right == null && subRoot.left == null && subRoot.right == null) {
            return root.val == subRoot.val;
        }
        boolean[] subRootFound = {false};
        parseTree(root, subRoot, subRootFound);
        return subRootFound[0];
    }

    private void parseTree(TreeNode node, TreeNode subRoot, boolean[] subRootFound) {
        if(subRootFound[0] || (node == null && subRoot != null) || (node != null && subRoot == null)) {
            return;
        }
        if (node.val == subRoot.val) {
            subRootFound[0] = compareSubtrees(node, subRoot);
        }
        if (!subRootFound[0] && node.left != null) {
            parseTree(node.left, subRoot, subRootFound);
        }
        if (!subRootFound[0] && node.right != null) {
            parseTree(node.right, subRoot, subRootFound);
        }
    }

    private boolean compareSubtrees(TreeNode node, TreeNode subRoot) {
        if (node == null && subRoot == null) {
            return true;
        }
        if (node == null || subRoot == null) {
            return false;
        }
        return node.val == subRoot.val && compareSubtrees(node.left, subRoot.left)
            && compareSubtrees(node.right, subRoot.right);
    }
}
