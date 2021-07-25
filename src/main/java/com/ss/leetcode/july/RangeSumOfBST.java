package com.ss.leetcode.july;

import com.ss.leetcode.shared.TreeNode;

public class RangeSumOfBST {
    // https://leetcode.com/problems/range-sum-of-bst/
    public int rangeSumBST(TreeNode root, int low, int high) {
        int carriedValue = root.val >= low && root.val <= high ? root.val : 0;
        if (root.left != null && root.val >= low) {
            carriedValue += rangeSumBST(root.left, low, high);
        }
        if (root.right != null && root.val <= high) {
            carriedValue += rangeSumBST(root.right, low, high);
        }
        return carriedValue;
    }
}
