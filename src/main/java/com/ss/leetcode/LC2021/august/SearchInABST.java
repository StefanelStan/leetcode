package com.ss.leetcode.LC2021.august;

import com.ss.leetcode.shared.TreeNode;

public class SearchInABST {
    // https://leetcode.com/problems/search-in-a-binary-search-tree/
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}
