package com.ss.leetcode.LC2021.july;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllElementsInTwoBST {
    // https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        list1.addAll(extractValues(root1));
        list1.addAll(extractValues(root2));
        Collections.sort(list1);
        return list1;
    }
    private List<Integer> extractValues(TreeNode n) {
        List<Integer> result = new ArrayList<>();
        if (n == null) {
            return result;
        }
        if (n.left != null) {
            result.addAll(extractValues(n.left));
        }

        if (n.right != null) {
            result.addAll(extractValues(n.right));
        }

        result.add(n.val);

        return result;
    }
}
