package com.ss.leetcode.LC2022.january;

import com.ss.leetcode.shared.TreeNode;

import java.util.Arrays;

public class BinaryTreeColoringGame {
    // https://leetcode.com/problems/binary-tree-coloring-game/submissions/
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        int[] groups = new int[3];
        traverseTree(root, groups, x, new boolean[]{false});
        groups[2] = n - (groups[1] + groups[0] + 1);
        Arrays.sort(groups);
        return groups[2] > groups[1] + groups[0];
    }

    public void traverseTree(TreeNode node, int[] groups, int x, boolean[] counted) {
        if (node == null || counted[0]) {
            return;
        }
        if (node.val == x) {
            groups[0] = countNodes(node.left);
            groups[1] = countNodes(node.right);
            counted[0] = true;
        } else {
            traverseTree(node.left, groups, x, counted);
            if (!counted[0]) {
                traverseTree(node.right, groups, x, counted);
            }
        }
    }

    public int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
}
