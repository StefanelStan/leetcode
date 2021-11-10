package com.ss.leetcode.november;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindLargestValueInEachTreeRow {
    // https://leetcode.com/problems/find-largest-value-in-each-tree-row/
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> largestValues = new ArrayList<>();
        if (root != null) {
            largestValues.add(root.val);
            traverseTree(root, 0, largestValues);
        }
        return largestValues;
    }

    private void traverseTree(TreeNode node, int level, List<Integer> maxValues) {
        if (node == null) {
            return;
        }
        if (level < maxValues.size()) {
            maxValues.set(level, Math.max(node.val, maxValues.get(level)));
        } else {
            maxValues.add(node.val);
        }
        traverseTree(node.left, level + 1, maxValues);
        traverseTree(node.right, level + 1, maxValues);
    }
}
