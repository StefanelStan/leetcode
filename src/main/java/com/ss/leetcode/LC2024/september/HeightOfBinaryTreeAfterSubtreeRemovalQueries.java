package com.ss.leetcode.LC2024.september;

import com.ss.leetcode.shared.TreeNode;

public class HeightOfBinaryTreeAfterSubtreeRemovalQueries {
    // https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries
    public int[] treeQueries(TreeNode root, int[] queries) {
        TreeNodeDetails[] nodeDetails = getTreeNodeDetails(root);
        int[] answers = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answers[i] = deleteNode(queries[i], nodeDetails, root.val) - 1;
        }
        return answers;
    }

    private int deleteNode(int node, TreeNodeDetails[] nodeDetails, int root) {
        int leftSubtreeLength, rightSubtreeLength;
        int newNodeLength = 0;
        TreeNode parent;
        boolean updateNeeded = true;
        while (updateNeeded) {
            updateNeeded = false;
            parent = nodeDetails[nodeDetails[node].parent].node;
            leftSubtreeLength = parent.left == null
                ? 0
                : parent.left.val == node ? newNodeLength : nodeDetails[parent.left.val].pathLength;
            rightSubtreeLength = parent.right == null
                ? 0
                : parent.right.val == node ? newNodeLength : nodeDetails[parent.right.val].pathLength;
            if (nodeDetails[parent.val].pathLength != 1 + Math.max(leftSubtreeLength, rightSubtreeLength)) {
                newNodeLength = 1 + Math.max(leftSubtreeLength, rightSubtreeLength);
                node = parent.val;
                updateNeeded = node != root;
            }
        }
        return node == root ? newNodeLength : nodeDetails[root].pathLength;
    }

    private void updatePathLength(int node, TreeNodeDetails[] nodeDetails) {

    }

    private TreeNodeDetails[] getTreeNodeDetails(TreeNode root) {
        TreeNodeDetails[] nodeDetails = new TreeNodeDetails[100_001];
        nodeDetails[root.val] = new TreeNodeDetails(-1, root);
        traverseTree(root, nodeDetails);
        return nodeDetails;
    }

    private int traverseTree(TreeNode node, TreeNodeDetails[] nodeDetails) {
        if (node == null) {
            return 0;
        }
        if (node.left == node.right) {
            nodeDetails[node.val].pathLength = 1;
            return 1;
        }
        int leftPathLength = 0, rightPathLength = 0;
        if (node.left != null) {
            nodeDetails[node.left.val] = new TreeNodeDetails(node.val, node.left);
            leftPathLength = traverseTree(node.left, nodeDetails);
        }
        if (node.right != null) {
            nodeDetails[node.right.val] = new TreeNodeDetails(node.val, node.right);
            rightPathLength = traverseTree(node.right, nodeDetails);
        }

        nodeDetails[node.val].pathLength = 1 + Math.max(leftPathLength, rightPathLength);
        return nodeDetails[node.val].pathLength;
    }

    private static class TreeNodeDetails {
        int parent;
        int pathLength;
        TreeNode node;
        public TreeNodeDetails(int parent, TreeNode node) {
            this.parent = parent;
            this.node = node;
        }
    }
}
