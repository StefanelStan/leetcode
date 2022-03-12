package com.ss.leetcode.shared;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NodeWithRandom {
    public int val;
    public NodeWithRandom next;
    public NodeWithRandom random;

    public NodeWithRandom(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public static NodeWithRandom makeChain(Integer[][] values) {
        List<NodeWithRandom> nodes = new ArrayList<>();
        nodes.add(new NodeWithRandom(values[0][0]));
        for (int i = 1; i < values.length; i++) {
            nodes.add(new NodeWithRandom(values[i][0]));
            nodes.get(i-1).next = nodes.get(i);
        }
        for(int i = 0; i < values.length; i++) {
            if(values[i][1] != null) {
                nodes.get(i).random = nodes.get(values[i][1]);
            }
        }
        return nodes.get(0);
    }

    public List<String> asList() {
        List<String> list = new ArrayList<>();
        NodeWithRandom head = this;
        NodeWithRandom head2 = this;
        Map<NodeWithRandom, Integer> orderMap = new HashMap<>();
        while(head != null) {
            orderMap.put(head, orderMap.size());
            head = head.next;
        }
        while(head2 != null) {
            list.add(String.format("[%s, %s]", head2.val, (head2.random == null ? null : orderMap.get(head2.random))));
            head2 = head2.next;
        }
        return list;
    }
}
