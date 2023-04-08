package com.ss.leetcode.LC2022.february;

import com.ss.leetcode.shared.Node;

public class CloneGraph {
    // https://leetcode.com/problems/clone-graph/
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node[] nodes = new Node[101];
        visitNode(node, nodes);
        return nodes[node.val];
    }

    private void visitNode(Node node, Node[] nodes) {
        if (nodes[node.val] != null) {
            return;
        }
        nodes[node.val] = new Node(node.val);
        for (Node neighbor : node.children) {
            visitNode(neighbor, nodes);
            nodes[node.val].children.add(nodes[neighbor.val]);
        }
    }



    public Node cloneGraph2(Node node) {
        if (node == null) {
            return null;
        }
        if (node.children.isEmpty()) {
            return new Node(node.val);
        }
        return traverseGraph(node, new Node[101]);
    }

    private Node traverseGraph(Node originalNode, Node[] visited) {
        if (visited[originalNode.val] != null) {
            return visited[originalNode.val];
        }
        visited[originalNode.val] = new Node(originalNode.val);
        for (Node n : originalNode.children) {
            visited[originalNode.val].children.add(traverseGraph(n, visited));
        }
        return visited[originalNode.val];
    }
}
