package com.ss.leetcode.LC2023.september;

public class ExtraCharactersInAString {
    // https://leetcode.com/problems/extra-characters-in-a-string
    /** Algorithm
        1. Use a Trie to insert all the dictionary words
        2. For each letter in string s, we have two options: pick that letter and try to walk over the Trie OR
            ignore that letter, skip it and try to see if you can walk on the Trie starting with the next letter.
        3. Use an int[] minExtra of size s.length() to cache the intermediary results of walking on the path
        4. For each index, (0, s.length(), if it was NOT walked already, walk it and determine the best/MIN score)
            - EG: "abcdefg", ["abc","def"];
            - if we walk from index 0, we see that we find the word "abc". Thus, the next walk will start from index 3.
            - at index 3 we walk and we see that we find word def. So we jump to index 6.
            - at index 6 we have g, which is NOT in trie.
            Thus, for index 0, 3 and 6 we have the cost [1,MAX,MAX,1,MAX,MAX,1]
        5. Not picking. If we decide to NOT pick current index, we jump to index 1 and we try to walk.
            - skipping fast-forward, if we keep skipping, we will reach index 3, which was already calculated, so we make use of that.
     */
    public int minExtraChar(String s, String[] dictionary) {
        return traverse(0, s.toCharArray(), buildTrie(dictionary), new Integer[s.length()]);
    }

    private int traverse(int index, char[] sentence, TrieNode trie, Integer[] extraChars) {
        if (index == sentence.length) {
            return 0;
        }
        if (extraChars[index] == null) {
            extraChars[index] = 100;
            // pick and walk
            TrieNode trieHead = trie;
            int start = index;
            while (start < sentence.length && trieHead.getNode(sentence[start] - 'a') != null) {
                trieHead = trieHead.getNode(sentence[start] - 'a');
                if (trieHead.isWord()) {
                    extraChars[index] = Math.min(extraChars[index], traverse(start + 1, sentence, trie, extraChars));
                }
                start++;
            }
            //skip
            extraChars[index] = Math.min(extraChars[index], 1 + traverse(index + 1, sentence, trie, extraChars));
        }
        return extraChars[index];
    }

    private TrieNode buildTrie(String[] dictionary) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            addToTrie(root, word);
        }
        return root;
    }

    private void addToTrie(TrieNode root, String word) {
        for (int i = 0; i < word.length(); i++) {
            root = root.addNode(word.charAt(i) - 'a');
        }
        root.setWord();
    }

    private static class TrieNode {
        TrieNode[] nodes;
        boolean isWord;
        public TrieNode() {
            nodes = new TrieNode[26];
        }

        public TrieNode addNode(int codePoint) {
            if (nodes[codePoint] == null) {
                nodes[codePoint] = new TrieNode();
            }
            return nodes[codePoint];
        }

        public TrieNode getNode(int codePoint) {
            return nodes[codePoint];
        }

        public boolean isWord() {
            return this.isWord;
        }

        public void setWord() {
            this.isWord = true;
        }
    }
}
