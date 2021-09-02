package com.ss.leetcode.september;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    // https://leetcode.com/problems/unique-binary-search-trees-ii/
    public List<TreeNode> generateTrees(int n) {
        return buildTrees(1, n);
    }

    private List<TreeNode> buildTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if(start > end) {
            list.add(null);
            return list;
        }
        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubtrees = buildTrees(start, i - 1);
            List<TreeNode> rightSubtrees = buildTrees(i + 1, end);
            for (TreeNode leftNode : leftSubtrees) {
                for (TreeNode rightNode : rightSubtrees) {
                    TreeNode newRoot = new TreeNode(i, leftNode, rightNode);
                    list.add(newRoot);
                }
            }
        }
        return list;
    }
}
