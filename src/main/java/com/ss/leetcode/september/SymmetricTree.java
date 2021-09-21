package com.ss.leetcode.september;

import com.ss.leetcode.shared.TreeNode;

public class SymmetricTree {
    // https://leetcode.com/problems/symmetric-tree/
    public boolean isSymmetric(TreeNode root) {
        if(root.left == null && root.right == null) {
            return true;
        }
        boolean[] isSymmetric = {true};
        traverseTree(root.left, root.right, isSymmetric);
        return isSymmetric[0];
    }

    private void traverseTree(TreeNode leftMirror, TreeNode rightMirror, boolean[] isSymmetric) {
        if (isSymmetric[0] && !(leftMirror == null && rightMirror == null)) {
            if (leftMirror == null || rightMirror == null || leftMirror.val != rightMirror.val) {
                isSymmetric[0] = false;
                return;
            }
            traverseTree(leftMirror.left, rightMirror.right, isSymmetric);
            traverseTree(leftMirror.right, rightMirror.left, isSymmetric);
        }
    }
}
