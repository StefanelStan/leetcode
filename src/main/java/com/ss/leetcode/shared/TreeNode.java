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
        traverseAndGetNodes(n, result);
        return result;
    }

    private static void traverseAndGetNodes(TreeNode node, List<Integer> values) {
        if (node != null) {
            traverseAndGetNodes(node.left, values);
            traverseAndGetNodes(node.right, values);
            values.add(node.val);
        }
    }
}
