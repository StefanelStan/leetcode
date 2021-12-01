package com.ss.leetcode.LC2021.august;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecoverATreeFromPreorderTraversal {
    // https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/
    public TreeNode recoverFromPreorder(String traversal) {
        Map<Integer, List<TreeNode>> levelMap = new HashMap<>();
        rebuildTree(traversal, levelMap);
        return levelMap.get(0).get(0);
    }

    private void rebuildTree(String traversal, Map<Integer, List<TreeNode>> levelMap) {
        int levelIndex = 0, nodeIndex = 0;
        for (int i = 0; i < traversal.length() -1; i++) {
            if (traversal.charAt(i) != '-' && traversal.charAt(i + 1) == '-') {
                int nodeVal = Integer.parseInt(traversal.substring(nodeIndex, i + 1));
                int nodeLevel = nodeIndex - levelIndex;
                processNode(nodeVal, nodeLevel, levelMap);
                levelIndex = i + 1;
            } else if (traversal.charAt(i) == '-' && traversal.charAt(i+1) != '-') {
                nodeIndex = i+1;
            }
        }

        //process Last Node as it doesn't get indexed
        int nodeVal = Integer.parseInt(traversal.substring(nodeIndex));
        int nodeLevel = nodeIndex - levelIndex;
        processNode(nodeVal, nodeLevel, levelMap);
    }

    private void processNode(int nodeVal, int nodeLevel, Map<Integer, List<TreeNode>> levelMap) {
        if (nodeLevel == 0) {
            levelMap.put(0, List.of(new TreeNode(nodeVal)));
            return;
        }
        TreeNode newNode = new TreeNode(nodeVal);
        List<TreeNode> nodesOfLevel = levelMap.computeIfAbsent(nodeLevel, v -> new ArrayList<>());
        nodesOfLevel.add(newNode);
        attachNodeToAvailableParent(newNode, nodeLevel, levelMap.get(nodeLevel -1));
    }

    private void attachNodeToAvailableParent(TreeNode newNode, int nodeLevel, List<TreeNode> treeNodes) {
        TreeNode latestParent;
        for (int i = treeNodes.size() -1; i >=0; i--) {
            latestParent = treeNodes.get(i);
            if (latestParent.left == null) {
                latestParent.left = newNode;
                break;
            } else if (latestParent.right == null) {
                latestParent.right = newNode;
                break;
            }
        }
    }
}
