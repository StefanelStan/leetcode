package com.ss.leetcode.LC2021.august;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumLevelSumOfABinaryTree {
    // https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
    public int maxLevelSum(TreeNode root) {
        List<Integer> levelSum = new ArrayList<>();
        traverseTree(root, 1, levelSum);
        int minLevel = Integer.MAX_VALUE, maxSum = Integer.MIN_VALUE, i = 1;
        for (int sum : levelSum) {
            if (sum > maxSum) {
                maxSum = sum;
                minLevel = i;
            } else if (sum == maxSum) {
                minLevel = Math.min(minLevel, i);
            }
            i++;
        }
        return minLevel;
    }

    private void traverseTree(TreeNode node, int level, List<Integer> levelSum) {
        if (node == null) {
            return;
        }
        if(level > levelSum.size()) {
            levelSum.add(0);
        }
        levelSum.set(level - 1, levelSum.get(level - 1) + node.val);
        traverseTree(node.left, level + 1, levelSum);
        traverseTree(node.right, level + 1, levelSum);
    }

    public int maxLevelSum2(TreeNode root) {
        Map<Integer, Integer> levelAndSum = new HashMap<>();
        traverseAndCalculateLevelSum(root, 1, levelAndSum);
        int maxSum = Integer.MIN_VALUE, level = 1;
        for(Map.Entry<Integer, Integer> entry : levelAndSum.entrySet()) {
            if (entry.getValue() > maxSum) {
                maxSum = entry.getValue();
                level = entry.getKey();
            }
        }
        return level;
    }

    private void traverseAndCalculateLevelSum(TreeNode node, int currentLevel, Map<Integer, Integer> levels) {
        if(node != null) {
            levels.merge(currentLevel, node.val, Integer::sum);
            traverseAndCalculateLevelSum(node.left, currentLevel + 1, levels);
            traverseAndCalculateLevelSum(node.right, currentLevel + 1, levels);
        }
    }
}
