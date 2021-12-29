package com.ss.leetcode.LC2021.september;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PopulatingNextRightPointers {
    // https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
    public Node connect(Node root) {
        List<Node> levelNodes = new ArrayList<>();
        traverseAndConnect(root, 0, levelNodes);
        return root;
    }

    private void traverseAndConnect(Node node, int level, List<Node> levelNodes) {
        if (node == null) {
            return;
        }
        if (level < levelNodes.size()) {
            levelNodes.get(level).next = node;
            levelNodes.set(level, node);
        } else {
            levelNodes.add(node);
        }
        traverseAndConnect(node.left, level + 1, levelNodes);
        traverseAndConnect(node.right, level + 1, levelNodes);
    }


    public Node connect2(Node root) {
        Map<Integer, Node> levelNodes = new HashMap<>();
        traverseAndConnect2(root, 0, levelNodes);
        return root;
    }

    private void traverseAndConnect2(Node node, int level, Map<Integer, Node> levelNode) {
        if (node != null) {
            Node existingNode = levelNode.get(level);
            if (existingNode != null) {
                existingNode.next = node;
            }
            levelNode.put(level, node);
            traverseAndConnect2(node.left, level + 1, levelNode);
            traverseAndConnect2(node.right, level + 1, levelNode);
        }
    }

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
