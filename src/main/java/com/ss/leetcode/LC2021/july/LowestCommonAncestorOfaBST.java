package com.ss.leetcode.LC2021.july;

import com.ss.leetcode.shared.TreeNode;

public class LowestCommonAncestorOfaBST {
    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] lca = new TreeNode[1];
        TreeNode small = p.val < q.val ? p : q;
        TreeNode large = p.val > q.val ? p : q;
        traverseTree(root, small, large, lca);
        return lca[0];
    }

    private void traverseTree(TreeNode node, TreeNode small, TreeNode large, TreeNode[] lca) {
        if (node != null && lca[0] == null) {
            if (node.val == small.val || node.val == large.val || (node.val > small.val && node.val < large.val)) {
                lca[0] = node;
            } else {
                traverseTree(node.left, small, large, lca);
                traverseTree(node.right, small, large, lca);
            }
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);

        // If both n1 and n2 are greater than root, then LCA lies in right
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);

        return root;
    }
}
