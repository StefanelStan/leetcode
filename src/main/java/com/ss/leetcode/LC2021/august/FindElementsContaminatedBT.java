package com.ss.leetcode.LC2021.august;

import com.ss.leetcode.shared.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class FindElementsContaminatedBT {
    // https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/
    /** Algorithm
        1. Use a Set<Integer> to store the values of the real nodes.
        2. Populate the Set / Tree by DFS: a recursive function that takes a node and real value;
            - if the node is not null, add the real value to the set and call the function again passing left, right, realValue * 2 +1 / +2.
        3. Return true if the set contains target
     */
    private final Set<Integer> numbers;
    public FindElementsContaminatedBT(TreeNode root) {
        numbers = new HashSet<>();
        recoverTree(root, 0);
    }

    private void recoverTree(TreeNode node, int realValue) {
        if (node != null) {
            numbers.add(realValue);
            recoverTree(node.left, realValue * 2 + 1);
            recoverTree(node.right, realValue * 2 + 2);
        }
    }
    public boolean find(int target) {
        return numbers.contains(target);
    }


//    public FindElementsContaminatedBT2(TreeNode root) {
//        root.val = 0;
//        recoverTree(root);
//    }

    public boolean find2(int target) {
        return numbers.contains(target);
    }

    private void recoverTree2(TreeNode node) {
        numbers.add(node.val);
        if (node.left != null) {
            node.left.val = 2 * node.val +1;
            recoverTree2(node.left);
        }
        if (node.right != null) {
            node.right.val = 2 * node.val + 2;
            recoverTree2(node.right);
        }
    }
}
