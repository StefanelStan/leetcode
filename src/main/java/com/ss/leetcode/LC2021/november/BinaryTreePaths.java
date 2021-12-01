package com.ss.leetcode.LC2021.november;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    // https://leetcode.com/problems/binary-tree-paths/
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        parseTree(root, new ArrayList<>(), paths);
        return paths;
    }

    private void parseTree(TreeNode node, List<Integer> pathNodes, List<String> paths) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                pathNodes.add(node.val);
                paths.add(buildPath(pathNodes));
                pathNodes.remove(pathNodes.size() - 1);
            } else {
                pathNodes.add(node.val);
                parseTree(node.left, pathNodes, paths);
                parseTree(node.right, pathNodes, paths);
                pathNodes.remove(pathNodes.size() - 1);
            }
        }
    }

    private String buildPath(List<Integer> nodes) {
        StringBuilder stb = new StringBuilder();
        stb.append(nodes.get(0));
        for (int i = 1; i < nodes.size(); i++) {
            stb.append("->");
            stb.append(nodes.get(i));
        }
        return stb.toString();
    }
}
