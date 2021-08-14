package com.ss.leetcode.august;

import com.ss.leetcode.shared.Node;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePostorderTraversal {
    // https://leetcode.com/problems/n-ary-tree-postorder-traversal/
    public List<Integer> postorder(Node root) {
        List<Integer> postOrder = new ArrayList<>();
        traverseTree(root, postOrder);
        return postOrder;
    }

    private void traverseTree(Node node, List<Integer> postOrder) {
        if (node != null) {
            for (Node n : node.children) {
                traverseTree(n, postOrder);
            }
            postOrder.add(node.val);
        }

    }
}
