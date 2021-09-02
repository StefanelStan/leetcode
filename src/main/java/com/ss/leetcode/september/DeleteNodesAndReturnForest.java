package com.ss.leetcode.september;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class DeleteNodesAndReturnForest {
    // https://leetcode.com/problems/delete-nodes-and-return-forest/
    /**
     * Algorithm:
     *  1. if to_delete is empty, return root.
     *  2. As max node is 1000, cache the deletion position into an array of booleans for faster access. (array faster than sets!)
     *  3. Create a List that will hold the forest. Pay attention to root of tree as this could be deleted as well. If not, then add it to forest
     *  4. In a recursion, pass the node, its parent and left/right side to method. This way if the node is to be deleted, then set parent left/right to null.
     *  5. If the current node is not to be deleted but its parent was deleted, then add it to forest
     */
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (to_delete.length == 0) {
            return List.of(root);
        }
        boolean[] deletion = new boolean[1001];
        for (int to_del : to_delete) {
            deletion[to_del] = true;
        }
        List<TreeNode> forest = new ArrayList<>();
        if (deletion[root.val]) {
            parseAndDeleteNodes(root.left, root, true, true, forest, deletion);
            parseAndDeleteNodes(root.right, root, false, true, forest, deletion);
        } else {
            forest.add(root);
            parseAndDeleteNodes(root, root, false, deletion[root.val], forest, deletion);
        }
        return forest;
    }

    private void parseAndDeleteNodes(TreeNode node, TreeNode parent, boolean isLeft, boolean parentDeleted, List<TreeNode> forest, boolean[] deletion) {
        if (node != null) {
            if (deletion[node.val]) {
                if (isLeft) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else if (parentDeleted) {
                forest.add(node);
            }
            parseAndDeleteNodes(node.left, node, true, deletion[node.val], forest, deletion);
            parseAndDeleteNodes(node.right, node, false, deletion[node.val], forest, deletion);
        }
    }
}
