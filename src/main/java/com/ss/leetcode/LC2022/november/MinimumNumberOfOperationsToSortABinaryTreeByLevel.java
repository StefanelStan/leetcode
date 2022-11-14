package com.ss.leetcode.LC2022.november;

import com.ss.leetcode.shared.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfOperationsToSortABinaryTreeByLevel {
    // https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level
    /** Algorithm
         1. How to count the swaps of a list/array? [7,5,1,2]
            a) on position[0] we need the min nr which is 1: put 1 on [0] and 7 on position[2] -> 1,5,7,2
            b) on position[1] we need next nr which is 2. move 2 on pos[1] and 5 on pos[3] -> 1,2,7,5
            c) on pos[3] we need 5, so move 5 to pos[2] and 7 to pos[3].
            Now it is sorted in 3 swaps/moves.
         2. Following this, we need to do the same on each level of the binary tree.
         3. Because the number are unique, we can keep track of them in an allLevelOrder int[3][100_001].
         4. row[0] will track the level in the tree at which node of value[i] exists
            row[1] will track the position of node of value[i] in his level.
             row[2] will track how many nodes were "sorted" on level[index].
            EG: level 30, nodes: [2,1,3].
             allLevelNodes[2][30] = 0 -> no nodes have been sorted
            when we put 1 on position[0], means we have sorted one element, we increase allLevelNodes[2][30] by1
         5. Traverse from min to max (1 to 100_001) and check if the current node sits at the right insertion position in its level. If not, swap it to that position and mark the position.
     */

    public int minimumOperations(TreeNode root) {
        if (root.left == root.right) {
            return 0;
        }
        // row0 will store the level on the tree can can point to the correct List<TreeNode>
        // row1 will store the order (left to right) on which the nodes exist on the same level in the tree
        // row2 is used for performance trick: it will remember how many nodes have been sorted/resolved/ordered
        // suppose we have these nodes on level 30: [7,5,1,2]
        // when we swap 7 with 1, we put 1 on the position pointed by allLevelOrder[3][30].
        // as we have "sorted" this first node, we need to figure out what comes on next position on level 30
        // so we need to increase allLevelOrder[3][30] by 1, flagging that we sorted the first pos and we need to
        // figure out what comes on position2, position3 etc. Knowing the last modification indes will save us
        // time from having to loop from beginning and compare
        int[][] allLevelOrder = new int[3][100_001];
        allLevelOrder[0][0] = 100_001;
        List<List<TreeNode>> nodes = new ArrayList<>();
        traverseTree(root, 1, nodes, allLevelOrder);
        return getMinNumberOfOperations(nodes, allLevelOrder);
    }

    // create a List<List<TreeNode>> to store each nodes by level. List.get(4) will store the nodes at level 4
    private void traverseTree(TreeNode node, int level, List<List<TreeNode>> nodes, int[][] allLevelOrder) {
        if (node == null) {
            return;
        }
        if (level >= nodes.size()) {
            nodes.add(new ArrayList<>());
        }
        List<TreeNode> levelNodes = nodes.get(level - 1);
        allLevelOrder[0][node.val] = level - 1;
        allLevelOrder[1][node.val] = levelNodes.size();
        // for optimisation keep track of min and max value found in the whole tree
        allLevelOrder[0][0] = Math.min(allLevelOrder[0][0], node.val);
        allLevelOrder[1][0] = Math.max(allLevelOrder[1][0], node.val);
        levelNodes.add(node);
        traverseTree(node.left, level + 1, nodes, allLevelOrder);
        traverseTree(node.right, level + 1, nodes, allLevelOrder);
    }

    private int getMinNumberOfOperations(List<List<TreeNode>> nodes, int[][] allLevelOrder) {
        int minOps = 0, level;
        // iterate over each value from 1 to max. For each value, check if it is lesser than the current
        // insertion index for its level.
        for (int i = allLevelOrder[0][0]; i <= allLevelOrder[1][0]; i++) {
            level = allLevelOrder[0][i];
            if (level > 0) { // we don't need to sort the root
                TreeNode currentLevelNode = nodes.get(level).get(allLevelOrder[2][level]);
                // level nodes are 4,5,3,10 and i = 3. In this case, it detects that the level has a node with
                // value 4 at index[0], which is greater than 3. 3 needs to be put at index 0 and whatever is at index
                // 0 will be put instead of 3.
                if (i < currentLevelNode.val) {
                    // swap the two nodes. Put the min at the right front position and this high value node in the back,
                    TreeNode iNode = nodes.get(level).get(allLevelOrder[1][i]);
                    swapNodeValues(iNode, currentLevelNode);
                    swapOrderInSameLevel(allLevelOrder, iNode.val, currentLevelNode.val);
                    minOps++;
                    // swap the two values AND the order in the [1][i];
                }
                allLevelOrder[2][level]++;
            }
        }
        return minOps;
    }

    private void swapNodeValues(TreeNode lowValueNode, TreeNode highValueNode) {
        int temp = highValueNode.val;
        highValueNode.val = lowValueNode.val;
        lowValueNode.val = temp;
    }

    private void swapOrderInSameLevel(int[][] allLevelOrder, int iNode, int currentLevelNode) {
        int temp = allLevelOrder[1][iNode];
        allLevelOrder[1][iNode] = allLevelOrder[1][currentLevelNode];
        allLevelOrder[1][currentLevelNode] = temp;
    }
}
