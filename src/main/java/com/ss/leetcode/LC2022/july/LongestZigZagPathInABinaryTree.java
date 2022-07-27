package com.ss.leetcode.LC2022.july;

import com.ss.leetcode.shared.TreeNode;

public class LongestZigZagPathInABinaryTree {
    // https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
    /** Algorithm
     1. Use a helper method that will receive the currentNode, the length of current path so far
         and the direction from where you arrived into the current node.
     2. IF CurrentNode has a left node
         - if currentPath is coming from rightSide. then travelling left will increse the length by 1, as it's zigzag
         - if currentPath if coming from leftSide, then travelling left will "reset" the path, creating a new one of size 1
         (travelling left twice is not allowed, so the path gets reset from this point onwards)
     3. Same logic for right node. Depending from the direction you arrived here, going left or right will cause the
        passed current path to increment by 1 (if zigzag) or to be = 1 if same direction.
     */
    public int longestZigZag(TreeNode root) {
        int[] longestPath = {0};
        // entering the root node will give a length of 0
        traverseZigZag(root, 0, true, longestPath);
        return longestPath[0];
    }

    public void traverseZigZag(TreeNode node, int lengthSoFar, boolean comingFromLeft, int[] longestPath) {
        // set the new max of path, if available
        longestPath[0] = Math.max(longestPath[0], lengthSoFar);
        if (node.left != null) {
            // if arriving from LEFT and continuing RIGHT will increase the length by 1 (zigzag), but going LEFT again will reset the path.
            int lengthToTravel = comingFromLeft ? 1 : lengthSoFar + 1;
            traverseZigZag(node.left, lengthToTravel, true, longestPath);
        }
        if (node.right != null) {
            int lengthToTravel = comingFromLeft ? lengthSoFar + 1 : 1;
            traverseZigZag(node.right, lengthToTravel, false, longestPath);
        }
    }
}
