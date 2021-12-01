package com.ss.leetcode.LC2021.august;

import com.ss.leetcode.shared.TreeNode;

public class SmallestStringStartingFromLeaf {
    private static final char[] CHARS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
                                         'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public String smallestFromLeaf(TreeNode root) {
        String[] smallestString = {"{"};

        parseAndCompareLeaf(root, new StringBuilder(), smallestString);
        return smallestString[0];
    }

    private void parseAndCompareLeaf(TreeNode root, StringBuilder stb, String[] smallestString) {
        if (root != null) {
            stb.append(CHARS[root.val]);
            if (root.left == null && root.right == null) {
                String tempString = stb.reverse().toString();
                if (smallestString[0].compareTo(tempString) > 0) {
                    smallestString[0] = tempString;
                }
            } else {
                if (root.left != null) parseAndCompareLeaf(root.left, new StringBuilder(stb.toString()), smallestString);
                if (root.right != null) parseAndCompareLeaf(root.right, new StringBuilder(stb.toString()), smallestString);
            }
        }
    }
}
