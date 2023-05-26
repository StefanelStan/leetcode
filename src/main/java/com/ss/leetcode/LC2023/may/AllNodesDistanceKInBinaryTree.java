package com.ss.leetcode.LC2023.may;

import com.ss.leetcode.shared.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class AllNodesDistanceKInBinaryTree {
    // https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree
    /** Algorithm
        1. Traverse the tree and use a TreeNode[501] to mark the parent of each node (parents[]).
            EG: 3 -> 5. parents[5] = 3. This way we have instant access to a parent of a node
        2. Knowing this, use a recursive method that will take the targetNode and will travel in 3 directions:
            left (node.left), right (node.right) and up (parents[node.val]).
            With each step, increment the distance/how far you are getting away from the target node.
            Don't go further in recursion when distance >= k.
        3. Keep track of visited nodes via a boolean[501]
        4. When distance == k for that node, add the node to the list of answer nodes.
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        TreeNode[] parents = new TreeNode[501];
        traverseTree(root, parents);
        List<Integer> distantNodes = new ArrayList<>();
        traverseAndFindDistantNodes(target, 0, k, parents, new boolean[501], distantNodes);
        return distantNodes;
    }

    private void traverseAndFindDistantNodes(TreeNode node, int currentDistance, int k, TreeNode[] parents,
        boolean[] visited, List<Integer> distantNodes) {
        if (node == null || currentDistance > k || visited[node.val]) {
            return;
        }
        visited[node.val] = true;
        if (currentDistance == k) {
            distantNodes.add(node.val);
            return;
        }
        currentDistance++;
        traverseAndFindDistantNodes(node.left, currentDistance, k, parents, visited, distantNodes);
        traverseAndFindDistantNodes(node.right, currentDistance, k, parents, visited, distantNodes);
        traverseAndFindDistantNodes(parents[node.val], currentDistance, k, parents, visited, distantNodes);
    }

    private void traverseTree(TreeNode node, TreeNode[] parents) {
        if (node != null) {
            if (node.left != null) {
                parents[node.left.val] = node;
            }
            if (node.right != null) {
                parents[node.right.val] = node;
            }
            traverseTree(node.left, parents);
            traverseTree(node.right, parents);
        }
    }
}
