package com.ss.leetcode.august;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindModeInBST {
    // https://leetcode.com/problems/find-mode-in-binary-search-tree/
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> modes =  new HashMap<>();
        int[] highestFreq = {-1};
        traverseAndCountNodes(root, highestFreq, modes);
        final List<Integer> topModes = new ArrayList<>();
        modes.forEach((k, v) -> {
            if (v == highestFreq[0]) {
                topModes.add(k);
            }
        });
        return topModes.stream().mapToInt(i -> i).toArray();
    }

    private void traverseAndCountNodes(TreeNode node, int[] highestFreq, Map<Integer, Integer> modes) {
        if (node != null) {
            modes.merge(node.val, 1, Integer::sum);
            if (modes.get(node.val) > highestFreq[0]) {
                highestFreq[0] = modes.get(node.val);
            }
            traverseAndCountNodes(node.left, highestFreq, modes);
            traverseAndCountNodes(node.right, highestFreq, modes);
        }
    }

//    private int[] getTopModes(Map<Integer, Integer> modes) {
//        List<Map.Entry<Integer, Integer>> values = new ArrayList<>(modes.entrySet());
//        values.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
//        List<Integer> bestValues = new ArrayList<>();
//        int highest = values.get(0).getValue();
//        for(var sortedEntry : values) {
//            if (sortedEntry.getValue() == highest) {
//                bestValues.add(sortedEntry.getKey());
//            } else {
//                break;
//            }
//        }
//        return bestValues.stream().mapToInt(i->i).toArray();
//    }
}
