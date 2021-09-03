package com.ss.leetcode.september;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {
    // https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int[] maxDepth = {0};
        List<List<TreeNode>> paths = new ArrayList<>();
        if (root.left == null && root.right == null) {
            return root;
        }
        findDeepestLeaves(root, 0, maxDepth, new ArrayList<>(), paths);
        return findCommonAncestorInPaths(paths);
    }

    private void findDeepestLeaves(TreeNode node, int level, int[] maxDepth, List<TreeNode> currentPath, List<List<TreeNode>> paths) {
        if (node != null) {
            currentPath.add(node);
            if (level > maxDepth[0]) {
                paths.clear();
                maxDepth[0] = level;
            }
            if (level >= maxDepth[0]) {
                if (node.left == null && node.right == null) {
                    paths.add(currentPath);
                }
            }
            findDeepestLeaves(node.left, level + 1, maxDepth, new ArrayList<>(currentPath), paths);
            findDeepestLeaves(node.right, level + 1, maxDepth, new ArrayList<>(currentPath), paths);
        }
    }

    private TreeNode findCommonAncestorInPaths(List<List<TreeNode>> paths) {
        List<TreeNode> firstPath = paths.get(0);
        if (paths.size() == 1) {
            return firstPath.get(firstPath.size() -1);
        } else {
            for (int i = firstPath.size() -1; i>=0; i--) {
                boolean allMatched = true;
                for (List<TreeNode> path : paths) {
                    if (firstPath.get(i) != path.get(i)) {
                        allMatched = false;
                        break;
                    }
                }
                if (allMatched) {
                    return firstPath.get(i);
                }
            }
        }
        return firstPath.get(0);
    }
}
