package com.ss.leetcode.LC2021.september;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    // https://leetcode.com/problems/binary-tree-level-order-traversal/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if (root == null) {
            return levelOrder;
        }
        LinkedList<NodeAndLevel> queue = new LinkedList<>();
        int currentLevel = 0;
        NodeAndLevel current;
        List<Integer> currentLevelList = new ArrayList<>();
        queue.add(new NodeAndLevel(root, 0));
        while(!queue.isEmpty()) {
            current = queue.removeFirst();
            if (current.level == currentLevel) {
                currentLevelList.add(current.node.val);
            } else {
                levelOrder.add(currentLevelList);
                currentLevelList = new ArrayList<>();
                currentLevelList.add(current.node.val);
                currentLevel++;
            }
            if (current.node.left != null) {
                queue.addLast(new NodeAndLevel(current.node.left, currentLevel + 1));
            }
            if (current.node.right != null) {
                queue.addLast(new NodeAndLevel(current.node.right, currentLevel + 1));
            }
        }
        if (!currentLevelList.isEmpty()) {
            levelOrder.add(currentLevelList);
        }
        return levelOrder;
    }

    private static class NodeAndLevel {
        TreeNode node;
        int level;
        public NodeAndLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }


    public List<List<Integer>> levelOrder2(TreeNode root) {
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
