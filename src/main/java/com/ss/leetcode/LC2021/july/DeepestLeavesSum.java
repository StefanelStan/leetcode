package com.ss.leetcode.LC2021.july;

import com.ss.leetcode.shared.TreeNode;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class DeepestLeavesSum {
    // https://leetcode.com/problems/deepest-leaves-sum/
    public int deepestLeavesSum(TreeNode root) {

        TreeMap<Integer, Integer> levelSumMap = new TreeMap<>(Comparator.reverseOrder());
        registerLeafValue(root, 0, levelSumMap);
        return levelSumMap.firstEntry().getValue();
    }

    private void registerLeafValue(TreeNode node, int level, Map<Integer, Integer> levelSumMap) {
        if (node.left == null && node.right == null) {
            levelSumMap.merge(level, node.val, Integer::sum);
            return;
        }
        if (node.left != null) {
            registerLeafValue(node.left, level + 1, levelSumMap);
        }
        if (node.right != null) {
            registerLeafValue(node.right, level + 1, levelSumMap);
        }
    }
}
