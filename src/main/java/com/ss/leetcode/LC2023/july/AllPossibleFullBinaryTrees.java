package com.ss.leetcode.LC2023.july;

import com.ss.leetcode.shared.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllPossibleFullBinaryTrees {
    // https://leetcode.com/problems/all-possible-full-binary-trees
    /** Algorithm
        1. As we look onto full binary tree, we understand that each node can have 0 or 2 children.
            Thus, the whole tree must have an ODD number of nodes.
            If root exists, then root can have 0 or +2 children. If each children has children, +2 and so on.
            Thus, 1 (root) + something_even = odd
            If n is even, return empty list.
        2. for given n, think of balancing the number of nodes of left and right
            EG: n = 7:
            - 1 node left and 5 on right
            - 3 nodes left and 3 right
            - 5 left and 1 right.
            - We observe that 1,3,5 node subtrees are repetitive, so we can cache that
        3. Using a recursive function, in a loop build the left and right subtree (1,5), (3,3),(5,1).
        4. Left subtree will return a List<TreeNode> possible subtrees(subroots)
            Right subtree will return a List<TreeNode> possible subtrees (subroots)
            Apply a cardinal function to connect all subtrees from left with all from right.
            Store the result into a cache List<TreeNode>[]
        5. Return cache[size];
     */
    private static List<TreeNode>[] cache;
    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return Collections.emptyList();
        }
        initCache();
        return generateTree(n);
    }

    private List<TreeNode> generateTree(int size) {
        if (cache[size] == null) {
            List<TreeNode> trees = new ArrayList<>();
            for (int i = 1; i < size; i+=2) {
                List<TreeNode> leftTrees = generateTree(i);
                List<TreeNode> rightTrees = generateTree(size - (i + 1));
                for (TreeNode leftTree : leftTrees) {
                    for (TreeNode rightTree : rightTrees) {
                        trees.add(new TreeNode(0, leftTree, rightTree));
                    }
                }
            }
            cache[size] = trees;
        }
        return cache[size];
    }

    private void initCache() {
        if (cache == null) {
            cache = new List[21];
            cache[1] = List.of(new TreeNode(0));
            cache[3] = List.of(new TreeNode(0, new TreeNode(0), new TreeNode(0)));
        }
    }
}
