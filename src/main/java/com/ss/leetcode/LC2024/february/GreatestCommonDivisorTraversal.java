package com.ss.leetcode.LC2024.february;

import java.util.ArrayList;
import java.util.List;

public class GreatestCommonDivisorTraversal {
    // https://leetcode.com/problems/greatest-common-divisor-traversal
    /** Algorithm
        1. The trick is to find if ALL the numbers belong to same UnionFind / Set.
        2. It is good to use union by rank and connect all nodes to the highest ranked root.
        3. The connections between the nodes are done via common divisors.
        4. It does not make sense to compute the divisors multiple times for the same number;
            so either sort them OR use a boolean[] present to mark each present number.
        5. The vertices can have multiple connections (edges):
            EG: 12 and 30 have multiple edges given by 2, 3, and 6 as all these are common divisors
        6. Make the bucket list of common divisors for each number (loop from 2 to Math.sqrt(num) + 1)
            and, if divisible, add current number to the divisor bucket
            - EG: 12, 30, 5
            - 2 -> [12,30]
            - 3 -> [12,30]
            - 4 -> [12]
            - 5 -> [30, 5]
            - 6 -> [12, 30]
            - 10 -> [30]
            - 12 -> [12]
            - 15 -> [30]
            - 30 -> [30]
            - ! You need to also put the same number in bucket in order to deal with prime numbers: eg: 7 and 49.
        7. Traverse each bucket, and, if the size > 1, try to connect node i with node i-1;
        8. As you are connecting only the unique numbers, the max rank of UnionFind should be == unique.
    */
    public boolean canTraverseAllPairs(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int max = 0, unique = 0;
        boolean[] present = new boolean[100_001];
        for (int num : nums) {
            if (!present[num]) {
                unique++;
            }
            present[num] = true;
            max = Math.max(max, num);
        }
        if (present[1]) {
            return false;
        }
        List<Integer>[] divisorGroups = getDivisorGroups(present, max + 1);
        UnionFindByRank uf = getUnionFind(divisorGroups, max + 1);
        return uf.maxRank == unique;
    }

    private UnionFindByRank getUnionFind(List<Integer>[] divisorGroups, int size) {
        UnionFindByRank unionFind = new UnionFindByRank(size);
        for (List<Integer> group : divisorGroups) {
            if (group != null) {
                for (int i = 1; i < group.size(); i++) {
                    unionFind.connect(group.get(i-1), group.get(i));
                }
            }
        }
        return unionFind;
    }

    private List<Integer>[] getDivisorGroups(boolean[] nums, int size) {
        List<Integer>[] divisorGroups = new List[size];
        for (int i = 0; i < size; i++) {
            if (nums[i]) {
                findDivisors(i, divisorGroups);
            }
        }
        return divisorGroups;
    }

    private void findDivisors(int num, List<Integer>[] divisorGroups) {
        if (num != 2) {
            setDivisor(2, num / 2, num % 2, num, divisorGroups);
        }
        for (int i = 3; i <= Math.sqrt(num) + 1; i++) {
            setDivisor(i, num / i, num % i, num, divisorGroups);
        }
        if (divisorGroups[num] == null) {
            divisorGroups[num] = new ArrayList<>();
        }
        divisorGroups[num].add(num);
    }

    private void setDivisor(int divisor, int divResult, int mod, int num, List<Integer>[] divisorGroups) {
        if (mod == 0) {
            if (divisorGroups[divisor] == null) {
                divisorGroups[divisor] = new ArrayList<>();
            }
            divisorGroups[divisor].add(num);
            if (divisor != divResult) {
                if (divisorGroups[divResult] == null) {
                    divisorGroups[divResult] = new ArrayList<>();
                }
                divisorGroups[divResult].add(num);
            }
        }
    }

    private static class UnionFindByRank {
        int[] root;
        int[] rank;
        int maxRank = 1;

        public UnionFindByRank(int size) {
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < root.length; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        private void connect(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 != root2) {
                if (rank[root1] >= rank[root2]) {
                    root[root2] = root1;
                    rank[root1] += rank[root2];
                    maxRank = Math.max(maxRank, rank[root1]);
                } else {
                    root[root1] = root2;
                    rank[root2] += rank[root1];
                    maxRank = Math.max(maxRank, rank[root2]);
                }
            }
        }

        private int find(int node) {
            if (root[node] != node) {
                root[node] = find(root[node]);
            }
            return root[node];
        }
    }
}
