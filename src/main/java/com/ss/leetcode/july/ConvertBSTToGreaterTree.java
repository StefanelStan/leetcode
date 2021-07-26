package com.ss.leetcode.july;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertBSTToGreaterTree {
    // https://leetcode.com/problems/convert-bst-to-greater-tree/
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        Map<Integer, Integer> greaterSums = new HashMap<>();
        List<Integer> orderedValues = extractValues(root);
        Collections.sort(orderedValues);
        int sum = 0;
        for (int i = orderedValues.size() -1; i >= 0; i--) {
            sum += orderedValues.get(i);
            greaterSums.put(orderedValues.get(i), sum);
        }
        visitAndTransform(root, greaterSums);

        return root;
    }

    private List<Integer> extractValues(TreeNode node) {
        List<Integer> values =  new ArrayList<>();
        if(node.left != null) {
            values.addAll(extractValues(node.left));
        }

        if(node.right != null) {
            values.addAll(extractValues(node.right));
        }

        values.add(node.val);
        return values;
    }


    private void visitAndTransform(TreeNode root, Map<Integer, Integer> greaterSums) {
        root.val = greaterSums.get(root.val);
        if(root.left != null) {
            visitAndTransform(root.left, greaterSums);
        }
        if(root.right != null) {
            visitAndTransform(root.right, greaterSums);
        }
    }
}
