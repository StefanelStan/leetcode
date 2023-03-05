package com.ss.leetcode.LC2023.march;

import com.ss.leetcode.shared.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthLargestSumInABinaryTree {
    // https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree
    /** Algorithm
        1. Traverse the tree and store each level' value or sum into a list<Long>.
        2. Each index in the list (0,1,2) will correspond to the level's sum
            EG: root will be list.get(0) and level 3 will be level.get(2)
        3. DFS and set each node or sum each node's value to its list/index correspondent
            EG: root = [5,8,9,2,1,3,7,4,6], k = 2
            List will be [5, 17, 13, 10] (level 0,1,2,3)
        4. If K > list.size(), return -1
        5. Sort the list
        6. Return list.get (size - k); (the kth element as distance from the end of the list(highest));
     */
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> levelSum =  new ArrayList<>();
        traverseTree(root, 1, levelSum);
        if (levelSum.size() < k) {
            return -1;
        }
        Collections.sort(levelSum);
        return levelSum.get(levelSum.size() - k);
    }

    private void traverseTree(TreeNode node, int level, List<Long> levelSum) {
        if (node == null) {
            return;
        }
        if (level > levelSum.size()) {
            levelSum.add(0L);
        }
        levelSum.set(level -1, levelSum.get(level - 1) + node.val);
        traverseTree(node.left, level +1, levelSum);
        traverseTree(node.right, level +1, levelSum);
    }
}
