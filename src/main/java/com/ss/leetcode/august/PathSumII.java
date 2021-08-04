package com.ss.leetcode.august;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    // https://leetcode.com/problems/path-sum-ii/
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        findPaths(root, targetSum, 0, new ArrayList<Integer>(), paths);
        return paths;
    }

    private void findPaths(TreeNode node, int targetSum, int currentSum, List<Integer> currentList,
                           List<List<Integer>> paths) {
        if(node != null) {
            currentList.add(node.val);
            currentSum += node.val;

            if (currentSum == targetSum && node.left == null && node.right == null) {
                paths.add(currentList);
            } else {
                findPaths(node.left, targetSum, currentSum, new ArrayList<>(currentList), paths);
                findPaths(node.right, targetSum, currentSum, new ArrayList<>(currentList), paths);
            }
        }
    }
}
