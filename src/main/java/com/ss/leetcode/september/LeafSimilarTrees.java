package com.ss.leetcode.september;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    // https://leetcode.com/problems/leaf-similar-trees/
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> treeOneLeafs = new ArrayList<>();
        List<Integer> treeTwoLeafs = new ArrayList<>();
        traverseTree(root1, treeOneLeafs);
        traverseTree(root2, treeTwoLeafs);
        return treeOneLeafs.equals(treeTwoLeafs);
    }

    private void traverseTree(TreeNode node, List<Integer> leafs) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                leafs.add(node.val);
            }
            traverseTree(node.left, leafs);
            traverseTree(node.right, leafs);
        }
    }
}
