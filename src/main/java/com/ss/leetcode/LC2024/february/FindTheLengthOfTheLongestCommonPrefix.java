package com.ss.leetcode.LC2024.february;

public class FindTheLengthOfTheLongestCommonPrefix {
    // https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix
    /** Algorithm
        1. You can brute force each combination i, j from arr1, arr2 but this is not efficient
        2. Build a prefix trie of the numbers (as strings) from arr2
        3. For each number (string) of arr1, check and see how long you can "walk" on the prefix tree of arr2.
            - Smart tip: do not walk if current num/string of arr1 is lesser than the max/longest prefix known so far
    */
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie root = new Trie();
        for (int num : arr2) {
            root.addWord(String.valueOf(num));
        }
        int longest = 0;
        String val;
        for (int num : arr1) {
            val = String.valueOf(num);
            if (val.length() > longest) {
                longest = Math.max(longest, root.findLongestPrefix(val));
            }
        }
        return longest;
    }


    private static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode first = root;
            int codePoint;
            for (int i = 0; i < word.length(); i++) {
                codePoint = word.charAt(i) - '0';
                if (first.nodes[codePoint] == null) {
                    first.nodes[codePoint] = new TrieNode();
                }
                first = first.nodes[codePoint];
            }
        }

        public int findLongestPrefix(String word) {
            TrieNode first = root;
            int i = 0, codePoint;
            while (i < word.length()) {
                codePoint = word.charAt(i) - '0';
                if (first.nodes[codePoint] == null) {
                    return i;
                }
                first = first.nodes[codePoint];
                i++;
            }
            return i;
        }
    }

    private static class TrieNode {
        TrieNode[] nodes;

        public TrieNode() {
            nodes = new TrieNode[10];
        }
    }
}
