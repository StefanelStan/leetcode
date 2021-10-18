package com.ss.leetcode.october;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class CousinsInBinaryTree {
    // https://leetcode.com/problems/cousins-in-binary-tree/
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root.left == null || root.right == null) {
            return false;
        }
        List<NodeStatus> cousins = new ArrayList<>(2);
        parseTree(root, root, 0, x, y, cousins);
        return cousins.get(0).parent != cousins.get(1).parent && cousins.get(0).level == cousins.get(1).level;
    }

    private void parseTree(TreeNode node, TreeNode parent, int level, int cousin1, int cousin2, List<NodeStatus> cousins) {
        if (cousins.size() != 2) {
            if (node.val == cousin1 || node.val == cousin2) {
                cousins.add(new NodeStatus(parent.val, level));
            }
            if (node.left != null) {
                parseTree(node.left, node, level + 1, cousin1, cousin2, cousins);
            }
            if (node.right != null) {
                parseTree(node.right, node, level + 1, cousin1, cousin2, cousins);
            }
        }
    }

    public static class NodeStatus {
        int parent;
        int level;

        public NodeStatus(int parent, int level) {
            this.parent = parent;
            this.level = level;
        }
    }
}
