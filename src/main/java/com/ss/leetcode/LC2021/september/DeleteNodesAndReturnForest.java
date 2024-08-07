package com.ss.leetcode.LC2021.september;

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
        List<TreeNode> forest = new ArrayList<>();
        boolean[] deleted = new boolean[1001];
        for (int node: to_delete) {
            deleted[node] = true;
        }
        traverseTree(root, deleted, true, forest);
        return forest;
    }

    private void traverseTree(TreeNode node, boolean[] deleted, boolean parentDeleted, List<TreeNode> forest) {
        if (parentDeleted && !deleted[node.val]) {
            forest.add(node);
        }
        if (node.left != null) {
            traverseTree(node.left, deleted, deleted[node.val], forest);
            if (deleted[node.left.val]) {
                node.left = null;
            }
        }
        if (node.right != null) {
            traverseTree(node.right, deleted, deleted[node.val], forest);
            if (deleted[node.right.val]) {
                node.right = null;
            }
        }
    }

    public List<TreeNode> delNodes2(TreeNode root, int[] to_delete) {
        boolean[] toDelete = new boolean[1001];
        for (int deleted : to_delete) {
            toDelete[deleted] = true;
        }
        List<TreeNode> remaining = new ArrayList<>();
        traverseTree2(root, toDelete, false, remaining);
        return remaining;
    }

    private void traverseTree2(TreeNode node, boolean[] toDelete, boolean parentAdded, List<TreeNode> remaining) {
        if (node != null) {
            if (!toDelete[node.val]) {
                if (!parentAdded) {
                    remaining.add(node);
                }
                traverseTree2(node.left, toDelete, true, remaining);
                if (node.left != null && toDelete[node.left.val]) {
                    node.left = null;
                }
                traverseTree2(node.right, toDelete, true, remaining);
                if (node.right != null && toDelete[node.right.val]) {
                    node.right = null;
                }
            } else {
                traverseTree2(node.left, toDelete, false, remaining);
                traverseTree2(node.right, toDelete, false, remaining);
            }
        }
    }

    public List<TreeNode> delNodes3(TreeNode root, int[] to_delete) {
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
