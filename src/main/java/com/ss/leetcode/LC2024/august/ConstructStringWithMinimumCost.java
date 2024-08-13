package com.ss.leetcode.LC2024.august;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConstructStringWithMinimumCost {
    // https://leetcode.com/problems/construct-string-with-minimum-cost
    // TODO fix TLE
    public int minimumCost(String target, String[] words, int[] costs) {
        Integer[] cost = new Integer[target.length()];
        List<char[]> wordLetters = Arrays.stream(words).map(String::toCharArray).toList();
        TrieNode root = buildTrie(wordLetters, costs);
        int[] minCost = {Integer.MAX_VALUE};
        findMinCost(target.toCharArray(), 0, 0, root, minCost, cost);
        return cost[0] == Integer.MAX_VALUE ? -1 : cost[0];
    }

    private int findMinCost(char[] target, int index, int sum, TrieNode trie, int[] minCost, Integer[] cost) {
        if (index == target.length) {
            minCost[0] = Math.min(sum, minCost[0]);
            return 0;
        }
        if (cost[index] == null) {
            cost[index] = Integer.MAX_VALUE;
            int candidate = 0;
            TrieNode current = trie;
            List<int[]> costIndex = new ArrayList<>();
            for (int i = index; i < target.length && current.getNode(target[i]) != null; i++) {
                current = current.getNode(target[i]);
                if (current.isWord() && sum + current.cost < minCost[0]) {
                    costIndex.add(new int[]{current.cost, i});
                }
                Collections.sort(costIndex, Comparator.comparingInt(a -> a[0]));
                for (int[] nextCost : costIndex) {
                    if (nextCost[1] + sum < minCost[0]) {
                        candidate = findMinCost(target, nextCost[1] + 1, sum + nextCost[0], trie, minCost, cost);
                        if (candidate != Integer.MAX_VALUE) {
                            cost[index] = Math.min(cost[index], candidate + nextCost[0]);
                        }
                    }
                }
            }
        }
        return cost[index];
    }

    private TrieNode buildTrie(List<char[]> wordLetters, int[] cost) {
        TrieNode root = new TrieNode();
        TrieNode current;
        for (int i = 0; i < wordLetters.size(); i++) {
            current = root;
            for (int j = 0; j < wordLetters.get(i).length; j++) {
                current = current.addNode(wordLetters.get(i)[j]);
            }
            current.setCost(cost[i]);
        }
        return root;
    }

    private static class TrieNode {
        private final TrieNode[] links;
        private int cost = Integer.MAX_VALUE;

        public TrieNode() {
            this.links = new TrieNode[26];
        }

        public TrieNode addNode(char ch) {
            if (links[ch - 'a'] == null) {
                links[ch - 'a'] = new TrieNode();
            }
            return links[ch - 'a'];
        }

        public TrieNode getNode(char ch) {
            return links[ch - 'a'];
        }

        public boolean isWord() {
            return cost > 0 && cost != Integer.MAX_VALUE;
        }

        public void setCost(int cost) {
            this.cost = Math.min(this.cost, cost);
        }
    }
}
