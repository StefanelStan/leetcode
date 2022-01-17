package com.ss.leetcode.LC2022.january;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
    // https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> nodeLevels = new ArrayList<>();
        traverseTree(root, 1, nodeLevels);
        Collections.reverse(nodeLevels);
        return nodeLevels;
    }

    private void traverseTree(TreeNode node, int level, List<List<Integer>> nodeLevels) {
        if (node == null) {
            return;
        }
        if (level > nodeLevels.size()) {
            List<Integer> nodes = new ArrayList<>();
            nodes.add(node.val);
            nodeLevels.add(nodes);
        } else {
            nodeLevels.get(level -1).add(node.val);
        }
        traverseTree(node.left, level +1, nodeLevels);
        traverseTree(node.right, level +1, nodeLevels);
    }
}
