package com.ss.leetcode.LC2023.april;

import com.ss.leetcode.shared.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class CousinsInBinaryTreeII {
    // https://leetcode.com/problems/cousins-in-binary-tree-ii
    /** Algorithm
        1. DFS Traverse the tree and use a List<Integer> to keep track of each level's node sum.
            [0] will keep track of sum of nodes on level 0, [1] for level 1 and so on
        2. Traverse the tree and for each node, if it is NOT null OR LEAF
            - get the sum of the two children
            - deduct the sum of the two children from the sum of all nodes on next level.
            - replace the values of each child with the difference.
        3. Root value will also be set to 0.
        4. Return the root.
    */
    public TreeNode replaceValueInTree(TreeNode root) {
        List<Integer> sumLevels = new ArrayList<>();
        traverseTree(root, 1, sumLevels);
        replaceValues(root, 1, sumLevels);
        root.val = 0;
        return root;
    }

    private void replaceValues(TreeNode node, int level, List<Integer> sumLevels) {
        if (node == null || node.left == node.right) {
            return;
        }
        int nextLevelSum = sumLevels.get(level);
        int childrenSum = node.left == null ? 0 : node.left.val;
        childrenSum += node.right == null ? 0 : node.right.val;
        if (node.left != null) {
            node.left.val = nextLevelSum - childrenSum;
        }
        if (node.right != null) {
            node.right.val = nextLevelSum - childrenSum;
        }
        replaceValues(node.left, level + 1, sumLevels);
        replaceValues(node.right, level + 1, sumLevels);
    }

    private void traverseTree(TreeNode node, int level, List<Integer> sumLevels) {
        if (node == null) {
            return;
        }
        if (level > sumLevels.size()) {
            sumLevels.add(0);
        }
        sumLevels.set(level - 1, sumLevels.get(level - 1) + node.val);
        traverseTree(node.left, level + 1, sumLevels);
        traverseTree(node.right, level + 1, sumLevels);
    }
}
