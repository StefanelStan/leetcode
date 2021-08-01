package com.ss.leetcode.august;

import com.ss.leetcode.shared.TreeNode;

public class MergeTwoBinaryTrees {
    // https://leetcode.com/problems/merge-two-binary-trees/
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        TreeNode newRoot = new TreeNode((root1 != null ? root1.val : 0) + (root2 != null ? root2.val : 0));
        newRoot.left = mergeTrees(root1 != null ? root1.left : null, root2 != null ? root2.left : null);
        newRoot.right = mergeTrees(root1 != null ? root1.right : null, root2 != null ? root2.right : null);
        return newRoot;
    }
}
