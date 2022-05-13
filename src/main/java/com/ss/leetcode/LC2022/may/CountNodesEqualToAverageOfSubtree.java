package com.ss.leetcode.LC2022.may;

import com.ss.leetcode.shared.TreeNode;

public class CountNodesEqualToAverageOfSubtree {
    // https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
    /** Algorithm:
         1. Traverse preOrder : left, right, middle. Also use an int[1] avgNodes to increment/store the answer
         2. The traversal method will return an int[2] that will store the [sum, count] of left/right subtree recursively
         3. If the avg vals of left, right and current node == current.node then increment the avgNode count
         4. Return the avg vals of current node upwards.
     */
    public int averageOfSubtree(TreeNode root) {
        int[] avgNodes = {0};
        traverseTree(root, avgNodes);
        return avgNodes[0];
    }

    // [sum, count]
    private int[] traverseTree(TreeNode node, int[] avgNodes) {
        if(node == null) {
            return new int[]{0,0};
        }
        int[] leftVals = traverseTree(node.left, avgNodes);
        int[] rightVals = traverseTree(node.right, avgNodes);
        int[] subtreeVals = {node.val + leftVals[0] + rightVals[0], 1 + leftVals[1] + rightVals[1]};
        if (subtreeVals[0] / subtreeVals[1] == node.val) {
            avgNodes[0]++;
        }
        return subtreeVals;
    }
}
