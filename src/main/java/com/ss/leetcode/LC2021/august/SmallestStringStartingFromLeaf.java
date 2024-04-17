package com.ss.leetcode.LC2021.august;

import com.ss.leetcode.shared.TreeNode;

public class SmallestStringStartingFromLeaf {
    // https://leetcode.com/problems/smallest-string-starting-from-leaf
    public String smallestFromLeaf(TreeNode root) {
        String[] smallest = { String.valueOf((char)('z' + 1)) };
        traverseTree(root, new StringBuilder(), smallest);
        return new StringBuilder(smallest[0]).reverse().toString();
    }

    private void traverseTree(TreeNode node, StringBuilder stb, String[] smallest) {
        if (node != null) {
            stb.append((char)(node.val + 'a'));
            if (node.left == node.right) {
                setSmallest(stb, smallest);
            } else {
                traverseTree(node.left, stb, smallest);
                traverseTree(node.right, stb, smallest);
            }
            stb.setLength(stb.length() - 1);
        }
    }

    private void setSmallest(StringBuilder stb, String[] smallest) {
        char stbChar, sChar;
        for (int i = stb.length() - 1, j = smallest[0].length() - 1; i >= 0 && j >= 0; i--, j--) {
            stbChar = stb.charAt(i);
            sChar = smallest[0].charAt(j);
            if (stbChar < sChar) {
                smallest[0] = stb.toString();
                return;
            } else if (stbChar > sChar) {
                return;
            }
        }
        if (stb.length() < smallest[0].length()) {
            smallest[0] = stb.toString();
        }
    }



    private static final char[] CHARS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
                                         'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public String smallestFromLeaf2(TreeNode root) {
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
