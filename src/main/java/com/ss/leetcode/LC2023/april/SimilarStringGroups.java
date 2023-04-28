package com.ss.leetcode.LC2023.april;

public class SimilarStringGroups {
    // https://leetcode.com/problems/similar-string-groups
    /** Algorithm
        1. It all boils down to union find and number of disconnected components
            If str1 is similar to str2 then str1 is connected to str2
            If str3 is similar to str4 then str3 is connected to str4
            If str1 is similar to str4 then str1 is connecte to str4.
            Thus, str1,2,3,4 are part of the same disjoint set (connected component)
        2. Determining if str1 is similar to str2.
            Use i =0 and j = n-1 to traverse str1.
            Stop i when str1[i] != str2[i] and stop j when str1[j] != str2[j].
            EX: ABAZRT
                ARAZBT
            -  i is stopped at 1 and j is stopped at 4.
                We see that str1[i] != str2[j] AND str1[j] != str2[i]. Only on this condition we
                can swap the letters as pairs. If they would NOT match, we could not swap, returning false.
                Flag (boolean) is you have done one swap in order to return false immediately if another situation is encountered and you are no longer allowed to swap.
            - Also, if i == j (ABAZRT / ABAZUT) (they differ by one char), return false
                as you need 2 letters to swap in each string
        3. If two string are similar, connect them in the Union Find
        4. Return number of disconnectedComponents.
     */
    public int numSimilarGroups(String[] strs) {
        UnionFind union = new UnionFind(strs.length);
        char[][] chars = getAsChars(strs);
        for (int i = 0; i < strs.length - 1; i++) {
            for (int j = 1; j < strs.length; j++) {
                // check if they are already connected to SAME component
                if (!union.connected(i, j) && areMatching(chars[i], chars[j])) {
                    union.connect(i, j);
                }
            }
        }
        return union.disconnectedComponents();
    }

    private char[][] getAsChars(String[] strs) {
        char[][] chars = new char[strs.length][strs[0].length()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = strs[i].toCharArray();
        }
        return chars;
    }

    // move i from 0 and stop on first mismatch
    // move j from n to i and stop on first mismatch
    // if the two leters i from str1 == j from str2 and j from str1 == i from str2
    // only then you can de 1 swap. If 1 swap has been already done, return false;
    private boolean areMatching(char[] str1, char[] str2) {
        int i = 0, j = str1.length -1;
        boolean foundMismatch = false;
        while(i <= j) {
            while(i <=j && str1[i] == str2[i]) {
                i++;
            }
            while(i <= j && str1[j] == str2[j]) {
                j--;
            }
            if (i <= j) {
                if (i == j || foundMismatch || str1[i] != str2[j] || str1[j] != str2[i]) {
                    return false;
                } else {
                    foundMismatch = true;
                    i++;
                    j--;
                }
            }
        }
        return true;
    }

    private static class UnionFind {
        int[] root;
        int[] rank;

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        private void connect(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 != root2) {
                if (rank[root1] > rank[root2]) {
                    root[root2] = root1;
                } else if (rank[root1] < rank[root2]) {
                    root[root1] = root2;
                } else {
                    root[root2] = root1;
                    rank[root1]++;
                }
            }
        }

        public boolean connected(int node1, int node2) {
            return find(node1) == find(node2);
        }

        private int find(int node) {
            if (root[node] == node) {
                return node;
            }
            int found = find(root[node]);
            root[node] = found;
            return found;
        }

        public int disconnectedComponents() {
            int disconnected = 0;
            for (int i = 0; i < root.length; i++) {
                if (i == find(i)) {
                    disconnected++;
                }
            }
            return disconnected;
        }
    }
}
