package com.ss.leetcode.LC2022.february;

import com.ss.leetcode.LC2021.september.PopulatingNextRightPointers.Node;

import java.util.ArrayList;
import java.util.List;

public class PopulatingNextRightPointersInEachNodeII {
    // https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
    public Node connect(Node root) {
        if (root != null && root.left != root.right) {
            List<Node> levelNodes = new ArrayList<>();
            traverseTree(root, 1, levelNodes);
        }
        return root;
    }

    private void traverseTree(Node node, int level, List<Node> levelNodes) {
        if(level > levelNodes.size()) {
            levelNodes.add(node);
        } else {
            node.next = levelNodes.get(level - 1);
            levelNodes.set(level - 1, node);
        }
        if(node.right != null) {
            traverseTree(node.right, level + 1, levelNodes);
        }
        if(node.left != null) {
            traverseTree(node.left, level + 1, levelNodes);
        }
    }
}
