package com.ss.leetcode.july;

import com.ss.leetcode.shared.TreeNode;

public class ConvertSortedArrayToBST {
    // https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
    public TreeNode sortedArrayToBST(int[] preorder) {
        if (preorder.length < 2) {
            return new TreeNode(preorder[0]);
        } else if (preorder.length < 3) {
            return new TreeNode(preorder[0], null, new TreeNode(preorder[1]));
        } else if (preorder.length < 4) {
            return new TreeNode(preorder[1], new TreeNode(preorder[0]), new TreeNode(preorder[2]));
        } else {
            TreeNode root = new TreeNode(preorder[preorder.length / 2]);
            root.left = constructTree(preorder, 0, preorder.length / 2 - 1);
            root.right = constructTree(preorder, preorder.length / 2 + 1, preorder.length - 1);
            return root;
        }
    }

    private TreeNode constructTree(int[] preorder, int begin, int end) {
        if (begin == end) {
            return new TreeNode(preorder[begin]);
        } else if (begin > end) {
            return null;
        }
        TreeNode middle = new TreeNode(preorder[begin + (end - begin) / 2]);

        middle.left = constructTree(preorder, begin, begin + (end - begin) / 2 - 1);
        middle.right = constructTree(preorder, begin + (end - begin) / 2 + 1, end);
        return middle;
    }
}
