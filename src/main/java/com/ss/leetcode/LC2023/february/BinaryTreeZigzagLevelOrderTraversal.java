package com.ss.leetcode.LC2023.february;

import com.ss.leetcode.shared.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    // https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal
    /** Algorithm
        1. Use a List<List<Integer>> levels to store the node vals for each level.
        2. Apply pre-order traversal while passing the current level you are.
            If level > levels.size(), it means you have reached a new/more in depth level.
            Add new List to levels
         3. Add this node to it's correspondent list (levels.get(level -1)).
         4. Once finished, iterate over the list of levels and if level is odd (0,1,2) reverse the list (Collections.reverse()).
         5. Return the list.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        traverseTree(root, 1, levels);
        zigZagLevels(levels);
        return levels;
    }

    private void traverseTree(TreeNode node, int level, List<List<Integer>> levels) {
        if (node != null) {
            if (level > levels.size()) {
                levels.add(new ArrayList<>());
            }
            levels.get(level -1).add(node.val);
            traverseTree(node.left, level + 1, levels);
            traverseTree(node.right, level + 1, levels);
        }
    }

    private void zigZagLevels(List<List<Integer>> levels) {
        for (int i = 0; i < levels.size(); i++) {
            if (i % 2 == 1) {
                Collections.reverse(levels.get(i));
            }
        }
    }
}
