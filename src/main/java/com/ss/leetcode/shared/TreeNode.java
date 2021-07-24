package com.ss.leetcode.shared;

import java.util.ArrayList;
import java.util.List;

//Definition for a binary tree node.
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) { val = x; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static List<Integer> extractValues(TreeNode n) {
        List<Integer> result = new ArrayList<>();
        if (n.left != null) {
            result.addAll(extractValues(n.left));
        }

        if (n.right != null) {
            result.addAll(extractValues(n.right));
        }

        result.add(n.val);

        return result;
    }
}
