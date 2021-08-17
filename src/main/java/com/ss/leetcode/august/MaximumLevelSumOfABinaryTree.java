package com.ss.leetcode.august;

import com.ss.leetcode.shared.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class MaximumLevelSumOfABinaryTree {
    // https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
    public int maxLevelSum(TreeNode root) {
        Map<Integer, Integer> levelAndSum = new HashMap();
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
