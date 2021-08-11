package com.ss.leetcode.august;

import com.ss.leetcode.shared.TreeNode;

public class SumOfNodesEvenValuedGrandparent {
    // https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
    public int sumEvenGrandparent(TreeNode root) {
        int[] sum = { 0 };
        traverseAndAddParents(root, 0, 0, 0, sum);
        return sum[0];
    }

    private void traverseAndAddParents(TreeNode node, int level, int parent, int grandparent, int[] sum) {
        if (node != null) {
            if (level >= 2) {
                if (grandparent % 2 == 0) {
                    sum[0] += node.val;
                }
            }
            traverseAndAddParents(node.left, level + 1, node.val, parent, sum);
            traverseAndAddParents(node.right, level + 1, node.val, parent, sum);
        }
    }
}
