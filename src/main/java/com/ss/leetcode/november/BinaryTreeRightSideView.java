package com.ss.leetcode.november;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    // https://leetcode.com/problems/binary-tree-right-side-view/
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        if (root != null) {
            view.add(root.val);
            parseTree(root, 1, view);
        }
        return view;
    }

    private void parseTree(TreeNode node, int level, List<Integer> view) {
        if (node != null) {
            if (level > view.size()) {
                view.add(node.val);
            }
            parseTree(node.right, level + 1, view);
            parseTree(node.left, level +1, view);
        }
    }
}
