package com.ss.leetcode.LC2021.august;

import com.ss.leetcode.shared.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class SumRootToLeaf {
    // https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
    public int sumRootToLeaf(TreeNode root) {
        List<String> numbers =  new LinkedList<>();
        sumRootToLeaf(root, new StringBuilder(), numbers);
        int[] sum = {0};
        numbers.forEach(nr -> sum[0] += Integer.parseInt(nr, 2));
        return sum[0];
    }

    private void sumRootToLeaf(TreeNode root, StringBuilder stb, List<String> numbers) {
        if (root != null) {
            stb.append(root.val);
            if (root.right == null && root.left == null) {
                numbers.add(stb.toString());
                return;
            }
            if (root.left != null) sumRootToLeaf(root.left, new StringBuilder(stb.toString()), numbers);
            if (root.right != null) sumRootToLeaf(root.right, new StringBuilder(stb.toString()), numbers);
        } else {
            numbers.add(stb.toString());
        }
    }
}
