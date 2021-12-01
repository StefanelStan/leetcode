package com.ss.leetcode.LC2021.october;

import java.util.HashMap;
import java.util.Map;

public class ImplementPrefixTrie {
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
}
