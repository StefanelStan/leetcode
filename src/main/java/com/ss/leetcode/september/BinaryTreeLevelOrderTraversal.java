package com.ss.leetcode.september;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    // https://leetcode.com/problems/binary-tree-level-order-traversal/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        traverseTree(root, 1, levelOrder);
        return levelOrder;
    }

    private void traverseTree(TreeNode node, int level, List<List<Integer>> levelOrder) {
        if (node != null) {
            if (levelOrder.size() < level) {
                levelOrder.add(new ArrayList<>());
            }
            levelOrder.get(level -1).add(node.val);
            traverseTree(node.left, level + 1, levelOrder);
            traverseTree(node.right, level + 1, levelOrder);
        }
    }
}
