package com.ss.leetcode.LC2023.april;

import com.ss.leetcode.shared.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class ClosestNodesQueriesInABinarySearchTree {
    // https://leetcode.com/problems/closest-nodes-queries-in-a-binary-search-tree
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> closestNodes = new ArrayList<>(queries.size());
        List<Integer> inOrder = new ArrayList<>();
        traverseTree(root, inOrder);
        for (int query : queries) {
            closestNodes.add(findClosestNodes(inOrder, query));
        }
        return closestNodes;
    }

    private List<Integer> findClosestNodes(List<Integer> inOrder, int target) {
        if (target < inOrder.get(0)) {
            return List.of(-1, inOrder.get(0));
        } else if (target > inOrder.get(inOrder.size() - 1)) {
            return List.of(inOrder.get(inOrder.size() - 1), -1);
        }
        int idx = binarySearch(inOrder, target);
        if (inOrder.get(idx) == target) {
            return List.of(target, target);
        } else {
            return List.of(inOrder.get(idx -1), inOrder.get(idx));
        }
    }

    private int binarySearch(List<Integer> inOrder, int target) {
        int low = 0, high = inOrder.size() -1, pivot;
        while (low <= high) {
            pivot = low + (high - low) / 2;
            if (inOrder.get(pivot) == target) {
                return pivot;
            } else if (inOrder.get(pivot) < target) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }
        return low;
    }

    private void traverseTree(TreeNode node, List<Integer> inOrder) {
        if (node != null) {
            traverseTree(node.left, inOrder);
            inOrder.add(node.val);
            traverseTree(node.right, inOrder);
        }
    }



    // TLE (too slow for 2 x Binary search.
    public List<List<Integer>> closestNodes2(TreeNode root, List<Integer> queries) {
        List<List<Integer>> closestNodes = new ArrayList<>(queries.size());
        int min = findMinMax(root, true);
        int max = findMinMax(root, false);
        for (int query : queries) {
            int[] ls = {-1};
            int[] sg = {Integer.MAX_VALUE};
            if (query < min) {
                closestNodes.add(List.of(-1, min));
            } else if (query > max) {
                closestNodes.add(List.of(max, -1));
            } else if (query == min || query == max) {
                closestNodes.add(List.of(query, query));
            } else {
                findLargestSmaller(root, query, ls);
                if (ls[0] == query) {
                    closestNodes.add(List.of(ls[0], ls[0]));
                } else {
                    findSmallestGreater(root, query, sg);
                    closestNodes.add(List.of(ls[0], sg[0]));
                }
            }
        }
        return closestNodes;
    }

    private void findLargestSmaller(TreeNode node, int target, int[] ls) {
        if (node != null) {
            if (node.val == target) {
                ls[0] = target;
            } else if (target < node.val) {
                findLargestSmaller(node.left, target, ls);
            } else {
                ls[0] = Math.max(ls[0], node.val);
                findLargestSmaller(node.right, target, ls);
            }
        }
    }

    private void findSmallestGreater(TreeNode node, int target, int[] ls) {
        if (node != null) {
            if (node.val == target) {
                ls[0] = target;
            } else if (target < node.val) {
                ls[0] = Math.min(ls[0], node.val);
                findSmallestGreater(node.left, target, ls);
            } else {
                findSmallestGreater(node.right, target, ls);
            }
        }
    }

    private void find(TreeNode node, int query, boolean isLargestSmaller, int[] ans) {
        if (node == null) {
            return;
        }
        if (node.val == query) {
            ans[0] = query;
        } else if (node.val < query) {
            if (isLargestSmaller) {
                ans[0] = Math.max(ans[0], node.val);
            }
            find(node.right, query, isLargestSmaller, ans);
        } else {
            if (!isLargestSmaller) {
                ans[0] = Math.min(ans[0], node.val);
            }
            find(node.left, query, isLargestSmaller, ans);
        }
    }

    private int findMinMax(TreeNode node, boolean isMin) {
        if (node.left == node.right) {
            return node.val;
        }
        if (isMin) {
            return node.left == null ? node.val : findMinMax(node.left, isMin);
        } else {
            return node.right == null ? node.val : findMinMax(node.right, isMin);
        }
    }
}
