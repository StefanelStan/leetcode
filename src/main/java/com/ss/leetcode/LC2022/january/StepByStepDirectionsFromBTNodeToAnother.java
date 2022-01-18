package com.ss.leetcode.LC2022.january;

import com.ss.leetcode.shared.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class StepByStepDirectionsFromBTNodeToAnother {
    // https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/submissions/
    /** Algorithm
     1. Get Lowest Common Ancestor. The closest node/root that holds both values
     2. From LCA, draw the paths to target and destination using L and R.
     3. The final Path will be created from a reverse pathRoStart and path to Destination.
     */
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode[] anc = new TreeNode[1];
        traverseTree(root, startValue, destValue, anc);
        // do some magic here to get the paths.
        return getPaths(anc[0], startValue, destValue);
    }

    // traverse Tree and detect LCA.
    private boolean traverseTree(TreeNode node, int start, int dest, TreeNode[] anc) {
        if(node == null) {
            return false;
        }
        boolean eqStart = (node.val == start);
        boolean eqDest = (node.val == dest);
        boolean inLeft = traverseTree(node.left, start, dest, anc);
        boolean inRight = traverseTree(node.right, start, dest, anc);
        // check on left and right subtree. if Left OR right subtree returns true and the node is
        // the startVal or destVal, this node is the LCA.
        if ((inLeft && inRight) ||  ((eqDest || eqStart) && (inLeft || inRight))) {
            if (anc[0] == null) {
                anc[0] = node;
            }
        }
        return (inLeft|| inRight || eqDest || eqStart);
    }

    private String getPaths(TreeNode ancestor, int start, int dest) {
        List<Character> rootToStart = new ArrayList<>();
        getPathToNode(ancestor, start, rootToStart, new boolean[]{false});
        List<Character> rootToDest = new ArrayList<>();
        getPathToNode(ancestor, dest, rootToDest, new boolean[]{false});
        StringBuilder stb = new StringBuilder();
        // usually root to start will be any combination of L/R. This will be all replaced by U as we go up and then down (left/right from LCA node)
        stb.append("U".repeat(rootToStart.size()));
        for (char c : rootToDest) {
            stb.append(c);
        }
        return stb.toString();
    }

    // from start, get the path to target node. Classic Preorder Traversal.
    private void getPathToNode(TreeNode node, int target, List<Character> path, boolean[] found) {
        if (found[0]) {
            return;
        }
        if (node.val == target) {
            found[0] = true;
            return;
        }
        if (node.left != null) {
            path.add('L');
            getPathToNode(node.left, target, path, found);
            if (!found[0]) {
                path.remove(path.size() -1);
            }
        }
        if (!found[0] && node.right != null) {
            path.add('R');
            getPathToNode(node.right, target, path, found);
            if(!found[0]) {
                path.remove(path.size() -1);
            }
        }
    }
}
