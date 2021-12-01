package com.ss.leetcode.LC2021.july;

import com.ss.leetcode.shared.TreeNode;

public class FindCorrespondingNodeBTInClone {
    public TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (cloned ==  null) {
            return null;
        }
        if (cloned.val == target.val) {
            return cloned;
        }
        if (cloned.left != null) {
           TreeNode someNode = getTargetCopy(original, cloned.left, target);
           if (someNode != null) {
               return someNode;
           }
        }
        if (cloned.right != null) {
            return getTargetCopy(original, cloned.right, target);
        }
        return null;
    }
}
