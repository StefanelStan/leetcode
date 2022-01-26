package com.ss.leetcode.LC2021.july;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllElementsInTwoBST {
    // https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> treeOneElements = new ArrayList<>();
        List<Integer> treeTwoElements = new ArrayList<>();
        traverseTree(root1, treeOneElements);
        traverseTree(root2, treeTwoElements);
        if (treeOneElements.isEmpty()) {
            return treeTwoElements;
        } else if (treeTwoElements.isEmpty()) {
            return treeOneElements;
        } else {
            return mergeLists(treeOneElements, treeTwoElements);
        }
    }

    private void traverseTree(TreeNode node, List<Integer> elements) {
        if (node != null) {
            traverseTree(node.left, elements);
            elements.add(node.val);
            traverseTree(node.right, elements);
        }
    }

    private List<Integer> mergeLists(List<Integer> list1, List<Integer> list2) {
        int i = 0, j = 0;
        List<Integer> merged = new ArrayList<>(list1.size() + list2.size());
        while(i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                merged.add(list1.get(i++));
            } else if (list1.get(i) == list2.get(j)) {
                merged.add(list1.get(i++));
                merged.add(list2.get(j++));
            } else {
                merged.add(list2.get(j++));
            }
        }
        if (i == list1.size()) {
            addToEnd(j, list2, merged);
        } else {
            addToEnd(i, list1, merged);
        }
        return merged;
    }

    private void addToEnd(int start, List<Integer> from, List<Integer> to) {
        while(start < from.size()) {
            to.add(from.get(start++));
        }
    }

    public List<Integer> getAllElements2(TreeNode root1, TreeNode root2) {
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
