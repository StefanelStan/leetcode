package com.ss.leetcode.LC2024.october;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveSubFolderFromTheFilesystem {
    // https://leetcode.com/problems/remove-sub-folders-from-the-filesystem
    /** Algorithm
        1. Use a Trie to store the paths of each given folder.
        2. Trie will use a Map<String, TrieNode> to map each folder name: some folders can have names like "/ab",so we can't use TrieNode[]
        3. For each folder, split it into chunks by "/". Add each chunk in the trie. Set the terminal node to be isFolder = true.
        4. Use a recursive function to traverse/iterate through the current level of trie.
            - if current level has a final / isFolder node, add that string (key) to path and add the path in the answer list,
            - else, add that string/chunk to the path and recursively call the method passing the mapped TrieNode.
            - remember to remove the last added chunk from the path.
     */
    public List<String> removeSubfolders(String[] folder) {
        TrieNode root = buildTrie(folder);
        List<String> mainFolders = new ArrayList<>();
        traverseAndAdd(root, new StringBuilder(), mainFolders);
        return mainFolders;
    }

    private void traverseAndAdd(TrieNode root, StringBuilder stb, List<String> mainFolders) {
        stb.append('/');
        for (Map.Entry<String, TrieNode> currentEntry : root.nodes.entrySet()) {
            stb.append(currentEntry.getKey());
            if (currentEntry.getValue().isFolder) {
                mainFolders.add(stb.toString());
            } else {
                traverseAndAdd(currentEntry.getValue(), stb, mainFolders);
            }
            stb.setLength(stb.length() - currentEntry.getKey().length());
        }
        stb.setLength(stb.length() - 1);
    }

    private TrieNode buildTrie(String[] folders) {
        TrieNode root = new TrieNode();
        for (String folder : folders) {
            addToTrie(folder.split("/"), root);
        }
        return root;
    }

    private void addToTrie(String[] paths, TrieNode root) {
        for (String path : paths) {
            if (!path.isEmpty()) {
                root = root.addNode(path);
                if (root.isFolder) {
                    break;
                }
            }
        }
        root.isFolder = true;
    }

    private static class TrieNode {
        Map<String, TrieNode> nodes;
        boolean isFolder;
        public TrieNode() {
            this.nodes = new HashMap<>();
        }

        public TrieNode addNode(String subPath) {
            return nodes.computeIfAbsent(subPath, k -> new TrieNode());
        }

        public TrieNode getNode(String subPath) {
            return nodes.get(subPath);
        }
    }
}
