package com.ss.leetcode.LC2021.january;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class LongestStringChain {
    // https://leetcode.com/problems/longest-string-chain/
    public int longestStrChain(String[] words) {
        List<LongestChain>[] chains = mapWords(words);
        int longest = 0, candidate = 0;
        for (int i = chains.length - 1; i > 0; i--) {
            if (chains[i] != null) {
                for (LongestChain chain : chains[i]) {
                    chain.chainSize = 1 + findNextChain(chain.chars, i + 1, chains);
                    longest = Math.max(longest, chain.chainSize);
                }
            }
        }
        return longest;
    }

    private int findNextChain(char[] chars, int nextPos, List<LongestChain>[] chains) {
        if (nextPos >= chains.length || chains[nextPos] == null) {
            return 0;
        }
        int candidate = 0;
        for (LongestChain chain : chains[nextPos]) {
            if (isPredecessor(chars, chain.chars)) {
                candidate = Math.max(candidate, chain.chainSize);
            }
        }
        return candidate;
    }

    private List<LongestChain>[] mapWords(String[] words) {
        List<LongestChain>[] chains = new List[17];
        for (String word : words) {
            if (chains[word.length()] == null) {
                chains[word.length()] = new ArrayList<>();
            }
            chains[word.length()].add(new LongestChain(word.toCharArray()));
        }
        return chains;
    }

    private boolean isPredecessor(char[] shortWord, char[] longWord) {
        int diffs = 0;
        for (int i = 0, j = 0; i < shortWord.length && j < longWord.length && diffs < 2;) {
            if (shortWord[i] != longWord[j]) {
                diffs++;
                j++;
            } else {
                i++;
                j++;
            }

        }
        return diffs < 2;
    }

    private static class LongestChain {
        char[] chars;
        int chainSize;

        public LongestChain(char[] chars) {
            this.chars = chars;
        }
    }













    /** Algorithm
        1. Put each String into its own bucket based on length: 1,2.3 etc.
            This way, if we want to measure the chain made by a string of length 3 we need to look in the bucket of length 4
        2. Create an array of size 17 of such buckets.
            Use an object  WordChain to hold the bucket. Each WordChain object will consist of one list of strings (char[]),
            one list of int chainSizes ( could use a map char[] -> int) AND the TRIE of the whole bucket of words
        3. Iterate from right to left. if the bucket i is NOT empty and bucket i + 1 is not empty, try to build chains between the two sets of words
        4. The core of the algorithm is to check If an char[] {a,c,b} can be part of a TRIE of 4 letters with the option to skip one
        5. If current trie node exists, then walk over and advance in the char[]
            If the current trie node does not exist and you can skip, then select any other available node [0,25] and walk over it
            If current trie node does not exist and you cannot skip, return 0.
            Also, if you can skip, also try skipping the current node.
        6. There will be edge cases such as "fabc" (bucket of 4) and "fabfe", "xfacb".
            If you walk on the f, this will lead to the path "fabfe", which you cannot build a chain
            If you skip, then skip the f node, so you can jump into the path of x -> facb
        7. Return the longest chain ever build.
     */
    public int longestStrChain2(String[] words) {
        WordChain[] wordChains = getWordChains(words);
        int longest = 1;
        for (int i = 15; i >= 1; i--) {
            if (wordChains[i] != null && wordChains[i+1] != null) {
                longest = Math.max(longest, buildWordChain(wordChains[i], wordChains[i+1]));
            }
        }
        return longest;
    }

    private int buildWordChain(WordChain leftWords, WordChain rightWords) {
        int longest = 1;
        for (int i = 0; i < leftWords.words.size(); i++) {
            leftWords.chainSizes.set(i, 1 + getMaxChain(leftWords.words.get(i), 0, true, rightWords.root, rightWords));
            longest = Math.max(longest, leftWords.chainSizes.get(i));
        }

        return longest;
    }

    private int getMaxChain(char[] left, int index, boolean canSkip, TreeNode root, WordChain rightWords) {
        if (index >= left.length) {

            int max = 0;
            if (root.isWord) {
                return rightWords.chainSizes.get(root.groupIndex);
            }
            for (TreeNode node : root.nodes) {
                if (node != null) {
                    max = Math.max(max, rightWords.chainSizes.get(node.groupIndex));
                }
            }
            return max;
        }
        if (!root.hasNode(left[index])) {
            if (!canSkip) {
                return 0;
            }
            else {
                int max = 0;
                for (TreeNode node : root.nodes) {
                    if (node != null) {
                        max = Math.max(max, getMaxChain(left, index, false, node, rightWords));
                    }
                }
                return max;
            }
        }

        int max = getMaxChain(left, index + 1, canSkip, root.getNode(left[index]), rightWords);
        if (canSkip) {
            for (TreeNode node : root.nodes) {
                if (node != null) {
                    max = Math.max(max, getMaxChain(left, index, false, node, rightWords));
                }
            }
        }
        return max;

    }

    private WordChain[] getWordChains(String[] words) {
        WordChain[] wordChains = new WordChain[17];
        for (String word : words) {
            if (wordChains[word.length()] == null) {
                wordChains[word.length()] = new WordChain();
            }
            wordChains[word.length()].addWord(word);
        }
        return wordChains;
    }

    private static class WordChain {
        List<char[]> words;
        List<Integer> chainSizes;
        TreeNode root;

        public WordChain() {
            words = new ArrayList<>();
            chainSizes = new ArrayList<>();
            root = new TreeNode();
        }

        public void addWord(String word) {
            words.add(word.toCharArray());
            chainSizes.add(1);
            addToRoot(words.size() - 1,  words.get(words.size() - 1));
        }

        public void addToRoot(int index, char[] chars) {
            TreeNode copy = root;
            for (char c : chars) {
                copy = copy.addIfNull(c);
            }
            copy.setFinalWordAndGroupIndex(index);
        }

    }

    public static class TreeNode {
        TreeNode[] nodes;
        boolean isWord;
        int groupIndex;

        public TreeNode() {
            nodes = new TreeNode[26];
        }

        public TreeNode addIfNull(char c) {
            if (nodes[c - 'a'] == null) {
                nodes[c - 'a'] = new TreeNode();
            }
            return nodes[c - 'a'];
        }

        public TreeNode getNode(char c) {
            return nodes[c - 'a'];
        }

        public boolean hasNode(char c) {
            return nodes[c - 'a'] != null;
        }

        public void setFinalWordAndGroupIndex(int groupIndex) {
            this.isWord = true;
            this.groupIndex = groupIndex;
        }
    }
















    public int longestStrChain3(String[] words) {
        if (words.length == 1) {
            return 1;
        }
        int[] lengthStart = new int[18];
        Arrays.fill(lengthStart, -1);
        Arrays.sort(words, Comparator.comparingInt(word -> word.length()));
        int[] maxLengths = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            if (lengthStart[words[i].length()] == -1) {
                lengthStart[words[i].length()] = i;
            }
        }
        for (int i = 0; i < lengthStart[words[words.length -1].length()]; i++) {
            if (lengthStart[words[i].length() + 1] != -1) {
                searchAndMakeChain(words, i, lengthStart[words[i].length() + 1], maxLengths);
            }
        }
        int max = 1;
        for (int length : maxLengths) {
            max = Math.max(max, length);
        }
        return max;
    }

    private boolean canMakeChain(char[] s1, char[] s2) {
        boolean skippedOnce = false;
        for (int i = 0, j = 0; i < s1.length && j < s2.length;) {
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                if (skippedOnce) {
                    return false;
                } else {
                    skippedOnce = true;
                    j++;
                }
            }
        }
        return true;
    }

    private void searchAndMakeChain(String[] words, int wIndex, int startIndex, int[] maxLengths) {
        char[] word = words[wIndex].toCharArray();
        for (int i = startIndex; i < words.length && words[i].length() == words[startIndex].length(); i++) {
            if (canMakeChain(word, words[i].toCharArray())) {
                if (maxLengths[wIndex] == 0) {
                    maxLengths[wIndex] = 1;
                    maxLengths[i] = Math.max(2, maxLengths[i]);
                } else {
                    maxLengths[i] = Math.max(maxLengths[i] , maxLengths[wIndex] + 1);
                }
            }
        }
    }

    public int longestStrChain4(String[] words) {
        NavigableMap<Integer, List<String>> lenghtOfWords = putWordsIntoMap(words);
        Map<String, Integer> longestChain = new HashMap<>();

        detectLongestChainsInWords(longestChain, lenghtOfWords);

        return longestChain.values().stream().mapToInt(v -> v).max().orElse(1);
    }

    private NavigableMap<Integer, List<String>> putWordsIntoMap(String[] words) {
        NavigableMap<Integer, List<String>> lengthToChars = new TreeMap<>();
        for (String word : words) {
            List<String> list = lengthToChars.get(word.length());
            if (list == null) {
                list = new LinkedList<>();
            }
            list.add(word);
            lengthToChars.putIfAbsent(word.length(), list);
        }
        return lengthToChars;
    }


    private void detectLongestChainsInWords(Map<String, Integer> longestChain, NavigableMap<Integer, List<String>> lenghtOfWords) {
        lenghtOfWords.forEach((length, words) -> {
            if (length == 1) {
                words.forEach(word -> longestChain.put(word, 1));
            } else {
                words.forEach(word -> {
                    findLongestSubchain(word, longestChain, lenghtOfWords);
                });
            }

        });

    }

    private void findLongestSubchain(String word, Map<String, Integer> longestChain,
                                     NavigableMap<Integer, List<String>> lenghtOfWords) {
        List<String> subwords = lenghtOfWords.get(word.length() -1);
        if(subwords == null || subwords.isEmpty()) {
            longestChain.put(word, 1);
            return;
        } else {
            // detect if subword is part of word and if yes, get maxValue and set it to longestChain.
            final int[] maxLength = {0};
            subwords.forEach(subword -> {
                if(isSubword(word, subword)) {
                    maxLength[0] = Math.max(maxLength[0], longestChain.get(subword));
                }
            });
            longestChain.put(word, 1 + maxLength[0]);
        }
    }

    private boolean isSubword(String word, String subword) {
        boolean skippedOnce = false;
        for(int i = 0, j = 0; i < word.length() && j < subword.length(); i++, j++) {
            if(word.charAt(i) !=  subword.charAt(j)) {
                if(!skippedOnce) {
                    skippedOnce = true;
                    j--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
