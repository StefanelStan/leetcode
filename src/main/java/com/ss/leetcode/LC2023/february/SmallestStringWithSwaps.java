package com.ss.leetcode.LC2023.february;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmallestStringWithSwaps {
    // https://leetcode.com/problems/smallest-string-with-swaps
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        PathCompression pc = new PathCompression(s.length());
        for (List<Integer> pair : pairs) {
            pc.connect(pair.get(0), pair.get(1));
        }
        char[] str = new char[s.length()];
        Map<Integer, List<Integer>> subcomponents =  pc.getSubcomponents(s);
        subcomponents.forEach((k, subcomponent) -> {
            ArrayList<Character> chrs = new ArrayList<>(subcomponent.size());
            subcomponent.forEach(idx -> chrs.add(s.charAt(idx)));
            Collections.sort(chrs);
            for(int i = 0; i < chrs.size(); i++) {
                str[subcomponent.get(i)] = chrs.get(i);
            }
        });
        return new String(str);
    }

    private static class PathCompression {
        int[] root;

        public PathCompression(int size) {
            this.root = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
            }
        }

        public int find(int node) {
            if (root[node] == node) {
                return node;
            }
            int found = find(root[node]);
            root[node] = found;
            return found;
        }

        public void connect(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 != root2) {
                root[root2] = root1;
            }
        }

        public Map<Integer, List<Integer>> getSubcomponents(String s) {
            Map<Integer, List<Integer>> subcomponents = new HashMap<>();
            for (int i = 0; i < root.length; i++) {
                find(i);
                subcomponents.computeIfAbsent(root[i], k -> new ArrayList<>()).add(i);
            }
            return subcomponents;
        }
    }
}
