package com.ss.leetcode.LC2022.march;

import com.ss.leetcode.shared.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class CreateBinaryTreeFromDescriptions {
    // https://leetcode.com/problems/create-binary-tree-from-descriptions/
    /** Algorithm
         1. Use a nopeMap to store val -> Node mapping and also a boolean[] children to mark if that node is a child.
         2. Loop over descriptions and add the parent and child node to/ from map.
         Also mark in children[] as true the index of the child value.
         3. The root is the only node inside mapping for which children[val] is false (it is the child of no node).
         Loop over mapping and return this specific node.
     */
    public TreeNode createBinaryTree(int[][] descriptions) {
        TreeNode[] nodemap = new TreeNode[100_001];
        boolean[] hasParent = new boolean[100_001];
        populateNodes(descriptions, nodemap, hasParent);
        for (TreeNode node : nodemap) {
            if (node != null && !hasParent[node.val]) {
                return node;
            }
        }
        return null;
    }

    private void populateNodes(int[][] descriptions, TreeNode[] nodeMap, boolean[] hasParent) {
        for (int[] description : descriptions) {
            if (nodeMap[description[0]] == null) {
                nodeMap[description[0]] = new TreeNode(description[0]);
            }
            if (nodeMap[description[1]] == null) {
                nodeMap[description[1]] = new TreeNode(description[1]);
            }
            hasParent[description[1]] = true;
            if (description[2] == 1) {
                nodeMap[description[0]].left = nodeMap[description[1]];
            } else {
                nodeMap[description[0]].right = nodeMap[description[1]];
            }
        }
    }
    public TreeNode createBinaryTree2(int[][] descriptions) {
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
