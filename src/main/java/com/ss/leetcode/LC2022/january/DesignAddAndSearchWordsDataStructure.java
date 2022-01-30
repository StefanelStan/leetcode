package com.ss.leetcode.LC2022.january;


public class DesignAddAndSearchWordsDataStructure {
    TrieNode root;

    public DesignAddAndSearchWordsDataStructure() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            if (!current.containsKey(word.charAt(i))) {
                current.put(word.charAt(i), new TrieNode());
            }
            current = current.get(word.charAt(i));
        }
        current.setEnd();
    }

    public boolean search(String word) {
        boolean[] found = { false };
        TrieNode node = root;
        searchForWord(node, word, 0, found);
        return found[0];
    }

    private void searchForWord(TrieNode node, String word, int index, boolean[] found) {
        if (index >= word.length() || found[0]) {
            return;
        }
        // treat last char
        if (index == word.length() - 1) {
            if (word.charAt(index) != '.') {
                if (node.containsKey(word.charAt(index)) && node.get(word.charAt(index)).isEnd()) {
                    found[0] = true;
                }
            } else {
                for (int i = 0; i < 26; i++) {
                    if (node.containsKey((char) ('a' + i)) && node.get((char) ('a' + i)).isEnd()) {
                        found[0] = true;
                        return;
                    }
                }
            }
        } else {
            if (word.charAt(index) != '.') {
                if (node.containsKey(word.charAt(index))) {
                    searchForWord(node.get(word.charAt(index)), word, index + 1, found);
                }
            } else {
                for (int i = 0; i < 26; i++) {
                    if (!found[0] && node.containsKey((char) ('a' + i))) {
                        searchForWord(node.get((char) ('a' + i)), word, index + 1, found);
                    }
                }
            }
        }
    }

    private static class TrieNode {
        private static final int R = 26;
        private final TrieNode[] links;
        private boolean isEnd;

        public TrieNode() {
            this.links = new TrieNode[R];
        }

        public boolean containsKey(char key) {
            return links[key - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            this.isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }
}
