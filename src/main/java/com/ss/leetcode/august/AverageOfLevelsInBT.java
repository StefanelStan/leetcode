package com.ss.leetcode.august;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AverageOfLevelsInBT {
    // https://leetcode.com/problems/average-of-levels-in-binary-tree/
    public List<Double> averageOfLevels(TreeNode root) {
        List<long[]> levelNodes = new ArrayList<>();
        traverseTree(root, 1, levelNodes);
        return getAverageLevels(levelNodes);
    }

    private void traverseTree(TreeNode node, int nodeLevel, List<long[]> levelNodes) {
        if (node != null) {
            if (nodeLevel > levelNodes.size() ) {
                long[] val =  {node.val, 1};
                levelNodes.add(val);
            } else {
                long[] existingVal = levelNodes.get(nodeLevel-1);
                existingVal[0] += node.val;
                existingVal[1]++;
            }
            traverseTree(node.left, nodeLevel +1, levelNodes);
            traverseTree(node.right, nodeLevel +1, levelNodes);
        }
    }

    private List<Double> getAverageLevels(List<long[]> levelNodes) {
        List<Double> averages = new ArrayList<>(levelNodes.size());
        for(long[] level : levelNodes) {
            averages.add(((double)level[0])/level[1]);
        }
        return averages;
    }
}
