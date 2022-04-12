package com.ss.leetcode.LC2021.september;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class VerticalOrderTraversalOfABinaryTree {
    // https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root.left == root.right) {
            return List.of(List.of(root.val));
        }
        Map<Integer, List<int[]>> traversal = new TreeMap<>();
        traverseTree(root, 1,1, traversal);
        List<List<Integer>> vertical = new ArrayList<>(traversal.size());
        for (Map.Entry<Integer, List<int[]>> entry : traversal.entrySet()) {
            entry.getValue().sort((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            vertical.add(entry.getValue().stream().mapToInt(a -> a[1]).boxed().collect(Collectors.toList()));
        }
        return vertical;
    }

    private void traverseTree(TreeNode node, int xCoord, int level,  Map<Integer, List<int[]>> traversal) {
        if (node != null) {
            List<int[]> list = traversal.computeIfAbsent(xCoord, k -> new ArrayList<>());
            list.add(new int[]{level, node.val});
            traverseTree(node.left, xCoord - 1, level +1, traversal);
            traverseTree(node.right, xCoord + 1, level + 1, traversal);
        }
    }
}
