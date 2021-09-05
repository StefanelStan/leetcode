package com.ss.leetcode.september;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LockingTree {
    // https://leetcode.com/contest/biweekly-contest-60/problems/operations-on-tree/
    // https://leetcode.com/problems/operations-on-tree/
    private final int[] parents;
    private final Map<Integer, LockableNode> nodes = new HashMap<>();
    public LockingTree(int[] parent) {
        this.parents =  parent;
        nodes.put(0, new LockableNode());
        for (int i = 1; i < parents.length; i++) {
            LockableNode newNode = new LockableNode();
            nodes.put(i, newNode);
        }
        for (int i = 1; i < parent.length; i++) {
            nodes.get(parent[i]).children.add(nodes.get(i));
        }
    }

    public boolean lock(int num, int user) {
        LockableNode node = nodes.get(num);
        if (node == null || node.locked) {
            return false;
        } else {
            node.locked = true;
            node.lockBy = user;
            return true;
        }
    }

    public boolean unlock(int num, int user) {
        LockableNode node = nodes.get(num);
        if (node == null || node.lockBy != user || !node.locked) {
            return false;
        } else {
            node.locked = false;
            node.lockBy = -1;
            return true;
        }
    }

    public boolean upgrade(int num, int user) {
        LockableNode node = nodes.get(num);
        if (node == null || node.locked) {
            return false;
        }
        if (!hasOneLockedDescendant(num)) {
            return false;
        }

        if(!hasLockedAncestors(num)) {
            node.locked = true;
            unlockAllDescendants(node);
            return true;
        } else return false;
    }

    private void unlockAllDescendants(LockableNode node) {
        for (LockableNode child : node.children) {
            child.locked = false;
            child.lockBy = -1;
            unlockAllDescendants(child);
        }
    }

    private boolean hasLockedAncestors(int num) {
        if (num == 0) {
            return nodes.get(0).locked;
        }
        int parInt = parents[num];
        LockableNode parent = nodes.get(parInt);
        if (parent.locked) {
            return true;
        } else return hasLockedAncestors(parInt);
    }

    private boolean hasOneLockedDescendant(int num) {
        boolean[] oneLockedDesc = {false};
        LockableNode node = nodes.get(num);
        for (LockableNode child : node.children) {
            if (!oneLockedDesc[0]) {
                findOneLockedDesc(child, oneLockedDesc);
            }
        }
        return oneLockedDesc[0];
    }

    private void findOneLockedDesc(LockableNode node, boolean[] oneLockedDesc) {
        if (oneLockedDesc[0] || node.locked) {
            oneLockedDesc[0] = true;
            return;
        }
        for (LockableNode child : node.children) {
            if (!oneLockedDesc[0]) {
                findOneLockedDesc(child, oneLockedDesc);
            }
        }
    }

    private static class LockableNode {
        boolean locked;
        int lockBy;
        List<LockableNode> children = new ArrayList<>();
    }
}
