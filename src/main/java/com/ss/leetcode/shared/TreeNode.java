package com.ss.leetcode.shared;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

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

    public static List<Integer> inOrder(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        traverseInorder(node, result);
        return result;
    }

    public static List<Integer> preOrder(TreeNode n) {
        List<Integer> result = new ArrayList<>();
        traversePreorder(n, result);
        return result;
    }

    private static void traverseInorder(TreeNode node, List<Integer> values) {
        if(node != null) {
            traverseInorder(node.left, values);
            values.add(node.val);
            traverseInorder(node.right, values);
        }
    }

    private static void traversePreorder(TreeNode node, List<Integer> values) {
        if (node != null) {
            values.add(node.val);
            traversePreorder(node.left, values);
            traversePreorder(node.right, values);
        }
    }

    @Override
    public String toString() {
        List<Integer> lst = new ArrayList<>();
        traversePreorder(this, lst);
        return String.valueOf(val);
    }
}
