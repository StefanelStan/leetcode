package com.ss.leetcode.july;

import com.ss.leetcode.shared.TreeNode;

import java.util.Arrays;

public class ConstructBSTFromPreorderTraversal {
    // https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
    public TreeNode bstFromPreorder(int[] preorder) {
        Arrays.sort(preorder);
        if (preorder.length < 2) {
            return new TreeNode(preorder[0]);
        } else if (preorder.length < 3) {
            return new TreeNode(preorder[1], new TreeNode(preorder[0]), null);
        } else if (preorder.length < 4) {
            return new TreeNode(preorder[1], new TreeNode(preorder[0]), new TreeNode(preorder[2]));
        } else {
            TreeNode root = new TreeNode(preorder[preorder.length/2]);
            TreeNode lastLeft = null;
            TreeNode currentLeft = new TreeNode(preorder[0]);
            TreeNode currentRight = new TreeNode(preorder[preorder.length -1]);
            TreeNode lastRight = null;
            for (int i = 1; i < preorder.length /2; i++) {
                lastLeft = new TreeNode(preorder[i], currentLeft, null);
                currentLeft = lastLeft;
            }
            for (int i = preorder.length - 2; i > preorder.length /2; i--) {
                lastRight = new TreeNode(preorder[i], null, currentRight);
                currentRight = lastRight;
            }

            root.left = lastLeft;
            root.right = lastRight;
            return root;
        }
    }
}
