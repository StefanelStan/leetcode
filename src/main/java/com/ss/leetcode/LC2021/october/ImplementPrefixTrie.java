package com.ss.leetcode.LC2021.october;

import java.util.HashMap;
import java.util.Map;

public class ImplementPrefixTrie {
    // https://leetcode.com/problems/implement-trie-prefix-tree
    TrieNode root;
    public ImplementPrefixTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        int codePoint;
        for (int i = 0; i < word.length(); i++) {
            codePoint = word.charAt(i) - 'a';
            if (current.links[codePoint] == null) {
                current.links[codePoint] = new TrieNode();
            }
            current = current.links[codePoint];
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        int codePoint;
        for (int i = 0; i < word.length(); i++) {
            codePoint = word.charAt(i) - 'a';
            if (current.links[codePoint] == null) {
                return false;
            }
            current = current.links[codePoint];
        }
        return current != null && current.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        int codePoint;
        for (int i = 0; i < prefix.length(); i++) {
            codePoint = prefix.charAt(i) - 'a';
            if (current.links[codePoint] == null) {
                return false;
            }
            current = current.links[codePoint];
        }
        return current != null;
    }

    private static class TrieNode {
        int R = 26;
        TrieNode[] links;
        boolean isWord;

        public TrieNode() {
            links = new TrieNode[R];
        }
    }
    /**
    private final Map<String, TrieWord> trieWords;

    public ImplementPrefixTrie() {
        this.trieWords = new HashMap<>();
    }

    public void insert(String word) {
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < word.length() -1; i++) {
            stb.append(word.charAt(i));
            trieWords.computeIfAbsent(stb.toString(), t -> new TrieWord());
        }
        trieWords.computeIfAbsent(word, t -> new TrieWord()).isWord = true;
    }

    public boolean search(String word) {
        TrieWord tw = trieWords.get(word);
        if (tw == null) {
            return false;
        } else {
            return tw.isWord;
        }
    }

    public boolean startsWith(String prefix) {
        return trieWords.containsKey(prefix);
    }

    private static final class TrieWord {
        private boolean isWord;
    }
     */
}
