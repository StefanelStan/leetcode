package com.ss.leetcode.shared;

import java.util.Collections;
import java.util.List;

public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
        children = Collections.emptyList();
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
