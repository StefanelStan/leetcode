package com.ss.leetcode.august;

import com.ss.leetcode.shared.Node;

import java.util.ArrayList;
import java.util.List;

public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> levelOrders = new ArrayList<>();
        if (root == null) {
            return levelOrders;
        }
        traverseAndMapTree(root, 0, levelOrders);
        return levelOrders;
    }

    private void traverseAndMapTree(Node node, int currentLevel, List<List<Integer>> levelOrders) {
        if (node != null) {
            List<Integer> levelList = null;
            if (levelOrders.size() > currentLevel) {
                levelList = levelOrders.get(currentLevel);
                levelList.add(node.val);
            }
            else {
                levelList = new ArrayList<>();
                levelList.add(node.val);
                levelOrders.add(levelList);
            }

            if (node.children != null && !node.children.isEmpty()) {
                for(Node n : node.children) {
                    traverseAndMapTree(n, currentLevel + 1, levelOrders);
                }
            }
        }
    }
}
