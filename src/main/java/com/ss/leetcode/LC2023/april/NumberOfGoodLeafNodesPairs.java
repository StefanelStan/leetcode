package com.ss.leetcode.LC2023.april;

import com.ss.leetcode.shared.TreeNode;

public class NumberOfGoodLeafNodesPairs {
    // https://leetcode.com/problems/number-of-good-leaf-nodes-pairs
    public int countPairs(TreeNode root, int distance) {
        if (distance == 1) {
            return 0;
        }
        int[] count = {0};
        traverseTree(root, distance, count);
        return count[0];
    }

    private int[][] traverseTree(TreeNode node, int distance, int[] count) {
        int[][] distances = null;
        if (node != null) {
            if (node.left == node.right) {
                distances = new int[2][11];
                distances[0][1] = 1;
                for (int i = 1; i <= 10; i++) {
                    distances[1][i] = 1;
                }
            } else {
                int[][] left = traverseTree(node.left, distance, count);
                int[][] right = traverseTree(node.right, distance, count);
                distances = left == null || right == null
                    ? shiftDistances(left == null ? right : left)
                    : countAndMergeDistances(left, right, distance, count);
            }
        }
        return distances;
    }

    private int[][] countAndMergeDistances(int[][] left, int[][] right, int distance, int[] count) {
        count[0] += countDistances(left, right, distance);
        return mergeDistances(left, right);
    }

    private int countDistances(int[][] left, int[][] right, int distance) {
        int count = 0;
        for (int j = Math.min(10, distance) - 1; j >= 1; j--) {
            if (left[0][j] != 0) {
                count += left[0][j] * right[1][distance - j];
            }
        }
        return count;
    }

    private int[][] mergeDistances(int[][] left, int[][] right) {
        int prefixSum = 0;
        int prev = left[0][1] + right[0][1];
        left[0][1] = 0;
        right[0][1] = 0;
        left[1][1] = 0;
        right[1][1] = 0;
        int curr;
        for (int i = 2; i <= 10; i++) {
            prefixSum += prev;
            curr = left[0][i] + right[0][i];
            right[0][i] = prev;
            prev = curr;
            right[1][i] = prefixSum;
        }
        return right;
    }

    private int[][] shiftDistances(int[][] dist) {
        for (int i = 10; i >= 1; i--) {
            dist[0][i] = dist[0][i - 1];
            dist[1][i] = dist[1][i - 1];
        }
        return dist;
    }

    /**
    public int countPairs(TreeNode root, int distance) {
        if (distance == 1) {
            return 0;
        }
        int[] count = {0};
        traverseTree(root, distance, count);
        return count[0];
    }

    private int[][] traverseTree(TreeNode node, int distance, int[] count) {
        int[][] distances = null;
        if (node != null) {
            if (node.left == node.right) {
                distances = new int[2][1001];
                distances[0][0] = 1;
                distances[0][1000] = 1;
                distances[0][1] = 1;
                distances[1][1] = 1;
            } else {
                int[][] left = traverseTree(node.left, distance, count);
                int[][] right = traverseTree(node.right, distance, count);
                distances = left == null || right == null
                    ? shiftDistances(left == null ? right : left)
                    : countAndMergeDistances(left, right, distance, count);
            }
        }
        return distances;
    }

    private int[][] countAndMergeDistances(int[][] left, int[][] right, int distance, int[] count) {
        count[0] += countDistances(left, right, distance);
        return mergeDistances(left, right);
    }

    private int countDistances(int[][] left, int[][] right, int distance) {
        int count = 0;
        for (int j = left[0][1000]; j >= left[0][0]; j--) {
            if (left[0][j] != 0 && j < distance) {
                count += left[0][j] * right[1][Math.min(distance - j, right[0][1000])];
            }
        }
        return count;
    }

    private int[][] mergeDistances(int[][] left, int[][] right) {
        int prefixSum = 0;
        int min = Math.min(left[0][0], right[0][0]);
        int max = Math.max(left[0][1000], right[0][1000]);
        int prev = left[0][min] + right[0][min];
        left[0][min] = 0;
        right[0][min] = 0;
        left[1][min] = 0;
        right[1][min] = 0;
        int curr;
        for (int i = min + 1; i <= max + 1; i++) {
            prefixSum += prev;
            curr = left[0][i] + right[0][i];
            right[0][i] = prev;
            prev = curr;
            right[1][i] = prefixSum;
        }
        right[0][0] = min + 1;
        right[0][1000] = max + 1;
        return right;
    }

    private int[][] shiftDistances(int[][] dist) {
        for (int i = dist[0][1000]; i >= dist[0][0]; i--) {
            dist[0][i+1] = dist[0][i];
            dist[1][i+1] = dist[1][i];
            dist[0][i] = 0;
            dist[1][i] = 0;
        }
        dist[0][0]++;
        dist[0][1000]++;
        return dist;
    }
     */
}
