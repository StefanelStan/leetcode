package com.ss.leetcode.LC2023.april;

import com.ss.leetcode.shared.TreeNode;

public class NumberOfGoodLeafNodesPairs {
    // https://leetcode.com/problems/number-of-good-leaf-nodes-pairs
    /** Algorithm
        1. If distance is 1, return 0 as no pairs can be found with distance 1
        2. Apply a POST ORDER traversal: each subtree will push up an int[10] that describes/counts the distances up to 9.
            EG: [5,6,7], k = 5
            - 6 will push up [0,1..] describing that is has 1 distance of 1
            - 7 will push up [0,1..] describing that it has 1 distance of 1
        3. The parent node (postorder) will take the 2 arrays and calculate the distances.
            1 distance of 1 and 1 distance of 1 (1 * 1) = 1 distance of 2 <= 5 so we can increase the count by 1
        4. Now the parent node will have to MERGE, SHIFT and push these distances UP to be processed by its parent
        5. MERGING : the parent node has to push up a summary of the distances.
            so [0,1,..] + [0,1..] will become [0,2,..] two distances of 1.
        6. SHIFTING: As we are moving away from the leafs, the distances also increase, thus the 2 distance of 1 become 1 distance of 2. (Shift right by 1).
            [0,2...] => [0,0,2..]
        7. #5 and #6 can be done in one go: res[i+1] = left[i] + right[i].
        8. Return the count of distances.
     */
    public int countPairs(TreeNode root, int distance) {
        if (distance == 1) {
            return 0;
        }
        int[] count = {0};
        traverseTree(root, distance, count);
        return count[0];
    }

    private int[] traverseTree(TreeNode node, int distance, int[] count) {
        if (node == null) {
            return new int[10];
        }
        if (node.left == null && node.right == null) {
            return new int[]{0,1,0,0,0,0,0,0,0,0};
        }
        int[] leftDistances = traverseTree(node.left, distance,count);
        int[] rightDistances = traverseTree(node.right, distance, count);
        for (int i = 1; i <= distance - 1; i++) {
            if (leftDistances[i] > 0) {
                for (int j = distance - i; j >= 1; j--) {
                    count[0] += (rightDistances[j] == 0 ? 0 : (leftDistances[i] * rightDistances[j]));
                }
            }
        }
        for (int i = 9; i >= 1; i--) {
            leftDistances[i] = leftDistances[i-1] + rightDistances[i-1];
        }
        return leftDistances;
    }

    public int countPairs2(TreeNode root, int distance) {
        if (distance == 1) {
            return 0;
        }
        int[] count = {0};
        traverseTree2(root, distance, count);
        return count[0];
    }

    private int[] traverseTree2(TreeNode node, int distance, int[] count) {
        int[] distances = null;
        if (node != null) {
            if (node.left == node.right) {
                distances = new int[10];
                distances[1] = 1;
            } else {
                int[] left = traverseTree(node.left, distance, count);
                int[] right = traverseTree(node.right, distance, count);
                distances = left == null || right == null
                    ? shiftDistances(left == null ? right : left)
                    : countAndMergeDistances(left, right, distance, count);
            }
        }
        return distances;
    }

    private int[] countAndMergeDistances(int[] left, int[] right, int distance, int[] count) {
        count[0] += countDistances(left, right, distance);
        return mergeDistances(left, right);
    }

    private int countDistances(int[] left, int[] right, int distance) {
        int count = 0;
        for (int l = distance - 1; l >= 1; l--) {
            for (int r =  distance - l; r >= 1; r--) {
                count += left[l] * right[r];
            }
        }
        return count;
    }

    private int[] mergeDistances(int[] left, int[] right) {
        for (int i = 9; i >= 1; i--) {
            right[i] = left[i-1] + right[i-1];
        }
        return right;
    }

    private int[] shiftDistances(int[] dist) {
        for (int i = 9; i >= 1; i--) {
            dist[i] = dist[i - 1];
        }
        return dist;
    }
}
