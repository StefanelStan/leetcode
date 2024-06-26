package com.ss.leetcode.LC2021.july;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BalanceABST {
    // https://leetcode.com/problems/balance-a-binary-search-tree/
    /** Algorithm
        1. Traverse the tree in order and put the values into a List<Integer>
        2. Use a recursive function that will accept the list, start and end and will return a tree node
            - The returned TreeNode will have the value of list.get(mid) and left / right nodes as rec(left, mid -1) and rec(mid+1, right);
        3. So, recursively, build left and right nodes/subtrees.
     */
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nodeValues = new ArrayList<>();
        getNodes(root, nodeValues);
        return buildBST(nodeValues, 0, nodeValues.size() - 1);
    }

    private TreeNode buildBST(List<Integer> nodeValues, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        return new TreeNode(nodeValues.get(mid), buildBST(nodeValues, left, mid - 1), buildBST(nodeValues, mid + 1, right));
    }

    private void getNodes(TreeNode node, List<Integer> nodeValues) {
        if (node != null) {
            getNodes(node.left, nodeValues);
            nodeValues.add(node.val);
            getNodes(node.right, nodeValues);
        }
    }


    public TreeNode balanceBST2(TreeNode root) {
        if (root == null) {
            return root;
        }
        List<Integer> nodes = extractValues(root).stream().sorted().collect(Collectors.toList());
        return switch (nodes.size()) {
            case 1 -> new TreeNode(nodes.get(0));
            case 2 -> new TreeNode(nodes.get(1), new TreeNode(nodes.get(0)), null);
            case 3 -> new TreeNode(nodes.get(1), new TreeNode(nodes.get(0)), new TreeNode(nodes.get(2)));
            default -> buildTree(nodes, 0, nodes.size() - 1);
        };
    }

    private TreeNode buildTree(List<Integer> nodes, int left, int right) {
        if (left == right) {
            return new TreeNode(nodes.get(left));
        } else if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(nodes.get(left + (right - left) /2));
        root.left = buildTree(nodes, left, left + (right - left) / 2 - 1);
        root.right = buildTree(nodes, left + (right - left) / 2 + 1, right);
        return root;
    }

    private List<Integer> extractValues(TreeNode n) {
        List<Integer> result = new ArrayList<>();
        if (n.left != null) {
            result.addAll(extractValues(n.left));
        }

        if (n.right != null) {
            result.addAll(extractValues(n.right));
        }

        result.add(n.val);

        return result;
    }
}
