package com.ss.leetcode.LC2021.november;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class EvenOddTree {
    // https://leetcode.com/problems/even-odd-tree/
    public boolean isEvenOddTree(TreeNode root) {
        boolean[] isEvenOdd = {true};
        traverseTree(root, 1, new ArrayList<>(), isEvenOdd);
        return isEvenOdd[0];
    }

    private void traverseTree(TreeNode node, int level, List<int[]> levelNodes, boolean[] isEvenOdd) {
        appendAndVerify(node, level, levelNodes, isEvenOdd);
        if (isEvenOdd[0] && node.left != null) {
            traverseTree(node.left, level + 1, levelNodes, isEvenOdd);
        }
        if (isEvenOdd[0] && node.right != null) {
            traverseTree(node.right, level + 1, levelNodes, isEvenOdd);
        }
    }

    private void appendAndVerify(TreeNode node, int level, List<int[]> levelNodes, boolean[] isEvenOdd) {
        boolean evenLevel = (level - 1) % 2 == 0;
        if ((evenLevel && node.val % 2 == 0) || (!evenLevel && node.val % 2 != 0)){
            isEvenOdd[0] = false;
            return;
        }
        if (level > levelNodes.size()) {
            int[] nodes = {0, node.val};
            levelNodes.add(nodes);
        } else {
            int[] nodes = levelNodes.get(level -1);
            nodes[0] = nodes[1];
            nodes[1] = node.val;
            if (evenLevel && nodes[0] >= nodes[1]) {
                isEvenOdd[0] = false;
            } else if (!evenLevel && nodes[0] <= nodes[1]) {
                isEvenOdd[0] = false;
            }
        }
    }
}
