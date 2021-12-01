package com.ss.leetcode.LC2021.august;

import com.ss.leetcode.shared.TreeNode;

public class SearchInABST {
    // https://leetcode.com/problems/search-in-a-binary-search-tree/
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || (root.left == null && root.right == null && root.val != val)) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else {
            if (root.val < val) {
                return searchBST(root.right, val);
            } else {
                return searchBST(root.left, val);
            }
        }
    }
}
