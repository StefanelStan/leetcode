package com.ss.leetcode.october;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeIterator {
    // https://leetcode.com/problems/binary-search-tree-iterator/
    int currentIndex = 0;
    List<Integer> myList = new ArrayList<>();
    public BinarySearchTreeIterator(TreeNode root) {
        traverseTree(root);
    }

    private void traverseTree(TreeNode node) {
        if (node != null) {
            traverseTree(node.left);
            myList.add(node.val);
            traverseTree(node.right);
        }
    }

    public int next() {
        currentIndex++;
        return myList.get(currentIndex -1);
    }

    public boolean hasNext() {
        return currentIndex < myList.size();
    }
}
