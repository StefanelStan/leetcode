package com.ss.leetcode.shared;


public class Trie {
    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }


    public void insert(String word) {
        TrieNode currentNode = root;
        for (char ch : word.toCharArray()) {
            if (!currentNode.containsKey(ch)) {
                currentNode.put(ch, new TrieNode());
            }
            currentNode = currentNode.get(ch);
        }
        currentNode.setEnd();
    }

    /**
     * 1. Search for a full word. The node must be a terminal for the given word. EG: Trie: C -> A -> R -> S.
     *    search(car) returns false cause the r node is not terminal; it is linked to S
     * 2. Trie: C -> A -> R. and search for (cars);
     *    findPrefix(cars) returns null (the linked node of R). Because it's null,  search returns false and node needs to be not null and terminal
     */
    public boolean search(String word) {
        TrieNode foundNode = getPrefix(word);
        return foundNode != null && foundNode.isEnd();
    }

    private TrieNode getPrefix(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            if(current.containsKey(ch)) {
                current = current.get(ch);
            } else {
                return null;
            }
        }
        return current;
    }

    public boolean startsWith(String word) {
        TrieNode node = getPrefix(word);
        return node != null;
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


