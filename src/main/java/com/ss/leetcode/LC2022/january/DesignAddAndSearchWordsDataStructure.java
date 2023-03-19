package com.ss.leetcode.LC2022.january;


public class DesignAddAndSearchWordsDataStructure {
    // https://leetcode.com/problems/design-add-and-search-words-data-structure/
    TrieNode root;
    public DesignAddAndSearchWordsDataStructure() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        int codePoint;
        for (int i = 0; i < word.length(); i++) {
            codePoint = word.charAt(i) - 'a';
            if(current.links[codePoint] == null) {
                current.links[codePoint] = new TrieNode();
            }
            current = current.links[codePoint];
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        boolean[] found = {false};
        searchWord(root, word.toCharArray(), 0, found);
        return found[0];
    }

    private void searchWord(TrieNode node, char[] word, int index, boolean[] found) {
        if(found[0] || node == null || (index >= word.length && !node.isWord)) {
            return;
        }
        if (index == word.length) {
            found[0] = true;
            return;
        }
        char ch = word[index];
        if (ch != '.') {
            searchWord(node.links[ch - 'a'], word, index + 1, found);
        } else {
            for (int i = 0; i < 26 && !found[0]; i++) {
                searchWord(node.links[i], word, index + 1, found);
            }
        }
    }

    private static class TrieNode {
        TrieNode[] links;
        boolean isWord;

        public TrieNode() {
            this.links = new TrieNode[26];
        }
    }


    /** Version is quite long
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
     */
}
