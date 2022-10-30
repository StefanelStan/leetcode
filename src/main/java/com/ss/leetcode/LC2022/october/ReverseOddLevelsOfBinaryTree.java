package com.ss.leetcode.LC2022.october;

import com.ss.leetcode.shared.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class ReverseOddLevelsOfBinaryTree {
    // https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/
    /** Algorithm
         1. Store the odd levels into a List<List<TreeNode>>
         2. Traverse each list with i=0, j = end, i++,j-- and swap the values of the two nodes.
         3. Return the root;
     */
    public TreeNode reverseOddLevels(TreeNode root) {
        List<List<TreeNode>> evenLevels = new ArrayList<>();
        // counting from level 0 to n-1, odd levels are 1,3 etc.
        // Counting from 1 to n, odd levels are in fact 2,4. This helps calculating the level in array list.
        traverseTree(root, 1, evenLevels);
        reverseLevels(evenLevels);
        return root;
    }

    private void traverseTree(TreeNode node, int level, List<List<TreeNode>> evenLevels) {
        if (node != null) {
            if (level % 2 == 0) {
                if (level/2 >= evenLevels.size()) {
                    evenLevels.add(new ArrayList<>());
                }
                evenLevels.get(level / 2 - 1).add(node);
            }
            traverseTree(node.left, level + 1, evenLevels);
            traverseTree(node.right, level + 1, evenLevels);
        }
    }

    private void reverseLevels(List<List<TreeNode>> evenLevels) {
        int temp;
        for (List<TreeNode> listNodes : evenLevels) {
            for (int i = 0, j = listNodes.size() - 1; i < j; i++, j--) {
                temp = listNodes.get(i).val;
                listNodes.get(i).val = listNodes.get(j).val;
                listNodes.get(j).val = temp;
            }
        }
    }
}
