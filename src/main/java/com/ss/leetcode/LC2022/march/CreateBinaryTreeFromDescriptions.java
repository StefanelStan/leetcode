package com.ss.leetcode.LC2022.march;

import com.ss.leetcode.shared.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class CreateBinaryTreeFromDescriptions {
    // https://leetcode.com/problems/create-binary-tree-from-descriptions/
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        boolean[] children = new boolean[100_001];
        for (int[] description : descriptions) {
            TreeNode parent = nodeMap.computeIfAbsent(description[0], k -> new TreeNode(description[0]));
            TreeNode child = nodeMap.computeIfAbsent(description[1], k -> new TreeNode(description[1]));
            if (description[2] == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            children[child.val] = true;
        }
        return nodeMap.entrySet().stream().filter(e -> !children[e.getKey()]).findFirst().get().getValue();
    }
}
