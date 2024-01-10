package com.ss.leetcode.LC2022.september;

import com.ss.leetcode.shared.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class AmountOfTimeForBinaryTreeToBeInfected {
    // https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
    // BETTER MODE
    public int amountOfTime(TreeNode root, int start) {
        TreeNode[] parents = new TreeNode[100_001];
        boolean[] visited = new boolean[100_001];
        TreeNode[] startNode = new TreeNode[1];
        getParentsAndStart(root, start, parents, startNode);
        visited[start] = true;
        return Math.max(infectNode(parents[start], 0, parents, visited), Math.max(infectNode(startNode[0].left, 0, parents, visited),
            infectNode(startNode[0].right, 0, parents, visited)));
    }

    private int infectNode(TreeNode node, int time, TreeNode[] parents, boolean[] visited) {
        if (node == null || visited[node.val]) {
            return time;
        }
        time++;
        visited[node.val] = true;
        return Math.max(infectNode(parents[node.val], time, parents, visited),
            Math.max(infectNode(node.left, time, parents, visited), infectNode(node.right, time, parents, visited)));
    }

    private void getParentsAndStart(TreeNode node, int start, TreeNode[] parents, TreeNode[] startNode) {
        if (node != null) {
            if (node.val == start) {
                startNode[0] = node;
                return;
            }
            if (node.left != null) {
                parents[node.left.val] = node;
                getParentsAndStart(node.left, start, parents, startNode);
            }
            if (node.right != null) {
                parents[node.right.val] = node;
                getParentsAndStart(node.right, start, parents, startNode);
            }
        }
    }

    /** Algorithm
         1. If root has no children, return 0 (single node)
         2. Else it is one of the nodes, so the tree has to be traversed and each node infected/transmitted
         3. For quick access, you will need to map each node to its parent, as infection will go upwards too
            You can use a TreeNode[100_001] or Map<Integer, TreeNode> (childVal - parent)
         4. While infecting, you also need to know which nodes have ben already infected, so you can use
         a boolean[100_001] or Set<TreeNode> to mark the infected nodes
         5. The infection process: There will be a list of "contagious" nodes that will spread the infection
            in 3 directions: parent and two children.
         6. With each iteration, increase the global time and loop through the new contagious list and for each node
             - create a new list of newly contagious nodes
             - mark the node as infected
             - if parent is not infected, add it to the list of newly contagious
             - if left/right child is not infected, add them as well
         7. If the "newly" contaigious list is not empty, recall this function with this new list.
     */
    public int amountOfTime2(TreeNode root, int start) {
        int[] timeForInfection = {0};
        if (root.left == root.right) {
            return timeForInfection[0];
        } else {
            TreeNode[] parents = mapNodesToParents(root);
            TreeNode sickNode = start == root.val ? root : getChildOfIndex(parents, start);
            traverseAndInfect(parents, List.of(sickNode), new boolean[100_001], timeForInfection);
        }
        return timeForInfection[0] - 1;
    }

    private TreeNode[] mapNodesToParents(TreeNode node) {
        TreeNode[] parents = new TreeNode[100_001];
        traverseAndMap(node, parents);
        return parents;
    }

    private TreeNode getChildOfIndex(TreeNode[] parents, int childVal) {
        if (parents[childVal].left != null && parents[childVal].left.val == childVal) {
            return parents[childVal].left;
        } else {
            return parents[childVal].right;
        }
    }

    private void traverseAndMap(TreeNode node, TreeNode[] parents) {
        if (node.left != null) {
            parents[node.left.val] = node;
            traverseAndMap(node.left, parents);
        }
        if (node.right != null) {
            parents[node.right.val] = node;
            traverseAndMap(node.right, parents);
        }
    }

    private void traverseAndInfect(TreeNode[] parents, List<TreeNode> sickNodes, boolean[] infected, int[] timeForInfection) {
        List<TreeNode> nextToInfect = new ArrayList<>(sickNodes.size() * 3);
        timeForInfection[0]++;
        for (TreeNode sickNode : sickNodes) {
            // infect current Node
            infected[sickNode.val] = true;
            // try to infect the parent
            if (parents[sickNode.val] != null && !infected[parents[sickNode.val].val]) {
                nextToInfect.add(parents[sickNode.val]);
            }
            // try to infect the two children
            if (sickNode.left != null && !infected[sickNode.left.val]) {
                nextToInfect.add(sickNode.left);
            }
            if(sickNode.right != null && !infected[sickNode.right.val]) {
                nextToInfect.add(sickNode.right);
            }
        }
        if (!nextToInfect.isEmpty()) {
            traverseAndInfect(parents, nextToInfect, infected, timeForInfection);
        }
    }
}
