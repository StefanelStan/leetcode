package com.ss.leetcode.LC2022.july;

import com.ss.leetcode.shared.TreeNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicateSubtrees {
    // https://leetcode.com/problems/find-duplicate-subtrees/
    // Could also be done via basic order serialisation: inOrder: get the ir-order String serialisation and put it to a map.
    // EG: 1 -> List<Nodes>
    // "1, null, 2" ->
    // "1, 2, null" ->  etc.
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root.left == root.right) {
            return new ArrayList<>();
        }
        List<TreeNode>[] nodeSizes = new List[10001];
        Set<TreeNode> allNodes = new HashSet<>();
        traverseAndSetLevelNodes(root, nodeSizes, allNodes);
        Set<TreeNode> duplicates = new HashSet<>();
        for (int i = 1; i < nodeSizes.length; i++) {
            if (nodeSizes[i] != null && nodeSizes[i].size() > 1) {
                checkForDuplicates(nodeSizes[i], allNodes, duplicates);
            }
        }
        return new ArrayList<>(duplicates);
    }

    private void checkForDuplicates(List<TreeNode> nodeSize, Set<TreeNode> allNodes, Set<TreeNode> duplicates) {
        boolean[] vettedDuplicate = new boolean[nodeSize.size()];
        for (int i = 0; i < nodeSize.size() - 1; i++) {
            if (allNodes.contains(nodeSize.get(i)) && !vettedDuplicate[i]) {
                for (int j = i + 1; j < nodeSize.size(); j++) {
                    if (!vettedDuplicate[j] && isDuplicatedNode(nodeSize.get(i), nodeSize.get(j))) {
                        removeCompleteSubtree(nodeSize.get(j), allNodes);
                        vettedDuplicate[i] = true;
                        vettedDuplicate[j] = true;
                    }
                }
            }
            if (vettedDuplicate[i]) {
                addCompleteSubtreeToDuplicates(nodeSize.get(i), duplicates, allNodes);
            }
        }
    }

    private boolean isDuplicatedNode(TreeNode node, TreeNode other) {
        if (node == other) {
            return true;
        }
        if (node == null || other == null || node.val != other.val) {
            return false;
        }
        return isDuplicatedNode(node.left, other.left) && isDuplicatedNode(node.right, other.right);
    }

    private void addCompleteSubtreeToDuplicates(TreeNode node, Set<TreeNode> duplicates, Set<TreeNode> allNodes) {
        if (node != null && allNodes.remove(node)) {
            duplicates.add(node);
            addCompleteSubtreeToDuplicates(node.left, duplicates, allNodes);
            addCompleteSubtreeToDuplicates(node.right, duplicates, allNodes);
        }
    }

    private void removeCompleteSubtree(TreeNode node, Set<TreeNode> allNodes) {
        if (node != null) {
            allNodes.remove(node);
            removeCompleteSubtree(node.left, allNodes);
            removeCompleteSubtree(node.right, allNodes);
        }
    }

    private int traverseAndSetLevelNodes(TreeNode node, List<TreeNode>[] nodeSizes, Set<TreeNode> allNodes) {
        if (node == null) {
            return 0;
        } else if (node.left == node.right) {
            allNodes.add(node);
            if (nodeSizes[1] == null) {
                nodeSizes[1] = new ArrayList<>();
            }
            nodeSizes[1].add(node);
            return 1;
        }
        int total = 1 + traverseAndSetLevelNodes(node.left, nodeSizes, allNodes) + traverseAndSetLevelNodes(node.right, nodeSizes, allNodes);
        allNodes.add(node);
        if (nodeSizes[total] == null) {
            nodeSizes[total] = new ArrayList<>();
        }
        nodeSizes[total].add(node);
        return total;
    }

    /**
    public List<TreeNode> findDuplicateSubtrees2(TreeNode root) {
        Set<TreeNode> duplicated = new HashSet<>();
        Set<TreeNode> alreadyAdded = new HashSet<>();
        List<TreeNode>[] nodeGroups = new List[401];
        traverseTree(root, nodeGroups, duplicated, alreadyAdded);
        return new ArrayList<>(duplicated);
    }

    private void traverseTree(TreeNode node, List<TreeNode>[] nodeGroups, Set<TreeNode> duplicates,
        Set<TreeNode> alreadyAdded) {
        if (node == null) {
            return;
        }
        int nodeVal = node.val + 200;
        if (nodeGroups[nodeVal] == null) {
            nodeGroups[nodeVal] = new ArrayList<>();
            nodeGroups[nodeVal].add(node);
            traverseTree(node.left, nodeGroups, duplicates, alreadyAdded);
            traverseTree(node.right, nodeGroups, duplicates, alreadyAdded);
        } else {
            boolean isDuplicated = false;
            for (TreeNode other : nodeGroups[nodeVal]) {
                isDuplicated = isDuplicated(node, other, node, other);
                if (isDuplicated) {
                    if (!duplicates.contains(other)) {
                        addToAlreadyAdd(node, alreadyAdded);
                        addDuplicatedNodes(other, duplicates, alreadyAdded);
                    } else {
                        addToAlreadyAdd(node, alreadyAdded);
                    }
                    break;
                }
            }
            if (!isDuplicated) {
                nodeGroups[nodeVal].add(node);
                traverseTree(node.left, nodeGroups, duplicates, alreadyAdded);
                traverseTree(node.right, nodeGroups, duplicates, alreadyAdded);
            }
        }

    }

    private void addToAlreadyAdd(TreeNode node, Set<TreeNode> alreadyAdded) {
        if (node != null && alreadyAdded.add(node)) {
            addToAlreadyAdd(node.left, alreadyAdded);
            addToAlreadyAdd(node.right, alreadyAdded);
        }
    }

    private void addDuplicatedNodes(TreeNode node, Set<TreeNode> duplicates, Set<TreeNode> alreadyAdded) {
        if (node == null || duplicates.contains(node)) {
            return;
        }
        duplicates.add(node);
        addDuplicatedNodes(node.left, duplicates, alreadyAdded);
        addDuplicatedNodes(node.right, duplicates, alreadyAdded);
    }

    private boolean isDuplicated(TreeNode node, TreeNode other, TreeNode original, TreeNode otherOriginal) {
        if (node == null && other == null) {
            return true;
        }
        if (node == null || other == null || node.val != other.val || other == original) {
            return false;
        }

        return isDuplicated(node.left, other.left, original, otherOriginal) && isDuplicated(node.right, other.right, original, otherOriginal);
    }

    private void addDuplicates(TreeNode node, Set<TreeNode> duplicates, Set<TreeNode> alreadyAdded) {
        if (node != null) {
            if (!duplicates.contains(node) && !alreadyAdded.contains(node)) {
                duplicates.add(node);
            }
            addDuplicates(node.left, duplicates, alreadyAdded);
            addDuplicates(node.right, duplicates, alreadyAdded);
        }
    }
    */

    /**
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root.left == root.right) {
            return new ArrayList<>();
        }
        Set<TreeNode>[] nodeMap = new Set[401];
        Set<TreeNode> duplicates = new HashSet<>();
        Set<TreeNode> leftOvers = new HashSet<>();
        traverseAndCheck(root, nodeMap, duplicates, leftOvers);
        return new ArrayList<>(duplicates);
    }

    private void traverseAndCheck(TreeNode node, Set<TreeNode>[] nodeMap, Set<TreeNode> duplicates, Set<TreeNode> leftOvers) {
        if (node == null) {
            return;
        }
        if (nodeMap[node.val + 200] == null) {
            nodeMap[node.val + 200] = new HashSet<>();
            nodeMap[node.val + 200].add(node);
        } else {
            Set<TreeNode> list = nodeMap[node.val + 200];
            for (TreeNode other : list) {
                if (!duplicates.contains(other) && !leftOvers.contains(node) && !duplicates.contains(node) && isDuplicatedSubtree(node, other)) {
                    addAllDuplicates(other, duplicates, leftOvers);
                    leftOvers.add(node);
                    list.remove(node);
                    list.remove(other);
                    return;
                }
            }
            list.add(node);
        }
        traverseAndCheck(node.left, nodeMap, duplicates, leftOvers);
        traverseAndCheck(node.right, nodeMap, duplicates, leftOvers);
    }

    private boolean isDuplicatedSubtree(TreeNode node, TreeNode other) {
        if (node == other) {
            return true;
        }
        if (node == null || other == null || node.val != other.val || node.left == other
            || node.right == other || other.left == node || other.right == node) {
            return false;
        }
        return isDuplicatedSubtree(node.left, other.left) && isDuplicatedSubtree(node.right, other.right);
    }


    private void addAllDuplicates(TreeNode node, Set<TreeNode> duplicates, Set<TreeNode> leftOvers) {
        if (node != null && !leftOvers.contains(node)) {
            if (duplicates.add(node)) {
                leftOvers.add(node);
                addAllDuplicates(node.left, duplicates, leftOvers);
                addAllDuplicates(node.right, duplicates, leftOvers);
            }
        }
    }
     */
}
