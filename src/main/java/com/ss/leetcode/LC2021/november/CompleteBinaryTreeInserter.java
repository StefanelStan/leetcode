package com.ss.leetcode.LC2021.november;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class CompleteBinaryTreeInserter {
    // https://leetcode.com/problems/complete-binary-tree-inserter/
    List<List<TreeNode>> levelNodes;
    public CompleteBinaryTreeInserter(TreeNode root) {
        levelNodes = new ArrayList<>();
        traverseAndInsert(root, 1);
    }

    public int insert(int val) {
        TreeNode newNode = new TreeNode(val);
        int parentVal = -1;
        if (levelNodes.size() == 1) {
            TreeNode node = levelNodes.get(0).get(0);
            node.left = newNode;
            List<TreeNode> newLevel = new ArrayList<>();
            newLevel.add(newNode);
            levelNodes.add(newLevel);
            parentVal = node.val;
        } else if ((parentVal = attemptToInsertOnLevel(newNode, levelNodes.size() - 2)) == -1) {
            parentVal = attemptToInsertOnLevel(newNode, levelNodes.size() -1);
        }
        return parentVal;
    }

    public TreeNode get_root() {
        return levelNodes.get(0).get(0);
    }

    private void traverseAndInsert(TreeNode node, int level) {
        if (node != null) {
            List<TreeNode> levelList;
            if (level > levelNodes.size()) {
                levelList = new ArrayList<>();
                levelList.add(node);
                levelNodes.add(levelList);
            } else {
                levelList = levelNodes.get(level -1);
                levelList.add(node);
            }
            traverseAndInsert(node.left, level +1);
            traverseAndInsert(node.right, level +1);
        }
    }

    private int attemptToInsertOnLevel(TreeNode newNode, int level) {
        List<TreeNode> levelList = levelNodes.get(level);
        for (TreeNode node : levelList) {
            if (node.left == null) {
                node.left = newNode;
                insertOnLevel(newNode, level +1);
                return node.val;
            } else if (node.right == null) {
                node.right = newNode;
                insertOnLevel(newNode, level +1);
                return node.val;
            }
        }
        return -1;
    }

    private void insertOnLevel(TreeNode newNode, int level) {
        if (level == levelNodes.size()) {
            level = levelNodes.size() -1;
        }
        List<TreeNode> levelList = levelNodes.get(level);
        if (levelList == null) {
            levelList = new ArrayList<>();
            levelList.add(newNode);
            levelNodes.add(levelList);
        } else {
            levelList.add(newNode);
        }
    }
}
