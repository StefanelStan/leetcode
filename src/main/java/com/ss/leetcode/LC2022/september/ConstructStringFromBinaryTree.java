package com.ss.leetcode.LC2022.september;

import com.ss.leetcode.shared.TreeNode;

public class ConstructStringFromBinaryTree {
    // https://leetcode.com/problems/construct-string-from-binary-tree/
    /** Algorithm
         1. Use a StringBuilder to append and build the answer in preorder traversal
         2. Append the current node val
         3. If (left is not null) OR (left is null AND right != null), add ( + dfs(leftNode) + ).
            This recursive method will either append the (val) OR (). Left nodes (excepting leafs) need to have () to maintain order
         4. If right is not null, append it ( + dfs(right) + )
         5. Return the string builder
     */
    public String tree2str(TreeNode root) {
        StringBuilder stb = new StringBuilder();
        traverseAndAdd(root, stb);
        return stb.toString();
    }

    private void traverseAndAdd(TreeNode node, StringBuilder stb) {
        if (node != null) {
            stb.append(node.val);
            if (node.left != null || node.right != null) {
                stb.append('(');
                traverseAndAdd(node.left, stb);
                stb.append(')');
            }
            if (node.right != null) {
                stb.append('(');
                traverseAndAdd(node.right, stb);
                stb.append(')');
            }
        }
    }
}
