package com.ss.leetcode.september;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    // https://leetcode.com/problems/binary-tree-postorder-traversal/
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrder = new ArrayList<>();
        traverseTree(root, postOrder);
        return postOrder;
    }

    private void traverseTree(TreeNode node, List<Integer> postOrder) {
        if (node != null) {
            traverseTree(node.left, postOrder);
            traverseTree(node.right, postOrder);
            postOrder.add(node.val);
        }
    }
}
