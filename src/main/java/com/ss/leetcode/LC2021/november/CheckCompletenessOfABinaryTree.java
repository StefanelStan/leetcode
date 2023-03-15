package com.ss.leetcode.LC2021.november;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class CheckCompletenessOfABinaryTree {
    // https://leetcode.com/problems/check-completeness-of-a-binary-tree/
    // Nope. Just solved it years later :)
    public boolean isCompleteTree(TreeNode root) {
        if (root.left == root.right) {
            return true;
        }
        List<List<TreeNode>> nodes = new ArrayList<>();
        traverseTree(root, 1, nodes);
        return checkNodeLevels(nodes);
    }

    private void traverseTree(TreeNode node, int level, List<List<TreeNode>> nodes) {
        if (node == null) {
            return;
        }
        if (level > nodes.size()) {
            nodes.add(new ArrayList<>());
        }
        nodes.get(level -1).add(node);
        traverseTree(node.left, level + 1, nodes);
        traverseTree(node.right, level + 1, nodes);
    }

    private boolean checkNodeLevels(List<List<TreeNode>> nodes) {
        for (int i = 0; i < nodes.size() - 1; i++) {
            if (nodes.get(i).size() != Math.pow(2, i)) {
                return false;
            }
        }
        int last = nodes.size() -1, before = nodes.size() - 2;
        for (int i = 0; i < nodes.get(before).size(); i++) {
            TreeNode parent = nodes.get(before).get(i);
            if ((parent.left == null && parent.right != null)
                || (parent.left == parent.right && nodes.get(last).size() > i * 2)
                || (parent.left != null && parent.right == null && nodes.get(last).size() > i * 2 + 1)) {
                return false;
            }
        }
        return true;
    }

    // (28.11.2021) ! incorrect or incomplete description. Hidden requirements .....
    // (15.03.2023) Nope, I solved it years later :)
    public boolean isCompleteTree2(TreeNode root) {
        boolean[] isComplete = {true};
        if (root.left == null && root.right == null) {
            isComplete[0] = true;
        } else if (root.left == null && root.right != null) {
            isComplete[0] = false;
        } else {
            traverseTree(root, 1, new ArrayList<>(), isComplete);
        }
        return isComplete[0];
    }

    private int traverseTree(TreeNode node, int level, List<List<TreeNode>> nodeLevels, boolean[] isComplete) {
        if (level > nodeLevels.size()) {
            List<TreeNode> list = new ArrayList<>();
            list.add(node);
            nodeLevels.add(list);
        } else {
            nodeLevels.get(level-1).add(node);
        }
        if (node.left == null && node.right == null) {
            return level;
        }
        if(node.left == null) {
            isComplete[0] = false;
            return level;
        }
        int maxLevel = level;

        if (isComplete[0]) {
            maxLevel = Math.max(maxLevel, traverseTree(node.left, level +1, nodeLevels, isComplete));
        }
        if(node.right != null && isComplete[0]) {
            maxLevel = Math.max(maxLevel, traverseTree(node.right, level +1, nodeLevels, isComplete));
        }
        // check current Dept vs Max depth
        if (maxLevel - level == 1) {
            if (node.left == null && node.right != null) {
                isComplete[0] = false;
            }
        } else {
            if (node.left == null || node.right == null) {
                isComplete[0] = false;
            }
        }
        // check if this is as left as possible
        List<TreeNode> upperLevel = nodeLevels.get(level-1);
        if (upperLevel.size() > 1 && upperLevel.get(upperLevel.size() - 2).right == null) {
            isComplete[0] = false;
        }
        return maxLevel;
    }
}
