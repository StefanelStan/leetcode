package com.ss.leetcode.LC2024.april;

public class GroupsOfStrings {
    // https://leetcode.com/problems/groups-of-strings
    // TLE
    public int[] groupStrings(String[] words) {
        int[][] signatures = getWordSignatures(words);
        UnionFind uf = getConnectedWords(words, signatures);
        return uf.getMaxSetsAndLargestSet();
    }

    private UnionFind getConnectedWords(String[] words, int[][] signatures) {
        UnionFind uf = new UnionFind(words.length);
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (Math.abs(words[i].length() - words[j].length()) < 2 && areConnected(signatures[i], signatures[j])) {
                    uf.connect(i, j);
                }
            }
        }
        return uf;
    }

    private boolean areConnected(int[] count1, int[] count2) {
        int aMinusB = 0, bMinusA = 0;
        for (int i = 0; i < 26 && aMinusB < 2 && bMinusA < 2; i++) {
            if (count1[i] > count2[i]) {
                aMinusB += count1[i] - count2[i];
            } else {
                bMinusA += count2[i] - count1[i];
            }
        }
        return aMinusB < 2 && bMinusA < 2;
    }

    private int[][] getWordSignatures(String[] words) {
        int[][] signatures = new int[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                signatures[i][words[i].charAt(j) - 'a']++;
            }
        }
        return signatures;
    }

    private static class UnionFind {
        int[] root;
        public UnionFind(int n) {
            root = new int[n];
            for (int i = 1; i < n; i++) {
                root[i] = i;
            }
        }

        public void connect(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 != root2) {
                root[root2] = root1;
            }
        }

        public int find(int node) {
            if (root[node] != node) {
                root[node] = find(root[node]);
            }
            return root[node];
        }

        public int[] getMaxSetsAndLargestSet() {
            int numberOfSets = 0, maxSetSize = 0;
            int[] setSize = new int[root.length];
            int currentNodeRoot;
            for (int i = 0; i < root.length; i++) {
                currentNodeRoot = find(i);
                if (currentNodeRoot == i) {
                    numberOfSets++;
                }
                setSize[currentNodeRoot]++;
                maxSetSize = Math.max(maxSetSize, setSize[currentNodeRoot]);
            }
            return new int[]{numberOfSets, maxSetSize};
        }
    }
}
