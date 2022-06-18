package com.ss.leetcode.LC2022.june;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrefixAndSuffixSearch {
    // https://leetcode.com/problems/prefix-and-suffix-search/
    // TLE
    PrefixAndSuffixTrie prefixTrie;
    PrefixAndSuffixTrie suffixTrie;

    public PrefixAndSuffixSearch(String[] words) {
        prefixTrie = new PrefixAndSuffixSearch.PrefixAndSuffixTrie();
        suffixTrie = new PrefixAndSuffixSearch.PrefixAndSuffixTrie();
        addToTrie(words);
    }

    private void addToTrie(String[] words) {
        for (int i = 0; i < words.length; i++) {
            prefixTrie.insertPrefix(words[i], i);
            suffixTrie.insertSuffix(words[i], i);
        }
    }

    public int f(String prefix, String suffix) {
        List<Integer> prefixes = getPrefixesOf(prefix);
        if (!prefixes.isEmpty()) {
            List<Integer> suffixes = getSuffixesOf(suffix);
            if (suffixes.isEmpty()) {
                return -1;
            } else {
                return getMaxCommonBetween(prefixes, suffixes);
            }
        } else {
            return -1;
        }
    }

    private List<Integer> getPrefixesOf(String prefix) {
        TrieNodeWithIndices node = prefixTrie.getPrefix(prefix);
        if (node != null) {
            return node.getEndingIndices();
        }
        return Collections.emptyList();
    }

    private List<Integer> getSuffixesOf(String suffix) {
        TrieNodeWithIndices node = suffixTrie.getSuffix(suffix);
        if (node != null) {
            return node.getEndingIndices();
        }
        return Collections.emptyList();
    }

    private int getMaxCommonBetween(List<Integer> prefixes, List<Integer> suffixes) {
        for (int i = prefixes.size() -1, j = suffixes.size() -1; i >= 0 && j >= 0;) {
            if (prefixes.get(i) == suffixes.get(j)) {
                return prefixes.get(i);
            } else if (prefixes.get(i) < suffixes.get(j)) {
                j--;
            } else {
                i--;
            }
        }

        return -1;
    }

    public static class PrefixAndSuffixTrie {
        TrieNodeWithIndices root = new TrieNodeWithIndices();

        public void insertPrefix(String string, int index) {
            TrieNodeWithIndices current = root;
            for (char ch : string.toCharArray()) {
                if (!current.containsKey(ch)) {
                    current.put(ch, new TrieNodeWithIndices(index));
                }
                current = current.get(ch);
                current.indices.add(index);
            }
        }

        public void insertSuffix(String string, int index) {
            TrieNodeWithIndices current = root;
            char ch;
            for (int i = string.length() -1; i >=0; i--) {
                ch = string.charAt(i);
                if (!current.containsKey(ch)) {
                    current.put(ch, new TrieNodeWithIndices());
                }
                current = current.get(ch);
                current.indices.add(index);
            }
        }

        private TrieNodeWithIndices getPrefix(String word) {
            TrieNodeWithIndices current = root;
            for (char ch : word.toCharArray()) {
                if(current.containsKey(ch)) {
                    current = current.get(ch);
                } else {
                    return null;
                }
            }
            return current;
        }

        private TrieNodeWithIndices getSuffix(String word) {
            TrieNodeWithIndices current = root;
            char ch;
            for (int i = word.length() -1; i >=0; i--) {
                ch = word.charAt(i);
                if(current.containsKey(ch)) {
                    current = current.get(ch);
                } else {
                    return null;
                }
            }
            return current;
        }
    }

    public static class TrieNodeWithIndices {
        private static final int R = 25;
        private final TrieNodeWithIndices[] links;
        private final List<Integer> indices = new ArrayList<>();

        public TrieNodeWithIndices() {
            this.links = new TrieNodeWithIndices[R];
        }

        public TrieNodeWithIndices(int index) {
            this.links = new TrieNodeWithIndices[R];
            indices.add(index);
        }

        public boolean containsKey(char key) {
            return links[key - 'a'] != null;
        }

        public TrieNodeWithIndices get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNodeWithIndices node) {
            links[ch - 'a'] = node;
        }

        public List<Integer> getEndingIndices() {
            return indices;
        }
    }
}
