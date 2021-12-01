package com.ss.leetcode.LC2021.august;

import com.ss.leetcode.shared.Node;

import java.util.LinkedList;
import java.util.List;

public class NaryTreePreorderTraversal {
    // https://leetcode.com/problems/n-ary-tree-preorder-traversal/
    public List<Integer> preorder(Node root) {
        List<Integer> preorder = new LinkedList<>();
        traverseTree(root, preorder);
        return preorder;
    }

    private void traverseTree(Node node, List<Integer> preorder) {
        if (node != null) {
            preorder.add(node.val);
            for (Node child: node.children) {
                traverseTree(child, preorder);
            }
        }
    }
}
