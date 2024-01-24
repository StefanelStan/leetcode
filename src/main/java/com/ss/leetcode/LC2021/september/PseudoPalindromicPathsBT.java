package com.ss.leetcode.LC2021.september;

import com.ss.leetcode.shared.TreeNode;

public class PseudoPalindromicPathsBT {
    // https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
    /**
     *  1. Create an class CountValue with 3 methods: addValue, removeValue, isPalindromatic.
     *  2. This class will have an internal int[10] count that will keep track of how many numbers of each kind you have
     *  3. Each time you add a value from a node, the count will either go to an odd or even number.
     *     - So, each time you update the count of oddGroups.
     *     - EG: adding a 3 will mean you have [0,0,0,1..] -> 1 oddGroup
     *     - adding a 5 will mean [0,0,0,1,0,1..]   -> 2 odd group
     *     - since oddGroup > 1, you cannot make a palindrome of this.
     *  4. Traverse preoder (root, left, right):
     *     - return 0 is node is null
     *     - add each node.val to the CountValue
     *     - if leaf, return 1 if countValue is palindromatic, 0 otherwise
     *     - else determine the sum of leftsubtree palindromatic count, sum of right subtree
     *     - remove current node value from countValue
     *     - return sum.
     */
    public int pseudoPalindromicPaths (TreeNode root) {
        return countPalindromes(root, new ValueCount());
    }

    private int countPalindromes(TreeNode node, ValueCount vc) {
        if (node == null) {
            return 0;
        }
        vc.addValue(node.val);
        int count;
        if (node.left == node.right) {
            count = vc.isPalindromatic() ? 1 : 0;
        } else {
            count = countPalindromes(node.left, vc) + countPalindromes(node.right, vc);
        }
        vc.removeValue(node.val);
        return count;
    }

    private static class ValueCount {
        private int[] count =  new int[10];
        private int oddCount = 0;

        public void addValue(int value) {
            oddCount += (++count[value] % 2 == 0 ? -1 : 1);
        }

        public void removeValue(int value) {
            oddCount += (--count[value] % 2 == 0 ? -1 : 1);
        }

        public boolean isPalindromatic() {
            return oddCount < 2;
        }
    }
}
