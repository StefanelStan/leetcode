package com.ss.leetcode.LC2021.september;

import com.ss.leetcode.shared.TreeNode;

public class SymmetricTree {
    // https://leetcode.com/problems/symmetric-tree/
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    boolean isSymmetric(TreeNode leftHalf, TreeNode rightHalf) {
        if (leftHalf == rightHalf) {
            return true;
        }
        if (leftHalf == null || rightHalf == null) {
            return false;
        }
        return leftHalf.val == rightHalf.val
            && isSymmetric(leftHalf.left, rightHalf.right)
            && isSymmetric(leftHalf.right, rightHalf.left);
    }

    public boolean isSymmetric2(TreeNode root) {
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
