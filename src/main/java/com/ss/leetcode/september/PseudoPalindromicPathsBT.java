package com.ss.leetcode.september;

import com.ss.leetcode.shared.TreeNode;

public class PseudoPalindromicPathsBT {
    // https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
    /**
     *  Theory: A palindrome can be formed if the char sequence contains ar most 1 odd number/group of chars.
     *          Eg: 4 chars of a, 3 chars of b and 6 chars of c can form a palindrime because we have at most one group of chars
     *          with odd cardinal (3 chars of b). 4a, 3b 5c cannot form a palindrome becuse we have 2 grops of odd cardinals.
     *  Algorithm
     *  1. Traverse Pre-Order and keep a counter of how many node vals you have in an array of 10 ints. ints[nodel.val].
     *  2. Pre-Order traversal: add the node.val to array, visit left, visit right then remove the node.val from array
     *  3. If leaf (no left/right), verify if the array of nodevals is palindromatic using the theory above.
     *     If Yes, increase the counter of palindromes;
     */
    public int pseudoPalindromicPaths(TreeNode root) {
        int[] nrOfPalindromes = new int[1];
        int[] nodeVal = new int[10];
        traverseTree(root, nodeVal, nrOfPalindromes);
        return nrOfPalindromes[0];
    }

    private void traverseTree(TreeNode node, int[] nodeVals, int[] nrOfPalindromes) {
        if (node != null) {
            nodeVals[node.val]++;
            if (node.left == null && node.right == null) {
                if (isPalindrome(nodeVals)) {
                    nrOfPalindromes[0]++;
                }
            } else {
                traverseTree(node.left, nodeVals, nrOfPalindromes);
                traverseTree(node.right, nodeVals, nrOfPalindromes);
            }
            nodeVals[node.val]--;
        }
    }

    private boolean isPalindrome(int[] nodeVals) {
        int oddNumbers = 0;
        for (int total : nodeVals) {
            if (total % 2 == 1) {
                oddNumbers++;
            }
        }
        return oddNumbers <= 1;
    }
}
