package com.ss.leetcode.LC2023.january;

public class HtmlEntityParser {
    // https://leetcode.com/problems/html-entity-parser
    /** Algorithm
        1. Build a prefix tree by adding the given words: &quot, & amp etc.
            Each terminal node will also store the length (or the string itself) and the replacement string.
        2. Iterate over each char of text and try to see if you can build a prefix path in the Trie.
            If you fail at any step (other char, etc) just add the current index/letter to the answer and go to next
        3. If you find a prefix in the trie, add the replacement to the answer and skip your index by prefix.length
        4. Return the answer;
     */
    public String entityParser(String text) {
        char[] chrs = text.toCharArray();
        StringBuilder stb = new StringBuilder(text.length());
        Trie root = buildTrie();
        for (int i = 0; i < chrs.length;) {
            i = root.findAndInsertBestMatch(chrs, i, stb);
        }
        return stb.toString();
    }

    private Trie buildTrie() {
        Trie root =  new Trie();
        root.addWord("&quot;", "\"");
        root.addWord("&apos;", "'");
        root.addWord("&amp;", "&");
        root.addWord("&gt;", ">");
        root.addWord("&lt;", "<");
        root.addWord("&frasl;", "/");
        return root;
    }

    private static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void addWord(String word, String replacement) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                if (current.links[ch] == null) {
                    current.links[ch] = new TrieNode();
                }
                current = current.links[ch];
            }
            current.entity = word;
            current.replacement = replacement;
        }

        // try to walk the trie by stepping on the letters starting from index
        public int findAndInsertBestMatch(char[] chrs, int index, StringBuilder stb) {
            TrieNode current = root;
            for (int i = index; i < chrs.length; i++) {
                // if you step on a null letter/link, the path is not good. Just add the index to stb and return next pos
                if (current.links[chrs[i]] == null) {
                    stb.append(chrs[index]);
                    return index + 1;
                    // if your current link/node has an entity, it means you have a valid prefix. Add it and move index by its length
                } else if (current.links[chrs[i]].entity != null) {
                    stb.append(current.links[chrs[i]].replacement);
                    return index + current.links[chrs[i]].entity.length();
                    // else step on next letter.
                } else {
                    current = current.links[chrs[i]];
                }
            }
            // EDGE case: your string ends with half entity: &qu, &fra. No path will fail, but you won't finish the entire prefix
            // so just add the first letter and move on.
            stb.append(chrs[index]);
            return index + 1;
        }
    }

    private static class TrieNode {
        int R = 256;
        TrieNode[] links;
        String entity;
        String replacement;

        public TrieNode() {
            links = new TrieNode[R];
        }
    }
}
