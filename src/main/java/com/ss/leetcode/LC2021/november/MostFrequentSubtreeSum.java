package com.ss.leetcode.LC2021.november;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum {
    // https://leetcode.com/problems/most-frequent-subtree-sum/
    public int[] findFrequentTreeSum(TreeNode root) {
        int[] maxFreq = {0};
        List<Integer> mostFrequent = new ArrayList<>(10);
        traverseTree(root, new HashMap<>(), mostFrequent, maxFreq);
        return mostFrequent.stream().mapToInt(i -> i).toArray();
    }

    private int traverseTree(TreeNode node, Map<Integer, Integer> numMap, List<Integer> freqs, int[] maxFreq) {
        if (node == null){
            return 0;
        }
        if (node.left == null && node.right == null) {
            int sumFreq = numMap.computeIfAbsent(node.val, k -> 0);
            sumFreq++;
            numMap.put(node.val, sumFreq);
            if (sumFreq > maxFreq[0]) {
                maxFreq[0] = sumFreq;
                freqs.clear();
                freqs.add(node.val);
            } else if (sumFreq == maxFreq[0]) {
                freqs.add(node.val);
            }
            return node.val;
        }
        int sum = traverseTree(node.left, numMap, freqs, maxFreq);
        sum += traverseTree(node.right, numMap, freqs, maxFreq);
        sum += node.val;
        int sumFreq = numMap.computeIfAbsent(sum, k -> 0);
        sumFreq++;
        numMap.put(sum, sumFreq);
        if (sumFreq > maxFreq[0]) {
            maxFreq[0] = sumFreq;
            freqs.clear();
            freqs.add(sum);
        } else if (sumFreq == maxFreq[0]) {
            freqs.add(sum);
        }
        return sum;
    }
}
