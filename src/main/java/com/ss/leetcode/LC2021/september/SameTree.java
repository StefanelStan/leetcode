package com.ss.leetcode.LC2021.september;

import com.ss.leetcode.shared.TreeNode;

public class SameTree {
    // https://leetcode.com/problems/same-tree/
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        if (p == q) {
            return true;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        boolean[] isSameTree = {true};
        isSameTree(p,q, isSameTree);
        return isSameTree[0];
    }
    private void isSameTree(TreeNode p, TreeNode q, boolean[] isSameTree) {
        if (isSameTree[0]) {
            if ((p == null && q != null) || (p != null && q == null)) {
                isSameTree[0] = false;
            } else if (q != null && p.val != q.val) {
                isSameTree[0] = false;
            } else if (p != null){
                isSameTree(p.left, q.left, isSameTree);
                isSameTree(p.right, q.right, isSameTree);
            }
        }
    }
}
