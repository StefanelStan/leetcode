package com.ss.leetcode.LC2022.march;

import com.ss.leetcode.shared.TreeNode;

public class LowestCommonAncestorOfABinaryTree {
    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/submissions/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] lca = new TreeNode[1]; //lca
        traverseTree(root, p, q, lca);
        return lca[0];
    }
    // because it is NOT a BST, we cannot check if p & q are smaller or greater than root to look on left or right branch
    private boolean traverseTree(TreeNode node, TreeNode p, TreeNode q, TreeNode[] lca){
        if (node == null || lca[0] != null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return node.val == p.val || node.val == q.val;
        }
        boolean leftContains = traverseTree(node.left, p, q, lca);
        if (leftContains && (node.val == p.val || node.val == q.val)) {
            lca[0] = node;
            return false;
        }
        boolean rightContains = traverseTree(node.right, p, q, lca);
        if (rightContains && (leftContains || node.val == p.val || node.val == q.val)) {
            lca[0] = node;
            return false;
        }
        return leftContains || rightContains || node.val == p.val || node.val == q.val;
    }
}
