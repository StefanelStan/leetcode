package com.ss.leetcode.LC2021.august;

import com.ss.leetcode.shared.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class FindElementsContaminatedBT {
    // https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/
    private final Set<Integer> values = new HashSet<>();
    public FindElementsContaminatedBT(TreeNode root) {
        root.val = 0;
        recoverTree(root);
    }

    public boolean find(int target) {
        return values.contains(target);
    }

    private void recoverTree(TreeNode node) {
        values.add(node.val);
        if (node.left != null) {
            node.left.val = 2 * node.val +1;
            recoverTree(node.left);
        }
        if (node.right != null) {
            node.right.val = 2 * node.val + 2;
            recoverTree(node.right);
        }
    }
}
