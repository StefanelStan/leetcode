package com.ss.leetcode.july;

import com.ss.leetcode.shared.TreeNode;

public class LowestCommonAncestorOfaBST {
    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
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
