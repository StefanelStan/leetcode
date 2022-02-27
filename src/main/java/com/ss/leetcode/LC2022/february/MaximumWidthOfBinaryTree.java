package com.ss.leetcode.LC2022.february;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MaximumWidthOfBinaryTree {
    // https://leetcode.com/problems/maximum-width-of-binary-tree/
    // different from the accepted solution
    public int widthOfBinaryTree(TreeNode root) {
        if (root.left == root.right) {
            return 1;
        }
        List<Integer> nodesLevel = new ArrayList<>();
        nodesLevel.add(1);
        if (root.left != null) {
            nodesLevel.add(1);
            traverseTree(root.left, 2, true, nodesLevel);
        }
        if (root.right != null) {
            if (nodesLevel.size() < 2) {
                nodesLevel.add(1);
            } else {
                nodesLevel.set(1, 2);
            }
            traverseTree(root.right, 2, false, nodesLevel);
        }
        return nodesLevel.stream().max(Integer::compare).get();
    }

    private void traverseTree(TreeNode node, int level, boolean isLeft, List<Integer> nodesLevel) {
        if (node.left == node.right) {
            return;
        }
        if (isLeft) {
            // add both
            if (node.left != null) {
                if (nodesLevel.size() <= level) {
                    nodesLevel.add(2);
                } else {
                    nodesLevel.set(level, nodesLevel.get(level) + 2);
                }
            } else { //just add one
                if (nodesLevel.size() <= level) {
                    nodesLevel.add(1);
                } else {
                    nodesLevel.set(level, nodesLevel.get(level) + 1);
                }
            }

        } else {
            // add both
            if (node.right != null) {
                if (nodesLevel.size() <= level) {
                    nodesLevel.add(2);
                } else {
                    nodesLevel.set(level, nodesLevel.get(level) + 2);
                }
            } else { //just add one
                if (nodesLevel.size() <= level) {
                    nodesLevel.add(1);
                } else {
                    nodesLevel.set(level, nodesLevel.get(level) + 1);
                }
            }
        }
        if (node.left != null) {
            traverseTree(node.left, level + 1, isLeft, nodesLevel);
        }
        if (node.right != null) {
            traverseTree(node.right, level + 1, isLeft, nodesLevel);
        }
    }
}
