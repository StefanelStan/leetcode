package com.ss.leetcode.july;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BalanceABST {
    // https://leetcode.com/problems/balance-a-binary-search-tree/
    public TreeNode balanceBST(TreeNode root) {
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
