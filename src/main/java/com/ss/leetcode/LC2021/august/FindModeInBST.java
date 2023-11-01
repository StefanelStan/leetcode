package com.ss.leetcode.LC2021.august;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindModeInBST {
    // https://leetcode.com/problems/find-mode-in-binary-search-tree/
    // SMALL improvement; count how many high freq you have to generate an int[nr_of_high_freq]
    public int[] findMode(TreeNode root) {
        int[] highestFreq = {0,0};
        Map<Integer, Integer> frequencies = new HashMap<>();
        traverseTree(root, frequencies, highestFreq);
        int[] modes = new int[highestFreq[1]];
        int insertIndex = 0;
        for(Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            if (entry.getValue() == highestFreq[0]) {
                modes[insertIndex++] = entry.getKey();
            }
        }
        return modes;
    }

    private void traverseTree(TreeNode node, Map<Integer, Integer> frequencies, int[] highestFreq) {
        if (node != null) {
            int newFreq = frequencies.merge(node.val, 1, Integer::sum);
            if (newFreq > highestFreq[0]) {
                highestFreq[0] = newFreq;
                highestFreq[1] = 1;
            } else if (newFreq == highestFreq[0]) {
                highestFreq[1]++;
            }
            traverseTree(node.left, frequencies, highestFreq);
            traverseTree(node.right, frequencies, highestFreq);
        }
    }

    public int[] findMode2(TreeNode root) {
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
