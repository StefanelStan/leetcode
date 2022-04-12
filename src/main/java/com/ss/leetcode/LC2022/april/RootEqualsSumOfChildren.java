package com.ss.leetcode.LC2022.april;

import com.ss.leetcode.shared.TreeNode;

public class RootEqualsSumOfChildren {
    // https://leetcode.com/problems/root-equals-sum-of-children/
    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }
}
